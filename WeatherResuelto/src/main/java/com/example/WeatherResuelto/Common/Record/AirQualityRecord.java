package com.example.WeatherResuelto.Common.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record AirQualityRecord(

        @JsonProperty("id") int id,
        @JsonProperty("location_id") int location_id,
        @JsonProperty("quality") int quality,
        @JsonProperty("created_at") Date created_at

) {
}
