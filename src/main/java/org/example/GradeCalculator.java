package org.example;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {

        /*
        이런식으로 사용하면 (학점수 * 교과목 평점)의 합계가 여러군데에서 사용된다면 수정시 이것을 사용한 곳을 다 수정해줘야함 -> 응집도가 약함
        But 이것을 Course에서 수행한다면?
         */
        // (학점수 * 교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        for(Course course: courses){
            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
