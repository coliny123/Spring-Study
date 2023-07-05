package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {  // 생성자
        this.courses = courses;
    }
    /*
    아까 GradeCalculator에 있던 부분이 Courses의 multiplyCreditAndCourseGrade()로 이동됨
     */
    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
