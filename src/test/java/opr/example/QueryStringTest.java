package opr.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    // operand1=11&operator=*&operand2=55
    // List<QueryString> -> 일급컬렉션으로 가능!!
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1","11");
        assertThat(queryString).isNotNull();
    }
}
