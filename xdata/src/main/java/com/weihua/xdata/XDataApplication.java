package com.weihua.xdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "com.weihua.xdata.mapper")
public class XDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(XDataApplication.class, args);
	}

}
