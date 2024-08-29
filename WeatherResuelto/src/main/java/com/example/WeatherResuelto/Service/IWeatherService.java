package com.example.WeatherResuelto.Service;

import com.example.WeatherResuelto.Common.DTO.LocationDTO;
import com.example.WeatherResuelto.Common.Record.LocationRecord;
import com.example.WeatherResuelto.Common.Request.SubcribeRequest;
import com.example.WeatherResuelto.Common.DTO.SubscribeResponse;

import java.util.Date;
import java.util.List;

public interface IWeatherService {
    SubscribeResponse Subscribe(SubcribeRequest login);

    List<LocationRecord> GetAllLocations();

    LocationDTO GetLocationById(int locationId, Date date, String secret);
}
