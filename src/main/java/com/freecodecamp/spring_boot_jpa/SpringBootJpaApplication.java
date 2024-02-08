package com.freecodecamp.spring_boot_jpa;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringBootJpaApplication.class);

		// ! this has less priority than application.yaml! Just decomment to test it
		// app.setDefaultProperties(Collections.singletonMap("spring.profiles.active",
		// "test"));

		var ctx = app.run(args);

		// HelloWorld helloWorld = sprintBootContext.getBean(HelloWorld.class);
		// MyFirstClass myFirstClass = sprintBootContext.getBean("myFirstBean",
		// MyFirstClass.class);
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		// System.out.println(myFirstService.readProperty());
		System.out.println(myFirstService.getMyCustomPropertyFromYaml());
		System.out.println(myFirstService.getMyCustomPropertyFromYaml2());
	}

}
