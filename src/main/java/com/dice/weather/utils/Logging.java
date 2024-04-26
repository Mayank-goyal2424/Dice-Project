package com.dice.weather.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logging {
    public static void printLog(String logLevelCode, String step, String platform,Boolean isError, String userId, String loanRequestId, String message, String description, String errorCode, String uuId){
        if(isError){
            log.error("log-level : " + logLevelCode + " || " +
                    "step : " + step + " || " +
                    "platform : " + platform + " || " +
                    "isError : " + isError + " || " +
                    "user-id : " + userId + " || " +
                    "loan-id : " + loanRequestId + " || " +
                    "message : " + message + " || " +
                    "description : " + description + " || " +
                    "error-code : " + errorCode + " || " +
                    "uuid : " + uuId
            );
        }else {
            log.info("log-level : " + logLevelCode + " || " +
                    "step : " + step + " || " +
                    "platform : " + platform + " || " +
                    "user-id : " + userId + " || " +
                    "loan-id : " + loanRequestId + " || " +
                    "message : " + message + " || " +
                    "description : " + description + " || " +
                    "uuid : " + uuId
            );
        }
    }
}
