package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);
    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        /*
            step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
            -> 이것의 문제: Thread는 생성될 때마다 독립적인 Stack 메모리 공간을 할당 받아서 성능 하락!
            -> So, 미리 고정된 갯수의 Thread를 생성해두고 이를 재활용하는 방법을 선택!! : Thread Pool 기능
        */
        logger.info("[ClientRequestHandler] new Client {} started.", Thread.currentThread().getName());
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            // line by line으로 읽기위해 InputStream을 Reader로 바꿈!
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));  // so, InputStreamReader로 감싸주고 BufferedReader(line by line 읽기 위해)로 한 번 더 감쌈
            DataOutputStream dos = new DataOutputStream(out);
            HttpRequest httpRequest = new HttpRequest(br);


            // get요청이면서 path가 /calculate과 일치하면 querystrings을 갖고온다
            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();   // body 세팅위한 코드

                // response 세팅 구현
                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        }catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}
