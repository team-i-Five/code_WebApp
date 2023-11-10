package com.ifive.front.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Musical {
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

    @JsonProperty("describe")
    private String describe;

    @JsonProperty("synopsis")
    private String synopsis;
}
