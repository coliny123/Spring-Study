package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
요구사항
• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
• 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    // 1st 생각나는대로 학점계산기 도메인 구성하는 객체 도출 : 이수한 과목(객체지향프로그래밍, 자료구조, 실용중국어), 학점 계산기
    // 2nd 객체간 관계 : 이수한 과목을 가지고 학점을 계산 -> 학점 계산기가 이수한 과목을 instance로 갖음
    // 3rd 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 :
    // 이수한 과목 -> 객체지향프로그래밍, 자료구조, 실용중국어 (동적인 객체들) --> 과목(코스)클래스 (정적인 타입으로 추상화)

    // 핵심 포인트 //
    // 이수한 과목을 인자로 전달하여 평균학점 계산 요청 ----> 학점 계산기 -----> (학점수×교과목 평점)의 합계 와 -----> 과목(코스) 일급 컬렉션
    //                                                          -----> 수강신청 총학점 수를 요청     -----> 과목(코스)
    //                                        <---리턴-- 나누기만 해서 <----- 과목(코스)

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("객체지향프로그래밍", 3, "A+"),
                new Course("자료구조", 3, "A+"),
                new Course("실용중국어", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses); // 이수한 과목을 학점 계산기에게 인자로 전달
        double gradeResult = gradeCalculator.calculateGrade();  // 평균학점 계산 요청 = 메소드 호출

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
