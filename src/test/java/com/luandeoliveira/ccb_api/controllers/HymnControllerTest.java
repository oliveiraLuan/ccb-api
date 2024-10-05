package com.luandeoliveira.ccb_api.controllers;

import com.luandeoliveira.ccb_api.services.HymnService;
import com.luandeoliveira.ccb_api.services.exceptions.HymnException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(HymnController.class)
class HymnControllerTest {
    private Integer existingNumber;
    private Integer nonExistingNumber;
    private static final String path = "/hymns/{number}";
    private String invalidArgument;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HymnService hymnService;

    @BeforeEach
    public void setUp() throws IOException {
        existingNumber = 1;
        nonExistingNumber = 500;
        invalidArgument = "abc";
        when(hymnService.findByNumber(existingNumber)).thenReturn(HymnFactory.createHymn());
        when(hymnService.findByNumber(nonExistingNumber)).thenThrow(HymnException.class);
    }

    @Test
    void findByNumberShouldReturnHymnWhenHymnNumberExists() throws Exception {
        ResultActions resultActions = mockMvc.perform(get(path, existingNumber).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.number").exists());
        resultActions.andExpect(jsonPath("$.title").exists());
        resultActions.andExpect(jsonPath("$.lyrics").exists());
        resultActions.andExpect(jsonPath("$.songwriter").exists());
    }
    @Test
    void findByNumberShouldThrowHymnExceptionWhenNumberDoesNotExists() throws Exception {
        ResultActions resultActions = mockMvc.perform(get(path, nonExistingNumber).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isNotFound());
    }
    @Test
    void findByNumberShouldThrowMismatchExceptionWhenArgumentInvalid() throws Exception {
        ResultActions resultActions = mockMvc.perform(get(path, invalidArgument).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isBadRequest());
    }
}