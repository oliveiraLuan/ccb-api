package com.luandeoliveira.ccb_api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.services.exceptions.HymnException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.StringTemplate.STR;

@Service
public class HymnService {
    private static final String path = "src/main/resources/static/lyrics/";

    public Hymn findByNumber(Integer hymnNumber) {
        Hymn hymn = null;
        if(!isExistingHymn(hymnNumber))
            throw new HymnException(STR."O hino com o número \{hymnNumber} não existe.");
        try{
            ObjectMapper mapper = new ObjectMapper();
            hymn  = mapper.readValue(new File(path + STR."\{hymnNumber}.json"), Hymn.class);
        } catch (IOException e){
            throw new HymnException(STR."Hino \{hymnNumber} não encontrado.");
        }
        return hymn;
    }

    private boolean isExistingHymn(Integer hymnNumber){
        return hymnNumber != null && (hymnNumber > 0 && hymnNumber <= 480);
    }
}
