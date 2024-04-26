package com.dice.weather.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class AuthInterceptor {

    @Value("${auth.username}")
    private String AUTH_USERNAME;

    @Value("${auth.password}")
    private String AUTH_PASSWORD;

    public boolean authenticate(String basicAuth) {
        if (basicAuth == null || !basicAuth.startsWith("Basic ")) {
            return true;
        }

        String encodedCredentials = basicAuth.substring("Basic ".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);

        String[] parts = credentials.split(":", 2);
        if (parts.length != 2) {
            return true;
        }

        String clientId = parts[0];
        String clientSecret = parts[1];

        return !validateClientCredentials(clientId, clientSecret);
    }

    private boolean validateClientCredentials(String clientId, String clientSecret) {
        if (clientId == null || clientSecret == null) {
            return false;
        }
        return clientId.equals(AUTH_USERNAME) && clientSecret.equals(AUTH_PASSWORD);
    }

}
