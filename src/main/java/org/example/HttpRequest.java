package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpHeaders;

public class HttpRequest {

    /*
        httprequest와 httpresponse의 임의 세팅 이유 : 프로토콜에 맞게 request 객체 생성, response 객체 생성해서 client와 server 간의 통신을 구현
    */
    private final RequestLine requestLine;
    // 사실 http 프로토콜의 구조상 header와 body부분도 구현해야 했지만 requestline의 과정 구현 위해 생략
    // 프로토콜로 들어온 BufferedReader를 전달을 해서 그 프로토콜 규칙에 맞게 객체를 초기화하는 과정이었음
    //private final HttpHeaders httpHeaders;
    //private final Body body;


    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();  // HttpRequest가 아닌 requestLine이 판단하도록 보냄
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }


    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
