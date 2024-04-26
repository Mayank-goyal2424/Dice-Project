package com.dice.weather.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ApiCalls {
    @Value("${rapid.key}")
    private  String RAPID_API_KEY ;

    @Value("${rapid.host}")
    private  String RAPID_API_HOST;
    public  String makeApiCall(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", RAPID_API_KEY);
        headers.set("X-RapidAPI-Host", RAPID_API_HOST);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
