package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.Optional;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTestMockito {

    @InjectMocks
    private SubscriptionServicesImpl subscriptionService;

    @Mock
    private ISubscriptionRepository subscriptionRepository;




    @Test
    public void testAddSubscription() {
        // Create a sample subscription
        Subscription subscription1 = new Subscription();
        subscription1.setNumSub(1L);
        subscription1.setPrice(12.00F);
        subscription1.setTypeSub(TypeSubscription.ANNUAL);
        subscription1.setStartDate(LocalDate.now());

        // Mock the behavior of the repository's save method
        Mockito.when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription1);

        // Call the service method
        Subscription savedSubscription = subscriptionService.addSubscription(subscription1);

        // Use assertions to verify the behavior
        assertNotNull(savedSubscription);
        // Add more assertions as needed
    }



    @Test
    public void testUpdateSubscription() {
        // Create a sample Subscription object
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.SEMESTRIEL);
        subscription.setStartDate(LocalDate.now());

        // Mock the behavior of the repository
        Mockito.when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription);

        // Call the service method
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
        Assertions.assertNotNull(updatedSubscription);

    }




}

