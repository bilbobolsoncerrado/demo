package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.model")
//@ComponentScan("com.example.controller")
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


	var repo = context.getBean(ManufacturerRepository.class);
        repo.save(new

	Manufacturer(null,"manufacturer1",1000,1990));

}}