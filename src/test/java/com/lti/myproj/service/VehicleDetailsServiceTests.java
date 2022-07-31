package com.lti.myproj.service;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
// import static org.mockito.ArgumentMatchers.*;

import static org.assertj.core.api.Assertions.*;

import com.lti.myproj.repository.*;
import com.lti.myproj.model.*;
import com.lti.myproj.exception.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing VehicleDetails Service")
public class VehicleDetailsServiceTests {

    @Mock
    private RegistrationRepository registrationRepo;
    @Mock
    private VehicleDetailsRepository vehicleDetailsRepo;

    private VehicleDetailsServiceImpl vehicleDetailsService;
    User user;

    @BeforeEach
    void initUseCase() {
        vehicleDetailsService = new VehicleDetailsServiceImpl(vehicleDetailsRepo, registrationRepo);
        user = new User(1, "aronddsilva@gmail.com", "arondsilva", "arondsilva", "user");
    }

    @Test
    @DisplayName("Vehicle details are added for new user")
    void add_vehicle_details() {
        VehicleDetails vehicleDetails = new VehicleDetails("make", "model", 4000);

        when(registrationRepo.findById(1)).thenReturn(user);
        when(vehicleDetailsRepo.save(any())).thenReturn(vehicleDetails);

        assertThat(vehicleDetailsService.addVehicleDetails(vehicleDetails, user.getId())).isEqualTo(vehicleDetails);
    }

    @Test
    @DisplayName("Vehicle details being added for a user that does not exist throws exception")
    void non_existing_user_throws_exception() {
        VehicleDetails vehicleDetails = new VehicleDetails("make", "model", 4000);

        when(registrationRepo.findById(1)).thenReturn(null);
        assertThatThrownBy(() -> vehicleDetailsService.addVehicleDetails(vehicleDetails, 1))
                .isInstanceOf(UserNotFoundException.class);
    }
}
