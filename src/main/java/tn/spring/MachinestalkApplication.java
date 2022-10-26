package tn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class MachinestalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachinestalkApplication.class, args);
	}


}
