package com.zurita.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEmpleadosApplication.class, args);
	}

}


