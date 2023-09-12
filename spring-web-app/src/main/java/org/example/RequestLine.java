package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;    // GET
    private final String urlPath;   // /calculate
    private QueryStrings queryStrings;     // operand1=11&operator=*&operand2=55   //우리는 key,value,key,value,key,value로 나뉘어져있길 원함 so, queryString 객체 만듬
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
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    // test위한 생성자
    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);   // QueryStrings에서 List<QueryString>로 split해줌
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    // 객체간 비교할 때는 equals() and hashCode() 있어야 함!!!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

}
