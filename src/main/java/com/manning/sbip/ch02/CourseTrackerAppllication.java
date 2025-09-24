package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.model.User;
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
public class CourseTrackerAppllication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CourseTrackerAppllication.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerAppllication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //user2만 비밀번호 ㄱ제약에 부합하고 나머지는 부합하지않음.

        User user1 = new User("sbip01", "sbip");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user1);
        logger.error("Password for user1 do not adhere to the passsword policy");
        violations.forEach(constraintViolation -> logger.error("Violation detailse: [{}]",constraintViolation.getMessage()));

        User user2 = new User("sbip02", "Sbip01$4UDfg");
        violations = validator.validate(user2);
        if (violations.isEmpty()) {
            logger.info("Password for user2 adheres to the password policy");
        }

        User user3 = new User("sbip03", "Sbip01$4UDfgggg");
        violations = validator.validate(user3);
        logger.error("Password for user3 vioates maximum repetitve rule");
        violations.forEach(constraintViolation -> logger.error("Violation detailse: [{}]",constraintViolation.getMessage()));

        User user4 = new User("sbip04", "Sbip014UDfgggg");
        violations = validator.validate(user3);
        logger.error("Password for user4 vioates maximum repetitve rule");
        violations.forEach(constraintViolation -> logger.error("Violation detailse: [{}]",constraintViolation.getMessage()));



    }
}
