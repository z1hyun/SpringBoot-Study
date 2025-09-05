package com.manning.sbip.ch02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class CourseTrackerAppllication_bak1 implements CommandLineRunner {

    //요구사항 : 스프링 부트 애플리케이션 시작시 CommandLineRunner를 사용해 애플리케이션 초기화 코드를 실행
    
    /* 방법 
        1.스프링 부트 메인 클래스가 CommandLineRunner 인터페이스를 구현하도록 함
        2.CommandLineRunner 구현체에 @Bean을 붙여서 빈으로 정의
        3.CommandLineRunner 구현체에 @Compenert를 붙여서 스프링 컴포넌트로 정의
     */

    protected final Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerAppllication_bak1.class, args);
    }

    /* 1.스프링 부트 메인 클래스가 CommandLineRunner 인터페이스를 구현하도록 함
       run메소드 구현을 통하여 콘솔에 아래 로그가 찍힘.

       CommandLineRunner 인터페이스는 run(...)메소드 하나만 가지고 있는 함수형 인터페이스라서
       람다식으로 구현체를 작성할 수 있음.

     */
    @Override
    public void run(String... args) throws Exception {
      logger.info("CourseTrackerAppllication_bak1  CommandLineRunner has executed");
    }

    /* 2.@Bean을 사용해서 CommandLineRunner를 정의
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            logger.info("CommandLineRunner executed as a bean definition with "+args.length+" arguments");
            for (int i = 0; i < args.length; i++) {
                logger.info("args["+i+"] = "+args[i]);
            }
        };
    }




}
