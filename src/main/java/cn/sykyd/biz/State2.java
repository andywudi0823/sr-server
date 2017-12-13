package cn.sykyd.biz;

import cn.sykyd.db.mapper.CsdSecuritiesMapper;
import cn.sykyd.db.mapper.CsdTicketsMapper;
import cn.sykyd.db.model.CsdTickets;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/*
* {"mac":"","type":X,"data":{}}
* {"mac":"aaa","type":2,"data":{"unit_id":2,"id":1,"row":1,"column":5,"status":1}}
type=2 票机状态改变
data中内容
id 设备ID 为STM32板子上的4位拨码开关 范围是0-15
row 行数 票机柜行数 范围是1-6
column 列数 票机柜列数 范围是1-10
status 状态 1：表示设备放下  0：表示设备抬起
*
* */
public class State2 implements IState {
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
            CsdTicketsMapper csdTicketsMapper = sqlSession.getMapper(CsdTicketsMapper.class);
            // 更新防区状态

            CsdTickets csdTickets = new CsdTickets();
            csdTickets.fromJSONObject(o.getJSONObject("data"));
            csdTickets.setModified(new Long(System.currentTimeMillis()).toString());
            csdTicketsMapper.updateStatusByParam(csdTickets);

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
