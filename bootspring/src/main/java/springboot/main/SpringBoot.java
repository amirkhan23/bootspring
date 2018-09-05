package springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springboot.controllers.MainController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
@EntityScan(basePackages={"springboot.model"})
public class SpringBoot extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBoot.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringBoot.class, args);

	}

}
