package com.bwl.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BW Li
 * @date 2020-06-02 17:41
 * @description
 */
@MapperScan("com.bwl.study.dao.mapper")
@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
