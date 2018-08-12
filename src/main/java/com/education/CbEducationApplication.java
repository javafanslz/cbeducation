package com.education;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.education.mapper")
public class CbEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbEducationApplication.class, args);
	}
}
