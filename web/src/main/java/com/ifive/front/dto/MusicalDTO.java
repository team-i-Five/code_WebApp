package com.ifive.front.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ifive.front.entity.Musical;

import lombok.Getter;

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
    private String synopsis;

    public Musical toEntity() {
        Musical musical = new Musical(this.musicalId, this.title, this.posterUrl, this.genre, this.date, this.location, this.actors, this.ageRating, this.runningTime, this.descrip, this.synopsis);
        return musical;
    }
}
