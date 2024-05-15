package com.nhnacademy.springbootmvc;

import com.nhnacademy.springbootmvc.controller.PostRegisterController;
import com.nhnacademy.springbootmvc.exception.ValidationFailedException;
import com.nhnacademy.springbootmvc.repository.PostRepository;
import com.nhnacademy.springbootmvc.validator.PostRegisterRequestValidator;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(PostRegisterController.class)
@ContextConfiguration(classes = {PostRegisterRequestValidator.class})
public class PostRegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        PostRepository postRepository = mock(PostRepository.class);
        PostRegisterRequestValidator validator = new PostRegisterRequestValidator();

        PostRegisterController controller = new PostRegisterController(postRepository, validator);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setValidator(validator)
                .build();
    }
    @Test
    void testValidation() {
        Throwable th = catchThrowable(() ->
                        mockMvc.perform(post("/posts/register")
                              .param("title", "")
                              .param("content", ""))
                      .andDo(print()));

        assertThat(th).isInstanceOf(ServletException.class)
                .hasCauseInstanceOf(ValidationFailedException.class);
    }
}
