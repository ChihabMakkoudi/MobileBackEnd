package com.authedency.backendserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.authedency.backendserver.services.TeacherService;
import com.authedency.backendserver.services.TestAllService;

@SpringBootApplication
public class BackendserverApplication implements CommandLineRunner {

	@Autowired
	TeacherService teacherService;
	
	@Autowired
	TestAllService testAllService;

	public static void main(String[] args) {
		SpringApplication.run(BackendserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		testAllService.test3();

	}

}
