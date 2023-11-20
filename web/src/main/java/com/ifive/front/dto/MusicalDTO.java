package com.ifive.front.dto;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
import com.ifive.front.entity.Musical;

import lombok.Getter;

<<<<<<< HEAD

// 일반적으로 DB에서 엔티티를 받아오기위한 DTO
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) // DTO에는 numb가없어서 무시하게함
public class MusicalDTO {
    
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
=======
@Getter
public class MusicalDTO {

    @JsonProperty("musical_id")
    private int musicalId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("poster_url")
    private String posterUrl;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("date")
    private String date;

    @JsonProperty("location")
    private String location;

    @JsonProperty("actors")
    private String actors;

    @JsonProperty("age_rating")
    private String ageRating;

    @JsonProperty("running_time")
    private String runningTime;

    @JsonProperty("description")
    private String descrip;

    @JsonProperty("synopsis")
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
    private String synopsis;

    public Musical toEntity() {
        Musical musical = new Musical(this.musicalId, this.title, this.posterUrl, this.genre, this.date, this.location, this.actors, this.ageRating, this.runningTime, this.descrip, this.synopsis);
        return musical;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return "MusicalDTO : [ musicalID = " + musicalId + ", title = "+ title +", poster_url = "+ posterUrl +"]";
    }
=======
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
}
