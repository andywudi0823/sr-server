package cn.sykyd.biz;

import cn.sykyd.db.mapper.CsdSecuritiesMapper;
import cn.sykyd.db.mapper.CsdSecurityLogsMapper;
import cn.sykyd.db.model.CsdSecurities;
import cn.sykyd.db.model.CsdSecurityLogs;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.math.BigInteger;
import java.nio.LongBuffer;

/*
* {"mac":"","type":X,"data":{}}
* {"mac":"aaaa", "type":1, "data":{"room_id":9,"security_zone":0,"unit_id":2,"status":0}}
type=1 安防状态改变
data中内容
room_id 房间ID代表对应的新旧票据库
security_zone 防区ID 其中防区1代表 人体红外 防区2 代表无线门磁  防区4代表 玻璃破碎
status 防区状态  1：代表报警状态  0：代表为报警或以撤防
*
* */


public class State1 implements IState {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Override
    public void exec(JSONObject o) {

        //获取sqlsession
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            //获取mapper接口代理对象
            CsdSecuritiesMapper securityMapper = sqlSession.getMapper(CsdSecuritiesMapper.class);
            CsdSecurityLogsMapper securityLogsMapper = sqlSession.getMapper(CsdSecurityLogsMapper.class);
            // 更新防区状态
            CsdSecurities csdSecurities = new CsdSecurities();
            csdSecurities.fromJSONObject(o.getJSONObject("data"));
            csdSecurities.setModified(new Long(System.currentTimeMillis()).toString());
            securityMapper.updateStatusByUnitIdSecurityZoneRoomId(csdSecurities);

            // 添加日志
            CsdSecurityLogs csdSecurityLogs = new CsdSecurityLogs();
            csdSecurityLogs.fromJSONObject(o.getJSONObject("data"));
            csdSecurityLogs.setCreated(new Long(System.currentTimeMillis()).toString());
            System.out.println(csdSecurityLogs.getCreated());
            securityLogsMapper.insertLog(csdSecurityLogs);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
