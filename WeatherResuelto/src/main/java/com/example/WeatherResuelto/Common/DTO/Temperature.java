package com.example.WeatherResuelto.Common.DTO;

import com.example.WeatherResuelto.Common.Record.TemperatureRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {
    private int value;
    private char unit;

    public Temperature(TemperatureRecord temperature, char fav_unit) {
        this.unit = temperature.unit();
        this.value = fav_unit == temperature.unit() ?
                temperature.temperature()
                : "C".equals(temperature.unit()) ?
                (5/9) * (temperature.temperature() - 32)
                : (9/5 * temperature.temperature()) + 32;
    }
}
