package com.lti.myproj.service;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
// import static org.mockito.ArgumentMatchers.*;

import com.lti.myproj.repository.*;
import com.lti.myproj.model.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing PersonalDetails Service")
public class PersonalDetailsServiceTests {

    @Mock
    private RegistrationRepository registrationRepo;
    @Mock
    private PersonalDetailsRepository personalDetailsRepo;

    private PersonalDetailsServiceImpl personalDetailsService;
    User user;

    @BeforeEach
    void initUseCase() {
        personalDetailsService = new PersonalDetailsServiceImpl(personalDetailsRepo, registrationRepo);
        user = new User(1, "aronddsilva@gmail.com", "arondsilva", "arondsilva", "user");
    }

    @Test
    @DisplayName("Get Personal Details is userId is passed")
    void getPersonalDetails() {
        PersonalDetails personalDetails = new PersonalDetails(
                "Aron",
                21,
                "male",
                "arondsilva@gmail.com",
                "123457689",
                "Vasai",
                "Maharashtra");

        personalDetails.setUser(user);
        when(personalDetailsRepo.findByCustomerId(1)).thenReturn(personalDetails);

        assertEquals(personalDetails, personalDetailsService.getPersonalDetailsById(1));
    }
}