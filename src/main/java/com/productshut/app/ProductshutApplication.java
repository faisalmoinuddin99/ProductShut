package com.productshut.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductshutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductshutApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper() ;
	}
}
