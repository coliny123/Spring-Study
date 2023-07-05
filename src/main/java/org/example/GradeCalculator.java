package org.example;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;  // 일급 컬렉션

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculateGrade() {
        /*
        일급 컬렉션으로 구현시 (학점수 * 교과목 평점)의 합계 부분을 일급 컬렉션에게 위임 가능
        일급 컬렉션이란 : 지금은 List<>형태로 된, 즉 Course를 여러개 가진 List로 된 Course 정보만 instance변수로 갖는 클래스!!
                       또다른 변수 있으면 안됨, 해당 정보들만을 가져야, 그리고 해당 정보로 처리할 수 있는 책임들이 해당 일급 컬렉션 밑으로 이동됨
         */
        // (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade(); // 학점 계산기 --- (학점수×교과목 평점)의 합계작업 전달(작업 위임) ---> 과목(코스)일급 컬렉션
        // 수강신청 총학점 수                                                                                                                       <----- 과목(코스)
        int totalCompletedCredit = courses.calculateTotalCompletedCredit(); // 학점 계산기 --- 수강신청 총학점 수 작업 전달(작업 위임) ---> 과목(코스)일급 컬렉션
        //                                                                                                               <----- 과목(코스)
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;  // <---리턴-- 나누기만 해서 <----- 과목(코스)
    }
}
