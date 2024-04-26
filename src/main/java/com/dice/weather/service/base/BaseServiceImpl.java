package com.dice.weather.service.base;

import com.dice.weather.controller.base.GlobalApiResponse;

public class BaseServiceImpl {
    protected GlobalApiResponse successResponse(String message, Integer statusCode, Object data) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatusCode(statusCode);
        globalApiResponse.setStatus(true);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }

    protected GlobalApiResponse errorResponse(String message, Integer statusCode,Object errors) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatusCode(statusCode);
        globalApiResponse.setStatus(false);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(errors);
        return globalApiResponse;
    }
}
