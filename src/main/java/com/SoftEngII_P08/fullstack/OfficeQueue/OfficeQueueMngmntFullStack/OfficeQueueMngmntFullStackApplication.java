package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

//Exclude use of db for sprint
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class OfficeQueueMngmntFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeQueueMngmntFullStackApplication.class, args);
	}

}
