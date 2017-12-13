package cn.sykyd;

import cn.sykyd.biz.IState;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.nio.charset.Charset;

/**
 * Created by andywu on 2017/7/21.
 */
public class ServerHandler extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        System.out.println("Accept Msg");
        System.out.println(message.toString());
        JSONObject o = JSON.parseObject(message.toString());
        System.out.println("cn.sykyd.biz.State" + o.getString("method"));
        System.out.print("cn.sykyd.biz.State" + o.getInteger("type"));
        IState s = null;
        Class<?> c = Class.forName("cn.sykyd.biz.State" + o.getInteger("type"));
        s = (IState) c.newInstance();
        s.exec(o);
//        if (o.getInteger("type") == 1) {
//            JSONObject s = o.getJSONObject("data");
//            System.out.println(s.getInteger("room_id"));
//            System.out.println(s.getInteger("security_zone"));
////            SecurityModel sm = new SecurityModel();
////            sm.room_id = s.getInteger("room_id");
////            sm.security_zone = s.getInteger("security_zone");
////            sm.status = s.getInteger("status");
////            sm.execute();
//        } else if (o.getInteger("type") == 2) {
//            JSONObject s = o.getJSONObject("data");
//            System.out.println(s.getInteger("id"));
//            System.out.println(s.getInteger("row"));
//            System.out.println(s.getInteger("column"));
//            System.out.println(s.getInteger("status"));
////            TicketMachineModel t = new TicketMachineModel();
////            t.id = s.getInteger("id");
////            t.row = s.getInteger("row");
////            t.column = s.getInteger("column");
////            t.status = s.getInteger("status");
////            t.execute();
//        }
        // 根据传来的数据进行处理
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("SERVER=>messageSent:" + (String) message);
        super.messageSent(session, message);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("incoming client: " + session.getRemoteAddress());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        System.out.println("error");

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("server is closed");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("server is idle");
    }
}
