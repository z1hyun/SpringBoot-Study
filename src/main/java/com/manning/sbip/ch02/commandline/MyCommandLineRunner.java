package com.manning.sbip.ch02.commandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class MyCommandLineRunner implements CommandLineRunner  {

    /* 3. 스프링의 컴포넌트의 별도의 클래스에서도 작성가능
     * 장점 : 스프링 부트 메인클래스가 CommandLineRunner 관련 코드로 인해 복잡해지는 부작용을 막음
     *
     * @Order 어노테이션을 사용해서 컴포넌트의 순서를 정의할 수 있음
     * @CommandLineRunner 구현체가 여러개일때 @Order 을 사용하여 실행순서를 정함.
     *
     */

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLineRunner excuted as a Spring Component");
    }
}
