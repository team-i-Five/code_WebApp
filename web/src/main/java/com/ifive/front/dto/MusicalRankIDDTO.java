package com.ifive.front.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicalRankIDDTO {
    private int rank;
    private String musicalId;
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

    @Override
    public String toString() {
        return "MusicalRankIDDTO{" +
                    "rank=" + rank +
                    ", musicalID=" + musicalId +
                    '}';
    }

}
