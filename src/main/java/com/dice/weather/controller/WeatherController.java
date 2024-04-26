package com.dice.weather.controller;

import com.dice.weather.controller.base.GlobalApiResponse;
import com.dice.weather.service.WeatherService;
import com.dice.weather.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController extends BaseServiceImpl {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast-summary")
    public ResponseEntity<GlobalApiResponse> getForecastSummaryReport(
            @RequestParam String city,
            @RequestHeader("Authorization") String basicAuth) {

        try {
            return new ResponseEntity<>(weatherService.getForecastSummaryReport(city, basicAuth), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(errorResponse("Internal Server Error",500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<GlobalApiResponse> getHourlyForecastReport(
            @RequestParam String city,
            @RequestHeader("Authorization") String basicAuth) {

        try {
            return new ResponseEntity<>(weatherService.getHourlyForecastReport(city,basicAuth), HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(errorResponse("Internal Server Error",500,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
