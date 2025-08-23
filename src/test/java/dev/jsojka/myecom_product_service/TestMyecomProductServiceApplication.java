package dev.jsojka.myecom_product_service;

import org.springframework.boot.SpringApplication;

public class TestMyecomProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(MyecomProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
