package com.nhnacademy.springbootmvc;

import com.nhnacademy.springbootmvc.controller.UserController;
import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.exception.UserNotFoundException;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserRepository.class})
public class UserControllerTest {

    private MockMvc mockMvc;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userRepository))
                .build();
    }

    @Test
    void testUserExists() throws Exception {
        User user = User.create("admin", "12345");
        when(userRepository.getUser(anyString())).thenReturn(user);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}", "admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("user"))
                .andReturn();

        Optional<User> viewUser = Optional.ofNullable(mvcResult.getModelAndView())
                .map(ModelAndView::getModel)
                .map(m -> m.get("user"))
                .map(User.class::cast);

        assertThat(viewUser).isPresent();
        assertThat(viewUser.get().getId()).isEqualTo(user.getId());
    }

    @Test
    void testUserNotExists() throws Exception {
        when(userRepository.getUser(anyString())).thenReturn(null);

        Throwable th = catchThrowable(() -> mockMvc.perform(get("/users/{userId}", "admin")));

        assertThat(th).isInstanceOf(ServletException.class)
                .hasCauseInstanceOf(UserNotFoundException.class);
    }

}
