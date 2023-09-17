package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    /*
        httprequest와 httpresponse의 임의 세팅 이유 : 프로토콜에 맞게 request 객체 생성, response 객체 생성해서 client와 server 간의 통신을 구현
     */

    // WebAppServer니까 port 가짐
    private final int port;

    // 로그 추가
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {    // ServerSocket을 통해 해당하는 port로 server를 띄움(serverSocket만듬)
            logger.info("[CustomWebApplicationServer] started {} port.", port); // server 시작 log남기기

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");    // client 생성될 때 log남기기

            // serverSocket이 accept()로 client를 기다리게 함, client가 들어오면 clientSocket이 만들어져서 while문 안으로 들어옴
            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");   // 연결되면 log남기기
                // step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
