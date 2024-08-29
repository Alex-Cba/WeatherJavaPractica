package com.example.WeatherResuelto.RestClient;

import com.example.WeatherResuelto.Common.Record.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
@Service
public class WeatherRestClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${URL_REST_TEMPLATE}")
    private String url;

    public ResponseEntity<List<LocationRecord>> getLocations() {
        try {
            var response = restTemplate.exchange(url + "/location",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<LocationRecord>>() {
                    });
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<TemperatureRecord>> getTemperatures() {
        try {
            var response = restTemplate.exchange(url + "/temperature",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<TemperatureRecord>>() {
                    });
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<WindRecord>> getWinds() {
        try {
            var response = restTemplate.exchange(url + "/wind",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<WindRecord>>() {
                    });
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<CloudinessRecord>> getCloudinesses() {
        try {
            var response = restTemplate.exchange(url + "/cloudiness",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CloudinessRecord>>() {
                    });
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<AirQualityRecord>> getAirQuality() {
        try {
            var response = restTemplate.exchange(url + "/air_quality",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<AirQualityRecord>>() {
                    });
            return response;
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
