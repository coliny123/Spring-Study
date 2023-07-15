package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;    // GET
    private final String urlPath;   // /calculate
    private String queryString;     // operand1=11&operator=*&operand2=55   //우리는 key,value,key,value,key,value로 나뉘어져있길 원함 so, queryString 객체 만듬
    /*
        RequestLine(GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1)에 들어있는 정보
         - HttpMethod
         - path
         - queryString
         - ....
         */
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");     // HttpMethod, path&queryString, 프로토콜로 split됨
        this.method = tokens[0];
        String[] urlPathTokens = tokens[1].split("\\?");    // ?를 사용하고 싶으면 \\뒤에 적어줘야함
        this.urlPath = urlPathTokens[0];

        if(urlPathTokens.length == 2){
            this.queryString = urlPathTokens[1];
        }
    }

    // test위한 생성자
    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    // 객체간 비교할 때는 equals() and hashCode() 있어야 함!!!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
