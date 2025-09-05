package com.manning.sbip.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableConfigurationProperties(AppProperties.class)
@ConfigurationPropertiesScan
public class SpringBootAppDemoApplication {

    /* @EnableAutoConfiguration : @ConfigurationProperties가 붙어있는 클래스를 스프링 컨테이너에 등록해줌
                                 (다른 클래스에서 ConfigurationProperties 사용시 해당 @Enale.. 인자값으로 해당 클래스를 넣어주면됨)
        하지만 위에꺼 대신에 쓸 수 있는건 @ConfigurationPropertiesScan 임

        @ConfigurationPropertiesScan : 1. 기준 패키지를 지정하면, 패키지 하위에 있는 @ConfigurationProperties가 붙어있는
                                       클래스를 모두 탐색해서 스프링 컨테이너에 등록해줌. @Componernt 붙은건 해당 X
                                       오로지 @ConfigurationProperties 만 스캔함
                                   ,   2. 클래스에도 붙일 수 있고, @Bean 메소드에도 붙일 수 있음
                                       프로퍼티값을 클래스에 바인딩하는건 세터 메서드나 생성자 바인딩 방식으로도 가능
                                       ex) app.sbip.ct를 @ConfigurationProperties 어노테이션 접두어로 지정하면
                                           app.sbip.ct.name 프로퍼티값이 클래스의 name 프로퍼티갑승로 저장
     */
    private static final Logger log = LoggerFactory.getLogger(SpringBootAppDemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAppDemoApplication.class, args);
        AppService appService = applicationContext.getBean(AppService.class);
        log.info("AppProperties:"+appService.getAppProperties().toString());
    }
}