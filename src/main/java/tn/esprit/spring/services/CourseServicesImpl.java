package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CourseServicesImpl implements  ICourseServices{

//serv
    private ICourseRepository courseRepository;

	//comment 
    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }


}
