package org.example;

import java.io.IOException;

// GET /calculate?operand1=11&operator=*&operand2=55       을 받으면 결과값 리턴해줌
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }

}