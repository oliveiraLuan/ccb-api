package com.luandeoliveira.ccb_api.controllers;

import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.services.HymnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/hymns")
public class HymnController {
    @Autowired
    private HymnService hymnService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(value = "/{number}")
    public Hymn findByNumber(@PathVariable Integer number) throws IOException {
        return hymnService.findByNumber(number);
    }
}
