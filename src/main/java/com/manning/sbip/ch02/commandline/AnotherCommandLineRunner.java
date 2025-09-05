package com.manning.sbip.ch02.commandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class AnotherCommandLineRunner implements CommandLineRunner {

    //2번째로 실행되는 CommandLineRunner 구현체 생성
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("AnotherCommandLineRunner excuted as a Spring Component");
    }
}
