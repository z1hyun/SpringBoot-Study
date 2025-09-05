package com.manning.sbip.ch01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

public class ApplicitionStartingEventListener   {
//        implements ApplicationListener<ApplicationStartingEvent> {

//    @Override
//    public void onApplicationEvent(ApplicationStartingEvent event) {
//        System.out.println("Application Starting Event logged at : "+new Date(event.getTimestamp()));
//    }

    @Configuration
    @PropertySource("classpath:dbConfig.properties")
    public static class DbConfiguration {

        /* Configuration이 붙어있는 스프링 환경 설정 클래스 DbCOnfiguration에
           @PropertySource 어노테이션을 달면 클래스패스에 있는 dbConfig.properties 파일에 설정 정보를 읽어서 사용가능함.
           src/main/resources 디렉토리에 있는 파일은 실행 가능한 JAR로 패키징된 후 클래스패스에 위치하게 됨.
           yml,yaml파일은 지젇해서 사용 불가함.
         */
        @Autowired
        private Environment env;
        //스프링에서 제공하는 Environment 인스턴스를 주입받으면 dbConfig.properties 파일에 지정된 설정정보를 읽을 수 있음.

        @Override
        public String toString() {
            return "User: " + env.getProperty("user") + ", Password: " + env.getProperty("password") + ", Url: " + env.getProperty("url") + "";
        }
    }
}
