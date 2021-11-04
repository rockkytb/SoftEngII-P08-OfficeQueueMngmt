package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Exclude use of db for sprint
//This comment will trigger analysis
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class OfficeQueueMngmntFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeQueueMngmntFullStackApplication.class, args);
	}

}
