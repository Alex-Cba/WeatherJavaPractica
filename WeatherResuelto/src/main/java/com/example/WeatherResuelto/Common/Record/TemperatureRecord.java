package com.example.WeatherResuelto.Common.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record TemperatureRecord(

        @JsonProperty("id") int id,
        @JsonProperty("location_id") int location_id,
        @JsonProperty("temperature") int temperature,
        @JsonProperty("unit") char unit,
        @JsonProperty("created_at") Date created_at

) {
}
