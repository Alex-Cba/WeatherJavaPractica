package com.example.WeatherResuelto.Service.Imp;

import com.example.WeatherResuelto.Common.CustomException.NotFoundException;
import com.example.WeatherResuelto.Common.DTO.LocationDTO;
import com.example.WeatherResuelto.Common.Record.LocationRecord;
import com.example.WeatherResuelto.Common.Request.SubcribeRequest;
import com.example.WeatherResuelto.Common.DTO.SubscribeResponse;
import com.example.WeatherResuelto.Repository.UserRepository;
import com.example.WeatherResuelto.RestClient.WeatherRestClient;
import com.example.WeatherResuelto.Service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeatherService implements IWeatherService {

    //TODO: Levantar API y Base por separado, cambiar base a cualquiera porque ahora esta en H2

    private final UserRepository _userRepo;

    private final WeatherRestClient _weatherRestClient;

    @Autowired
    public WeatherService(UserRepository userRepository, WeatherRestClient weatherRestClient) {
        this._userRepo = userRepository;
        this._weatherRestClient = weatherRestClient;
    }

    @Override
    public SubscribeResponse Subscribe(SubcribeRequest login) {


        var client = _userRepo.CheckSuscribe(login.getEmail(), login.getSecret())
                .stream().findFirst()
                .map(x -> {
                    SubscribeResponse response = new SubscribeResponse();
                    response.setUser_id(x.getId());
                    response.setSecret(x.getSecret().toString());
                    response.setFav_temperature(x.getFavTemperature());
                    return response;
                }).orElseThrow(() -> new NotFoundException("INVALID_LOGIN"));

        return client;
    }

    @Override
    public List<LocationRecord> GetAllLocations() {
        var locations = _weatherRestClient.getLocations().getBody();

        if(locations == null){
            throw new NotFoundException("LOCATIONS_NOT_FOUND");
        }

        return locations;
    }

    @Override
    public LocationDTO GetLocationById(int locationId, Date date, String secret) {
        var User = _userRepo.findBySecret(secret).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));

        var location = _weatherRestClient.getLocations().getBody()
                .stream().filter(x ->  x.id() == locationId )
                .findFirst()
                .orElseThrow(() -> new NotFoundException("LOCATION_NOT_FOUND"));

        var temperature = _weatherRestClient.getTemperatures().getBody()
                .stream().filter(t -> t.id() == locationId && (date == null || t.created_at().equals(date)))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("TEMPERATURE_NOT_FOUND"));

        var wind = _weatherRestClient.getWinds().getBody()
                .stream().filter(t -> t.id() == locationId && (date == null || t.created_at().equals(date)))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("WIND_NOT_FOUND"));

        var airQuality = _weatherRestClient.getAirQuality().getBody()
                .stream().filter(t -> t.id() == locationId && (date == null || t.created_at().equals(date)))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("AIR_QUALITY_NOT_FOUND"));

        var cloudiness = _weatherRestClient.getCloudinesses().getBody()
                .stream().filter(t -> t.id() == locationId && (date == null || t.created_at().equals(date)))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("CLOUDINESS_NOT_FOUND"));

        LocationDTO locationDTO = new LocationDTO(location, temperature, wind, airQuality, cloudiness, User.getFavTemperature());

        return locationDTO;
    }
}
