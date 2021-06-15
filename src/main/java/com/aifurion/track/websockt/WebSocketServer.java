package com.aifurion.track.websockt;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：zzy
 * @description：TODO websocket实时更新挂号信息
 * @date ：2021/4/7 20:34
 */
@ServerEndpoint("/websocket/{name}")
@RestController
public class WebSocketServer {

    //存储客户端的连接对象,每个客户端连接都会产生一个连接对象
    private static ConcurrentHashMap map = new ConcurrentHashMap();
    //每个连接都会有自己的会话
    private Session session;
    private String name;

    @OnOpen
    public void open(@PathParam("name") String name, Session session) {
        map.put(name, this);
        System.out.println(name + "连接服务器成功");
        System.out.println("客户端连接个数:" + getConnetNum());

        this.session = session;
        this.name = name;
    }

    @OnClose
    public void close() {
        map.remove(name);
        System.out.println(name + "断开了服务器连接");
    }

    @OnError
    public void error(Throwable error) {
        error.printStackTrace();
        System.out.println(name + "出现了异常");
    }

    @OnMessage
    public void getMessage(String message) throws IOException {
        System.out.println("收到registrarid为" + name + "的挂号提醒" );
        System.out.println("客户端连接个数:" + getConnetNum());

        /**
         * 发送数据到医生客户端
         */
        Set<Map.Entry<String, WebSocketServer>> entries = map.entrySet();
        for (Map.Entry<String, WebSocketServer> entry : entries) {
            if (entry.getKey().equals(message)) {
                entry.getValue().send(message);
            }
        }
        System.out.println(message);



    }

    public void send(String message) throws IOException {
        if (session.isOpen()) {
            session.getBasicRemote().sendText(message);
        }
    }

    public int getConnetNum() {
        return map.size();
    }
}