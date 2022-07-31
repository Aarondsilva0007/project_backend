package com.lti.myproj.service;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.*;

import com.lti.myproj.repository.*;
import com.lti.myproj.model.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing FileHandler Service")
public class FileHandlerServiceTests {

    private MultipartFile file = new MockMultipartFile("file", "orig.pdf", null, "bar".getBytes());
    private FileHandlerService fileHandlerService;
    User user;

    @BeforeEach
    void initUseCase() {
        fileHandlerService = new FileHandlerService();
        user = new User(1, "aronddsilva@gmail.com", "arondsilva", "arondsilva", "user");
    }

    @Test
    @DisplayName("File name with custom string passed")
    void test_fileNamer() {
        String fileName = fileHandlerService.fileNamer(this.file, this.user, "lemon");
        assertThat(fileName).isEqualTo(user.getId() + user.getEmailId() + "_" + "lemon.pdf");
    }

    @Test
    @DisplayName("File name without filename passed ")
    void test_fileNamer_without_fileName() {
        String fileName = fileHandlerService.fileNamer(this.file, this.user);
        assertThat(fileName).isEqualTo(user.getId() + user.getEmailId() + ".pdf");
    }
}