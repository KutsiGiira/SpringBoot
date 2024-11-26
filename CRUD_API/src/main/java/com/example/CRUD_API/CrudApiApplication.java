package com.example.CRUD_API;

import com.example.CRUD_API.Dao.Std;
import com.example.CRUD_API.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner cmdR(Std students){
		return runner ->{
			createS(students);
		};
	}
		private void createS(Std students){
			Student s = new Student("Black");
				students.create(s);
		}
}