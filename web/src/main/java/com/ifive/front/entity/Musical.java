package com.ifive.front.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifive.front.dto.MusicalDTO;

<<<<<<< HEAD
import jakarta.persistence.Column;
=======
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
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
<<<<<<< HEAD
    private int numb;

    @Column(name = "musical_id")
    private int musicalId;
    
    private String title;
    
    @Column(name = "poster_url")
    private String posterUrl;

    private String genre;

    private String date;

    private String location;

    private String actors;
    
    @Column(name = "age_rating")
    private String ageRating;

    @Column(name = "running_time")
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

=======
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

>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
    public MusicalDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(this, MusicalDTO.class);
    }
}