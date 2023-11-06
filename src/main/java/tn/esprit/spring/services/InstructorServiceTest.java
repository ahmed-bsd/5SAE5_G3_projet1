package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Instructor;


import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class InstructorServiceTest {
    @Autowired
    IInstructorServices instructorServices;

    @Test
    @Order(1)
    public void testerRetriveAllInstructor(){
        List<Instructor> instructorList = instructorServices.retrieveAllInstructors();
        Assertions.assertEquals(1l,instructorList.size());
    }
    /*
    @Test
    @Order(2)
    public void testerSaveInstructor(){
        Instructor addedInstructorTest = new Instructor(1L, "John", "Doe", LocalDate.now());
        Instructor courseAdded = instructorServices.addInstructor(addedInstructorTest);
        Assertions.assertEquals(courseAdded.getNumInstructor(),addedInstructorTest.getNumInstructor());
    }*/

}