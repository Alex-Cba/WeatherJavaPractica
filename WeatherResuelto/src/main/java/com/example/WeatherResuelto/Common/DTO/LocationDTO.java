package com.example.WeatherResuelto.Common.DTO;

import com.example.WeatherResuelto.Common.Record.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    @JsonProperty("location")
    private Location Location;
    @JsonProperty("temperature")
    private Temperature Temperature;
    @JsonProperty("Wind")
    private String Wind;
    @JsonProperty("air_quality")
    private AirQuality AirQuality;
    @JsonProperty("Cloudiness")
    private Cloudiness Cloudiness;

    public LocationDTO(LocationRecord location, TemperatureRecord temperature, WindRecord wind, AirQualityRecord airQuality, CloudinessRecord cloudiness, char fav_unit) {
        this.Location = new Location(location);
        this.Temperature = new Temperature(temperature, fav_unit);
        this.AirQuality = new AirQuality(airQuality);
        this.Cloudiness = new Cloudiness(cloudiness);

        switch (wind.direction()){
            case 0 -> {
                this.Wind = wind.speed() + " Km/h from North";
            }
            case 360 -> {
                this.Wind = wind.speed() + " Km/h from North";
            }
            case 90 -> {
                this.Wind = wind.speed() + " Km/h from East";
            }
            case 180 -> {
                this.Wind = wind.speed() + " Km/h from South";
            }
            case 270 -> {
                this.Wind = wind.speed() + " Km/h from West";
            }

        }
    }
}
