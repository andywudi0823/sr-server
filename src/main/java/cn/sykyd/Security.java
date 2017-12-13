package cn.sykyd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.concurrent.Executors;


/**
 * Created by andyw on 2017/7/20.
 */
public class Security {
    private int port = 8888;
    private int idleTime = 1800;
    private int bufferSize = 1024;
    private SocketAcceptor acceptor;

    public void start() {
        acceptor = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors() + 1);
        TextLineCodecFactory lineCodec = new TextLineCodecFactory(Charset.forName("GBK"), LineDelimiter.UNIX.getValue(), LineDelimiter.UNIX.getValue());
        lineCodec.setDecoderMaxLineLength(2 * 1024 * 1024);
        lineCodec.setEncoderMaxLineLength(2 * 1024 * 1024);
        // 设置日志输出工厂
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置请求和响应对象的编解码操作
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(lineCodec));
        //
        acceptor.getFilterChain().addLast("exceutor", new ExecutorFilter(Executors.newCachedThreadPool()));

        acceptor.setHandler(new ServerHandler());
        acceptor.setReuseAddress(true);
        acceptor.setBacklog(10240);
        acceptor.getSessionConfig().setReuseAddress(true);
        acceptor.getSessionConfig().setReadBufferSize(bufferSize);
        acceptor.getSessionConfig().setReceiveBufferSize(bufferSize);
        acceptor.getSessionConfig().setTcpNoDelay(true);
        acceptor.getSessionConfig().setSoLinger(-1);
        // 单位秒
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, idleTime);

        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void stop() {
        acceptor.dispose();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Sr Server Starting...");
        new Security().start();

    }
}