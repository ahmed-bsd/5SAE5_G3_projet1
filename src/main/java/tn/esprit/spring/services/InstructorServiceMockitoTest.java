package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class InstructorServiceMockitoTest {
    @Mock
    IInstructorRepository instructorRepository;

    @InjectMocks
    InstructorServicesImpl instructorServices;
    Instructor instructor = new Instructor( "John", "Doe", LocalDate.now());
    List<Instructor> listInstructor = new ArrayList<Instructor>() {
        {
            add(new Instructor  ( "John", "Doe", LocalDate.now()));
            add(new Instructor ( "John", "Doe", LocalDate.now()));
        }
    };

    @Test
    public void testerRetriveInstructor(){
        Mockito.when(instructorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(instructor));
        Instructor instructor1 =instructorServices.retrieveInstructor( 1l);
        Assertions.assertNotNull(instructor1);
    }
}