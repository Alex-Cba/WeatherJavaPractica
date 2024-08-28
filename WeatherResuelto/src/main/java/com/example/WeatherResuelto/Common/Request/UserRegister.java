package com.example.WeatherResuelto.Common.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    private String Email;

    private String Password;

    private char FavTemperature;
}
