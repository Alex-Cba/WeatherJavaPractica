package com.example.WeatherResuelto.RestClient;

import com.example.WeatherResuelto.Common.Record.LocationRecord;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class WeatherRestClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${URL_REST_TEMPLATE}")
    private String url;

    public ResponseEntity<LocationRecord> getLocation() {
        try {
            var response = restTemplate.getForEntity(url + "/location", LocationRecord.class);
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<LocationRecord> getTemperature() {
        try {
            var response = restTemplate.getForEntity(url + "/temperature", LocationRecord.class);
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<LocationRecord> getWind() {
        try {
            var response = restTemplate.getForEntity(url + "/wind", LocationRecord.class);
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<LocationRecord> getCloudiness() {
        try {
            var response = restTemplate.getForEntity(url + "/cloudiness", LocationRecord.class);
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<LocationRecord> getAirQuality() {
        try {
            var response = restTemplate.getForEntity(url + "/air_quality", LocationRecord.class);
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
