package com.dice.weather.controller.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse {
    private Integer statusCode;
    private boolean status;
    private String message;
    private Object data;
}
