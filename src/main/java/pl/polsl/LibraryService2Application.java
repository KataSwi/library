package pl.polsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class LibraryService2Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryService2Application.class, args);
	}
}