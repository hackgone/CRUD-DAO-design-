package com.piyush.cruddemo;

import com.piyush.cruddemo.dao.StudentDAO;
import com.piyush.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{
            createStudent(studentDAO);
            createStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAll(studentDAO);
        };
    }
    private void deleteAll(StudentDAO studentDAO){
        int numRows = studentDAO.deleteAll();
        System.out.println(numRows);
    }

    private void deleteStudent(StudentDAO studentDAO){
        int studentID = 2;
        studentDAO.delete(studentID);
    }
    private void updateStudent(StudentDAO studentDAO){
        //get studnet we want
        int studentID = 1;
        Student myStudent = studentDAO.findByID(1);
        //update via setLastName method of Student object(setter)
        myStudent.setLastName("sharma");
        //update student via DAO .merge method
        studentDAO.update(myStudent);

        //print our new student
        System.out.println(myStudent);

    }
    private void queryForStudentsLastName(StudentDAO studentDAO){
        List<Student> theStudent = studentDAO.findByLastName("bist");
        for(Student it : theStudent){
            System.out.println(it);
        }
    }

    private void queryForStudents(StudentDAO studentDAO){
        List<Student> theStudents = studentDAO.findAll();
        //display
        for(Student it:theStudents){
            System.out.println(it);
        }

    }
    private void createStudent(StudentDAO studentDAO) {
        //create studnet object
        System.out.println("create new student");
        Student tempStudent = new Student("paul","bist","paul@gmail.com");
        //save student
        System.out.println("saving the object");
        studentDAO.save(tempStudent);
        //display id of it (PK)
        int id  = tempStudent.getId();
        System.out.println("id "+id);

        //get data
        Student myStudent = studentDAO.findByID(id);
        System.out.println("WE GET "+ myStudent);

    }
}
