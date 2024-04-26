package com.dice.weather.service;

import com.dice.weather.controller.base.GlobalApiResponse;
import com.dice.weather.enums.LogLevel;
import com.dice.weather.exception.WeatherServiceException;
import com.dice.weather.interceptor.AuthInterceptor;
import com.dice.weather.service.base.BaseServiceImpl;
import com.dice.weather.utils.ApiCalls;
import com.dice.weather.utils.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

//import static com.dice.weather.utils.ApiCalls.makeApiCall;

@Service
public class WeatherService extends BaseServiceImpl implements WeatherInterface{


    @Autowired
    private AuthInterceptor authInterceptor;
    @Autowired
    private ApiCalls apiCalls;

    @Override
    public GlobalApiResponse getForecastSummaryReport(String city, String basicAuth){

        try {
            if (authInterceptor.authenticate(basicAuth)) {
                Logging.printLog(LogLevel.CRITICAL.getLabel(), "weather-forecast","forecast-summary",true,null,null,"User is Not Authenticated",null,"500",null);
                throw new WeatherServiceException("Invalid client id or password","WET-001", HttpStatus.BAD_REQUEST);
            }

            String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/summary/";
            Logging.printLog(LogLevel.INFO.getLabel(), "weather-forecast","forecast-summary",false,null,null,"Data Fetched Successfully",null,"200",null);

            return successResponse("Data Fetched Successfully",200,apiCalls.makeApiCall(url));
        }
        catch (WeatherServiceException e) {
            Logging.printLog(LogLevel.CRITICAL.getLabel(), "weather-forecast","forecast-summary",true,null,null,"Data Not Fetched Successfully",null,"500",null);
            return errorResponse("Internal Server Error",500,null);
        }
        catch (Exception e){
            Logging.printLog(LogLevel.CRITICAL.getLabel(), "weather-forecast","forecast-summary",true,null,null,"Data Not Fetched Successfully",null,"500",null);
            return errorResponse("Internal Server Error",500,null);
        }

    }
    @Override
    public GlobalApiResponse getHourlyForecastReport(String city, String basicAuth){
        if (authInterceptor.authenticate(basicAuth)) {
            Logging.printLog(LogLevel.CRITICAL.getLabel(), "weather-forecast","hourly-forecast",true,null,null,"User is Not Authenticated",null,"500",null);
            return errorResponse("Authentication Failed",500,null);
        }

        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/hourly/";
        Logging.printLog(LogLevel.INFO.getLabel(), "weather-forecast","hourly-forecast",false,null,null,"Data Fetched Successfully",null,"200",null);
        return successResponse("Data Fetched Successfully",200,apiCalls.makeApiCall(url));
    }


}
