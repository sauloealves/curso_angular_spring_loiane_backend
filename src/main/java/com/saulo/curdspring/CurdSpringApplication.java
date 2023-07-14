package com.saulo.curdspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saulo.curdspring.model.Course;
import com.saulo.curdspring.repository.CourseRepository;

@SpringBootApplication
public class CurdSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdSpringApplication.class, args);
	}

	@Bean	
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

			courseRepository.save(c);
		};
	}
}
