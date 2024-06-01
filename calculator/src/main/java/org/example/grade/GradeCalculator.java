package org.example.grade;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        double multipliedCreditAndCourseGrade =0;

        for(Course course:courses){
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        //수강신청 총학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade /totalCompletedCredit;
    }
}
