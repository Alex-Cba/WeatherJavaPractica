package com.example.WeatherResuelto.Common.DTO;

import com.example.WeatherResuelto.Common.Record.AirQualityRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirQuality {
    private int index;
    private String description;

    public AirQuality(AirQualityRecord airQuality) {
        if(airQuality.quality() > 0 && airQuality.quality() <= 50){
            description = "Good";
        } else if (airQuality.quality() > 50 && airQuality.quality() <= 100) {
            description = "Moderate";
        } else if (airQuality.quality() > 100 && airQuality.quality() <= 150) {
            description = "Unhealthy for Sensitive Groups";
        } else if (airQuality.quality() > 150 && airQuality.quality() <= 200) {
            description = "Unhealthy";
        } else if (airQuality.quality() > 200 && airQuality.quality() <= 300) {
            description = "Very Unhealthy";
        } else if (airQuality.quality() > 300 && airQuality.quality() <= 500) {
            description = "Hazardous";
        }

        this.index = airQuality.quality();
    }
}
