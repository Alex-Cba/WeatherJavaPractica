package com.example.WeatherResuelto.Common.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record LocationRecord(

        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("longitude") Double longitude,
        @JsonProperty("latitude") Double latitude

) {
}


