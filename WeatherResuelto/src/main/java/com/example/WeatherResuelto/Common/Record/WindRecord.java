package com.example.WeatherResuelto.Common.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record WindRecord(

        @JsonProperty("id") int id,
        @JsonProperty("location_id") int location_id,
        @JsonProperty("speed") int speed,
        @JsonProperty("direction") int direction,
        @JsonProperty("created_at") Date created_at

) {
}
