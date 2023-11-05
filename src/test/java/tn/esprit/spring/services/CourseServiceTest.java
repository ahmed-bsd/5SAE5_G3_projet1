package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceTest {
    @Autowired
    ICourseServices courseServices;

    @Test
    @Order(1)
    public void testerRetriveAllCourses(){
        List<Course> courseList = courseServices.retrieveAllCourses();
        Assertions.assertEquals(1,courseList.size());
    }

   /* @Test
    @Order(2)
    public void testerSaveCourse(){
        Course addedCourseTest = new Course(1L,2, TypeCourse.INDIVIDUAL, Support.SNOWBOARD,15.2f,2);
        Course courseAdded = courseServices.addCourse(addedCourseTest);
        Assertions.assertEquals(courseAdded.getNumCourse(),addedCourseTest.getNumCourse());
    }*/
}
