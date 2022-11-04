package com.jpaBack.MuBind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MuBindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuBindApplication.class, args);
	}

}
