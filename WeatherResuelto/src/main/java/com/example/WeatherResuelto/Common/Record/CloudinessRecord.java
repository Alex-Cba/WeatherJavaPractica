package com.example.WeatherResuelto.Common.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record CloudinessRecord(

        @JsonProperty("id") int id,
        @JsonProperty("location_id") int location_id,
        @JsonProperty("cloudiness") int cloudiness,
        @JsonProperty("created_at") Date created_at

) {
}
