package cn.sykyd;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import cn.sykyd.db.mapper.CsdSecuritiesMapper;
import cn.sykyd.db.model.CsdCabinets;
import cn.sykyd.db.mapper.CsdCabinetsMapper;

import java.util.ArrayList;
import java.util.List;

import cn.sykyd.db.model.CsdSecurities;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    public static void main(String[] args) {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        CsdSecuritiesMapper csdSecuritiesMapper = session.getMapper(CsdSecuritiesMapper.class);
        CsdSecurities csdSecurities = new CsdSecurities();
        List<CsdSecurities> rets = new ArrayList();
        rets = csdSecuritiesMapper.selectBySecurityZone(1);
        for (CsdSecurities ret : rets) {
            System.out.println(ret.getName());
        }

        csdSecurities.setSecurityZone(1);
        csdSecurities.setRoomId(1);
        csdSecurities.setStatus(2);
//        csdSecuritiesMapper.updateStatusBySecurityZoneRoomId(csdSecurities);
        session.close();
        return;
    }
}
