package com.ifive.front.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ifive.front.entity.Musical;

import lombok.Getter;



// JSON 파일을 파싱하기위한 DTO
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) // DTO에는 numb가없어서 무시하게함
public class MusicalJsonParseDTO {

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

    @Override
    public String toString() {
        return "MusicalJsonParseDTO : [ musicalID = " + musicalId + ", title = "+ title +", poster_url = "+ posterUrl +"]";
    }
}
