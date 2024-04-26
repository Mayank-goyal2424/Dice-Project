package com.dice.weather.service;

import com.dice.weather.controller.base.GlobalApiResponse;
import com.dice.weather.exception.WeatherServiceException;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherInterface {
    public GlobalApiResponse getForecastSummaryReport(String city, String basicAuth);
    public GlobalApiResponse getHourlyForecastReport(String city, String basicAuth);
}
