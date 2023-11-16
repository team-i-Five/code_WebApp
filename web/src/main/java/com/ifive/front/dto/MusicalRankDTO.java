package com.ifive.front.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusicalRankDTO {
    private Integer id;
    private String siteName;
    private Integer ranking;
    private String title;
    private String date;
    private String location;
    private String posterUrl;
    private String goodsUrl;
    private String updateDate;
}
