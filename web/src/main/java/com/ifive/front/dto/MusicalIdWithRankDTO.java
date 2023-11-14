package com.ifive.front.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicalIdWithRankDTO {
    private int rank;
    private String musicalID;

    @Override
    public String toString() {
        return "MusicalWithRank{" +
                    "rank=" + rank +
                    ", musicalID=" + musicalID +
                    '}';
    }
}
