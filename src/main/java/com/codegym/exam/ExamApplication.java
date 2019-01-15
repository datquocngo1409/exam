package com.codegym.exam;

import com.codegym.exam.service.GroupService;
import com.codegym.exam.service.StaffService;
import com.codegym.exam.service.impl.GroupServiceImpl;
import com.codegym.exam.service.impl.StaffServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Bean
	public StaffService staffService(){
		return new StaffServiceImpl();
	}

	@Bean
	public GroupService groupService(){
		return new GroupServiceImpl();
	}
}

