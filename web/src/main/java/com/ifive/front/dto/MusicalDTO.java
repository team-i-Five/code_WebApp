package com.ifive.front.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ifive.front.entity.Musical;

import lombok.Getter;


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
    private String synopsis;

    public Musical toEntity() {
        Musical musical = new Musical(this.musicalId, this.title, this.posterUrl, this.genre, this.date, this.location, this.actors, this.ageRating, this.runningTime, this.descrip, this.synopsis);
        return musical;
    }

    @Override
    public String toString() {
        return "MusicalDTO : [ musicalID = " + musicalId + ", title = "+ title +", poster_url = "+ posterUrl +"]";
    }
}
