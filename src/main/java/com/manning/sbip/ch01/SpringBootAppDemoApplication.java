package com.manning.sbip.ch01;

import com.manning.sbip.ch02.configurationproperties.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootAppDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootAppDemoApplication.class);
    //이 클래스는 스프링 부트의 메인 클래스이며, 편리하게 스프링 부트 애플리케이션을 기동할 수 있게함.

    /* @SpringBootAppliction은  @EnableAutoConfiguration, @ComponentScan , @SpringBootConfiguraion 3개의 어노테이션을 포함함.
       @EnableAutoConfiguration : 어플리케이션 클래스패스에 있는 JAR 파일을 바탕으로 애플리케이션을 자동으로 구성해주는 스프링 부트 자동구성 기능 활성화.
                                   (다른 클래스에서 ConfigurationProperties 사용시 해당 @Enale.. 인자값으로 해당 클래스를 넣어주면됨)
       @ComponentScan : 애플리케이션이 있는 스프링 컴포넌틀 탐색해서 찾아냄. 컴포넌트는 @Component,@Bean등이 있어 자바빈으로 스프링 관리함.
                        지정한 디렉터리와 그 하위 디렉터리를 모두 탐색하여 컴포넌트 찾기 및 라이플사이클 관리
                        루트 패키지에서 시작 -> 모든 하위 패키지 탐색 (이 안에 존재하지 않는 컴포넌트는 탐색대상 X 스프링에서 관리하지 못함)

       @SpringBootCofniguraion : 스프링 부트 애플리케이션 설정을 담당하는 클래스에 붙이는 어노테이션
     */


    public static void main(String[] args) {
        /*  run() 메소드
        1. 클래스패스에 있는 라이브러리를 기준으로 ApplicaitionContext 클래스 인스턴스 생성
        2. CommandLinePropertySource를 등로갷서 명령행 인자를 스프링 프로퍼티로 읽어 들임
        3. 앞의 1에서 생성한 ApplicationContext를 통해 모든 싱글턴 빈 로딩
        4. 애플리케이션에 설정된 AppclicaitionRunners와 CommanRunners를 실행
     */
        //SpringApplication.run(SpringBootAppDemoApplication.class, args);

//        Properties properties = new Properties();
//        properties.setProperty("spring.config.on-not-fount", "ignore");
//        SpringApplication app = new SpringApplication(SpringBootAppDemoApplication.class);
//        app.setDefaultProperties(properties);
//        app.run(args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAppDemoApplication.class, args);
//        //dbConfiguration bean생성 후 출력
//        DbConfiguration dbConfiguration = applicationContext.getBean(DbConfiguration.class);
//        log.info(dbConfiguration.toString());

        //환경변수를 스프링 부트 프로퍼티로 읽어서 사용
        Environment env = applicationContext.getBean(Environment.class);
        log.info("Configurred application timeout value:"+env.getProperty("app.timeout"));
    }
    /*
        스프링 이벤트를 구독할 수 있는 다양한 방법
        1. (가장 쉬운 방식 :  @EventListener 사용하기
        2. 커스텀 ApplicaitionListener 클래스/구현체 생성
        3. spring.factiories로 applicitionListener 등록
    */

//    @EventListener(ApplicationReadyEvent.class)
//    public  void applicationReadyEvent(ApplicationReadyEvent event) {
//        System.out.println("Application Ready Event"+new Date(event.getTimestamp());
//    }


}
