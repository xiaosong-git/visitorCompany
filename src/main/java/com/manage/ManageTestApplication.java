package com.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@SpringBootApplication
//启注解事务管理
@EnableTransactionManagement
@MapperScan(basePackages={"com.manage.mapping"})
public class ManageTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageTestApplication.class, args);
	}
}
