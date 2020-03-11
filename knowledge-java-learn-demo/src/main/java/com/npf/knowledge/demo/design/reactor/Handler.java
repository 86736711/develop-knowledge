package com.npf.knowledge.demo.design.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.reactor
 * @ClassName: Handler
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/15 18:13
 * @Version: 1.0
 */
public class Handler implements Runnable {

    final SocketChannel socketChannel;

    final SelectionKey selectionKey;

    static final int MAXIN = 1024, MAXOUT = 1024;

    ByteBuffer processBuffer;

    ByteBuffer input = ByteBuffer.allocate(MAXIN);
    ByteBuffer output = ByteBuffer.allocate(MAXOUT);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    public Handler(Selector selector,SocketChannel sc) throws IOException {
       this.socketChannel = sc;
       socketChannel.configureBlocking(false);
       selectionKey = socketChannel.register(selector,SelectionKey.OP_READ);
       selectionKey.attach(this);
       selector.wakeup();
    }


    public void run() {
        try {
            if (state == READING) read();
            else if (state == SENDING) send();
        } catch (IOException ex) { /* ... */ }
    }

    void read() throws IOException {

        Charset charset = Charset.forName("utf-8");

        socketChannel.read(input);

        System.out.println(charset.decode(input).toString());

        state = SENDING;

        String sender = "ok";
        output.put(sender.getBytes("utf-8"));
        // Normally also do first write now
        selectionKey.interestOps(SelectionKey.OP_WRITE); //第三步,接收write事件
    }
    void send() throws IOException {
        socketChannel.write(output);
        selectionKey.cancel(); //write完就结束了, 关闭select key
    }

}
