package tn.esprit.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import tn.esprit.spring.services.IPisteServices;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PisteServiceTestMockito {

    @Mock //la classe Mocké
    IPisteRepository pisteRepository;

    @InjectMocks //cest la classe qu'on va la tester
    PisteServicesImpl pisteService;

    Piste piste = new Piste(1L, "test" ,Color.BLACK, 1,2);


    List<Piste> listPiste = new ArrayList<Piste>() {
        {
            add(new Piste(2L,"testtest", Color.BLACK, 2,3));
            add(new Piste(3L,"testtest2", Color.BLUE, 3,4));

        }
    };
    @Test
    public void testerRetriveAllPiste(){
        Mockito.when(pisteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(piste));
        Piste piste1 =pisteService.retrievePiste(2L);
        Assertions.assertNotNull(piste1);
    }

}
