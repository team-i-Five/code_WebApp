package com.ifive.front.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Musical {
    @JsonProperty("goodsCode")
    private String goodsCode;
    @JsonProperty("goodsName")
    private String goodsName;
    @JsonProperty("placeCode")
    private String placeCode;
    @JsonProperty("placeName")
    private String placeName;
    @JsonProperty("genreCode")
    private String genreCode;
    @JsonProperty("genreName")
    private String genreName;
    @JsonProperty("genreSubCode")
    private String genreSubCode;
    @JsonProperty("genreSubName")
    private String genreSubName;
    @JsonProperty("viewRateCode")
    private String viewRateCode;
    @JsonProperty("viewRateName")
    private String viewRateName;
    @JsonProperty("runningTime")
    private String runningTime;
}
