package com.npf.knowledge.demo.design.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.reactor
 * @ClassName: Reactor
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/15 17:51
 * @Version: 1.0
 */
public class Reactor implements Runnable {

    final Selector selector;
    final ServerSocketChannel socketChannel;

    public Reactor(int port) throws IOException {
        selector = Selector.open();
        socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(port));
        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Runnable() {
            public void run() {

                SocketChannel accept = null;
                try {
                    accept = socketChannel.accept();
                    if(accept != null)
                        new Handler(selector,accept);
                } catch (IOException e) {
                    System.out.println("已经断开IO链接！");
                }
            }
        });
    }




    public void run() {

        while(!Thread.interrupted()){
            try {
                if(selector.select()>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while(iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        Runnable runnable = (Runnable) selectionKey.attachment();
                        if(runnable !=null ){
                            runnable.run();
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
