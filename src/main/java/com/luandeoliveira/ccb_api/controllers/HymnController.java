package com.luandeoliveira.ccb_api.controllers;

import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.services.HymnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hymns")
public class HymnController {
    @Autowired
    private HymnService hymnService;

    @GetMapping(value = "/{number}")
    public Hymn findByNumber(@PathVariable Integer number) {
        return hymnService.findByNumber(number);
    }
}
