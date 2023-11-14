package com.ifive.front.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifive.front.dto.MusicalDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Musical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numb;

    private int musicalId;
    private String title;
    private String posterUrl;
    private String genre;
    private String date;
    private String location;
    private String actors;
    private String ageRating;
    private String runningTime;
    private String descrip;
    private String synopsis;

    public Musical(int musicalId, String title, String posterUrl, String genre, String date, String location,
            String actors, String ageRating, String runningTime, String descrip, String synopsis) {
        this.musicalId = musicalId;
        this.title = title;
        this.posterUrl = posterUrl;
        this.genre = genre;
        this.date = date;
        this.location = location;
        this.actors = actors;
        this.ageRating = ageRating;
        this.runningTime = runningTime;
        this.descrip = descrip;
        this.synopsis = synopsis;
    }

    public MusicalDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(this, MusicalDTO.class);
    }
}