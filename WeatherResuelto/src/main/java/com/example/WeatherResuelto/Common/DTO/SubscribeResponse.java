package com.example.WeatherResuelto.Common.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeResponse {

    @JsonProperty("client_id")
    private Long user_id;

    @JsonProperty("secret")
    private String Secret;

    @JsonProperty("favorite_temperature")
    private char fav_temperature;
}
