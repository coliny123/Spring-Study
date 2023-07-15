package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    // WebAppServer니까 port 가짐
    private final int port;

    // 로그 추가
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    // start()호출하며 WebAppServer 동작
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {    // ServerSocket을 통해 해당하는 port로 server를 띄움(serverSocket만듬)
            logger.info("[CustomWebApplicationServer] started {} port.", port); // server 시작 log남기기

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");    // client 생성될 때 log남기기

            // serverSocket이 accept()로 client를 기다리게 함, client가 들어오면 clientSocket이 만들어져서 while문 안으로 들어옴
            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");   // 연결되면 log남기기
                /*
                step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
                // inputstream과 outputstream 연결
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    // line by line으로 읽기위해 InputStream을 Reader로 바꿈!
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));  // so, InputStreamReader로 감싸주고 BufferedReader(line by line 읽기 위해)로 한 번 더 감쌈
                    DataOutputStream dos = new DataOutputStream(out);

                    /*
                     http 프로토콜 어떻게 생겼는지 구경위한 코드
                     즉, 이런 프로토콜이 들어왔을 때 파싱을 통해 어떤 요청인지 판단, 그런 판단에 맞게 스프링에 요청을 보내는 작업 수행 : tomcat!!
                     tomcat -> WebApplicationSocket을 간단한_ver로 만드는 과정
                     HttpRequest객체를 만들고 Request line을 추출하여 요청을 수행해보자!
                     */
                    String line;
                    while((line = br.readLine()) != ""){
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
