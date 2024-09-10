package com.luandeoliveira.ccb_api.model;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class Hymn {
    @NotBlank
    private Integer number;
    @NotBlank
    private String title;
    @NotBlank
    private String lyrics;
    private Songwriter songwriter;

    public Hymn(){}

    public Hymn(Integer number, String title, String lyrics, Songwriter songwriter) {
        this.number = number;
        this.title = title;
        this.lyrics = lyrics;
        this.songwriter = songwriter;
    }

    public Integer getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Songwriter getSongwriter() {
        return songwriter;
    }

    public void setSongwriter(Songwriter songwriter) {
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Hymn hymn = (Hymn) object;
        return Objects.equals(number, hymn.number) && Objects.equals(title, hymn.title) && Objects.equals(lyrics, hymn.lyrics) && Objects.equals(songwriter, hymn.songwriter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title, lyrics, songwriter);
    }

    @Override
    public String toString() {
        return STR."Hymn{number=\{number}, title='\{title}\{'\''}, lyrics='\{lyrics}\{'\''}, songwriter=\{songwriter}\{'}'}";
    }
}