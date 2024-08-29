package com.example.WeatherResuelto.Controller;

import com.example.WeatherResuelto.Common.Record.LocationRecord;
import com.example.WeatherResuelto.Common.Request.SubcribeRequest;
import com.example.WeatherResuelto.Common.DTO.LocationDTO;
import com.example.WeatherResuelto.Common.DTO.SubscribeResponse;
import com.example.WeatherResuelto.Service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Weather")
public class WeatherController {

    private final IWeatherService _weatherService;

    @Autowired
    public WeatherController(IWeatherService weatherService){
        this._weatherService = weatherService;
    }

    @PostMapping("/weather/subscribe")
    public ResponseEntity<SubscribeResponse> BasicLogin(@RequestBody SubcribeRequest login) {
        SubscribeResponse response = _weatherService.Subscribe(login);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationRecord>> GetAllLocation(){
        List<LocationRecord> response = _weatherService.GetAllLocations();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{secret}/location/{locationId}")
    public ResponseEntity<LocationDTO> GetLocationById(@PathVariable int locationId, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @PathVariable String secret ){
        LocationDTO response = _weatherService.GetLocationById(locationId, date, secret);
        return ResponseEntity.ok(response);
    }
}
