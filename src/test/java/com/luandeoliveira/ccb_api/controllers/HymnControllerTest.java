package com.luandeoliveira.ccb_api.controllers;

import com.luandeoliveira.ccb_api.services.HymnService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(HymnController.class)
class HymnControllerTest {
    private Integer existingId;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HymnService hymnService;

    @BeforeEach
    public void setUp(){
        existingId = 1;
        when(hymnService.findByNumber(existingId)).thenReturn(HymnFactory.createHymn());
    }

    @Test
    void findByNumberShouldReturnHymnWhenHymnNumberExists() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hymns/1", existingId).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.number").exists());
        resultActions.andExpect(jsonPath("$.title").exists());
        resultActions.andExpect(jsonPath("$.lyrics").exists());
        resultActions.andExpect(jsonPath("$.songwriter").exists());
    }


}
