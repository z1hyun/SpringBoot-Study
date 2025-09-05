package com.manning.sbip.ch02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseTrackerAppllication_bak2 {

    //log4설정 확인을 위해서 기존 CourseTrackerAppllication를 백업시키고 새로 생성

    private static final Log logger = LogFactory.getLog(CourseTrackerAppllication_bak2.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerAppllication_bak2.class, args);
        logger.info("CourseTrackerAppllication_bak2 started successfully with Log4j2 configuration");
    }

}
