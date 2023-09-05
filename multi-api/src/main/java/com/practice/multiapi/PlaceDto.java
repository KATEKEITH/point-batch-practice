package com.practice.multiapi;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {

    // private String orderNo;
    // private Long amount;
    // private LocalDateTime orderDateTime; // 문제 요소

    private String galContentId;

    private String galContentTypeId;

    private String galTitle;

    private String galWebImageUrl;

    private String galPhotographyMonth;

    private String galPhotographyLocation;

    private String galPhotographer;

    private String galSearchKeyword;

    private String galCreatedtime;

    private String galModifiedtime;

    @Builder
    public PlaceDto(String galContentId, String galContentTypeId, String galTitle, String galWebImageUrl,
            String galPhotographyMonth, String galPhotographyLocation, String galPhotographer,
            String galSearchKeyword, String galCreatedtime, String galModifiedtime) {

        this.galContentId = galContentId;
        this.galContentTypeId = galContentTypeId;
        this.galTitle = galTitle;
        this.galWebImageUrl = galWebImageUrl;
        this.galPhotographyMonth = galPhotographyMonth;
        this.galPhotographyLocation = galPhotographyLocation;

        this.galPhotographer = galPhotographer;
        this.galSearchKeyword = galSearchKeyword;

        this.galCreatedtime = galCreatedtime;
        this.galModifiedtime = galModifiedtime;

    }

}
