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
