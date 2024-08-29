package com.example.WeatherResuelto.Common.DTO;

import com.example.WeatherResuelto.Common.Record.LocationRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String name;

    public Location(LocationRecord location) {
        this.id = (long) location.id();
        this.name = location.name();
    }
}
