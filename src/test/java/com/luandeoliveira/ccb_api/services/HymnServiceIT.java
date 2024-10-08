package com.luandeoliveira.ccb_api.services;

import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.model.Songwriter;
import com.luandeoliveira.ccb_api.services.exceptions.HymnException;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HymnServiceIT {
    @InjectMocks
    private HymnService service;

    @Test
    void findByNumberShouldReturnHymnWhenHymnExists() throws IOException {
        Hymn hymn = new Hymn(1, "Cristo, meu Mestre...", "", new Songwriter("Leila Taylor Morris"));
        Hymn expectedHymn = service.findByNumber(2);

        assertNotNull(expectedHymn);
        assertEquals(2, expectedHymn.getNumber());
        assertEquals("De Deus tu és eleita", expectedHymn.getTitle());
        assertNotEquals(hymn, expectedHymn);
    }

    @Test
    void findByNumberShouldThrowHymnExceptionWhenHymnIsNull(){
        assertThrows(HymnException.class, () -> service.findByNumber(null));
    }

    @Test
    void findByNumberShouldThrowHymnExceptionWhenHymnDoesNotExists(){
        Integer nonExistentHymn = 500;
        assertThrows(HymnException.class, () -> service.findByNumber(nonExistentHymn));
    }
}
