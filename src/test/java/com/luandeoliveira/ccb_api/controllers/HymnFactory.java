package com.luandeoliveira.ccb_api.controllers;

import com.luandeoliveira.ccb_api.model.Hymn;
import com.luandeoliveira.ccb_api.model.Songwriter;

public class HymnFactory {
    public static Hymn createHymn(){
        return new Hymn(1, "Cristo, meu Mestre...", "Cristo, meu mestre e meu senhor\nEu te adoro, por fé, com fervor\nRogo que guardes meu coração\nVem protegê-lo com tua unção\nE defendê-lo, ó meu guardião\nMestre divino, sempre senti\nMeu coração dependente de ti\nBom fundamento dá-lhe, senhor\nDá-lhe firmeza, virtude e valor\nE fortaleza, ó meu protetor\nVale profundo, cheio de mal\nÉ este mundo, ó rei divinal\nSó tua força pode manter\nSanto e puro, na graça, meu ser\nSempre seguro, com fé e poder\nMestre piedoso, com tua mão\nFaze perfeito o meu coração\nSanto, ardoroso em te servir\nSempre voltado aos bens do porvir\nMestre amado, desejo te ouvir", new Songwriter("Leila Naylor Morris"));
    }
}
