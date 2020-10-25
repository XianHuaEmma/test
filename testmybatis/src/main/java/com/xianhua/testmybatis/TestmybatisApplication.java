package com.xianhua.testmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "com.xianhua.testmybatis.mapper")
public class TestmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestmybatisApplication.class, args);
	}

}
