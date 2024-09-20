package com.luandeoliveira.ccb_api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.services.exceptions.HymnNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class HymnServiceTest {
    private Integer hymnNumber;

    @InjectMocks
    private HymnService hymnService;

    @Mock
    private ObjectMapper mapper;

    private static final String path = "src/main/resources/static/lyrics/";

    @BeforeEach
    void setUp() {
        hymnNumber = 100;
    }

    @Test
    void findByNumberShouldThrowHymnNotFoundExceptionWhenIOExceptionOccurs() throws IOException {
        when(mapper.readValue(new File(STR."\{path}\{hymnNumber}.json"), Hymn.class)).thenThrow(new IOException());
        assertThrows(HymnNotFoundException.class, () -> hymnService.findByNumber(hymnNumber) );
    }
}