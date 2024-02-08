package com.freecodecamp.spring_boot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		var sprintBootContext = SpringApplication.run(SpringBootJpaApplication.class, args);

		// HelloWorld helloWorld = sprintBootContext.getBean(HelloWorld.class);
		// MyFirstClass myFirstClass = sprintBootContext.getBean("myFirstBean",
		// MyFirstClass.class);
		MyFirstService myFirstService = sprintBootContext.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		// System.out.println(myFirstService.readProperty());
		System.out.println(myFirstService.getMyCustomPropertyFromYaml());
		System.out.println(myFirstService.getMyCustomPropertyFromYaml2());
	}

}
