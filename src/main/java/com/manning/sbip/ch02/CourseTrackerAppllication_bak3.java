package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class CourseTrackerAppllication_bak3 implements CommandLineRunner {

    //빈 벨리데이션을 사용하는 스프링 부트 메인 클래스 생성

    private static Logger logger = LoggerFactory.getLogger(CourseTrackerAppllication_bak3.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerAppllication_bak3.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setRating(0);  //rating이 0인 course 객체 생성 제약조건에 해당하지 않는값임.

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); //course 빈 객체의 유효성 검증하는 validator 인스턴스

        Set<ConstraintViolation<Course>> violations = validator.validate(course);   //course 객체에 정의된 모든 제약사항 준수여부 검증 ,위반사항을 모아 반환.

        violations.forEach(courseViolation -> //수집된 모든 제약 사항 위반 내용을 콘솔로그로 출력
                logger.error("A constraint violation has occurred. Violation detailse: [{}]",courseViolation));


    }
}
