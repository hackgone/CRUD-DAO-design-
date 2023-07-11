package com.piyush.cruddemo;

import com.piyush.cruddemo.dao.StudentDAO;
import com.piyush.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        //create studnet object
        System.out.println("create new student");
        Student tempStudent = new Student("paul","bist","paul@gmail.com");
        //save student
        System.out.println("saving the object");
        studentDAO.save(tempStudent);
        //display id of it
        System.out.println("id"+tempStudent.getId());
    }
}
