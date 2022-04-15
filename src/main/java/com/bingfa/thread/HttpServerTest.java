package com.bingfa.thread;

/**
 * @author Tan Lianwang
 * @title: HttpServerTest
 * @date 2022/4/14 17:23
 */
public class HttpServerTest {
    public static void main(String[] args) throws Exception {
        SimpleHttpServer.setPort(8080);
        SimpleHttpServer.setBasePath("/http");
       SimpleHttpServer.start();

    }
}
