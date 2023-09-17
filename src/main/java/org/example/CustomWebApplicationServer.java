package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    // 로그 추가
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {    // ServerSocket을 통해 해당하는 port로 server를 띄움(serverSocket만듬)
            logger.info("[CustomWebApplicationServer] started {} port.", port); // server 시작 log남기기

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");    // client 생성될 때 log남기기

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");   // 연결되면 log남기기
                // step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
