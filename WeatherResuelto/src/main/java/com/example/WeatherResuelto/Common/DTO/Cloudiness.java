package com.example.WeatherResuelto.Common.DTO;

import com.example.WeatherResuelto.Common.Record.CloudinessRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cloudiness {
    private int index;
    private String description;

    public Cloudiness(CloudinessRecord cloudiness) {
        if(cloudiness.cloudiness() == 0){
            this.description = "Clear sky";
        } else if (cloudiness.cloudiness() > 0 && cloudiness.cloudiness() <= 3) {
            this.description = "Few clouds";
        } else if (cloudiness.cloudiness() > 3 && cloudiness.cloudiness() <= 6) {
            this.description = "Sky half cludy";
        } else if (cloudiness.cloudiness() > 6 && cloudiness.cloudiness() <= 8) {
            this.description = "Sky completely cludy";
        }

        this.index = cloudiness.cloudiness();
    }
}
