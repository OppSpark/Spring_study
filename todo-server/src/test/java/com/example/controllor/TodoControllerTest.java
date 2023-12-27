package com.example.controllor;

import com.example.model.TodoEntity;
import com.example.model.TodoRequest;
import com.example.serivce.TodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ObjectUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TodoControllerTest {

    @Autowired
    MockMvc mvc;


    @MockBean
    TodoService todoService;
    private TodoEntity expected;

    TodoControllerTest() throws JsonProcessingException {
    }

    @BeforeEach
    void setup(){
        this.expected = new TodoEntity();
        this.expected.setId(123L);
        this.expected.setTitle("Test Title");
        this.expected.setOrder(0L);
        this.expected.setCompleted(false);
    }

    @Test
    void create() throws Exception {
        when(this.todoService.add(any(TodoRequest.class)))
                .then((i) -> {
                    TodoRequest request = i.getArgument(0, TodoRequest.class);
                    return new TodoEntity(this.expected.getId(),
                            request.getTitle(),
                            this.expected.getOrder(),
                            this.expected.getCompleted());

                });


        TodoRequest request = new TodoRequest();
        request.setTitle("any Title");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);

        mvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expected.getId()));
    }
    @Test
    void readOne() {
    }
}