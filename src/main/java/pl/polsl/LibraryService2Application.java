package pl.polsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.polsl.repository")
public class LibraryService2Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryService2Application.class, args);
	}
}
