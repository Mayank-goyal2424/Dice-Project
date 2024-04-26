package com.dice.weather.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogLevel {
    CRITICAL(1, "critical", "Critical error log type"),
    INFO(2, "info", "Informational log type"),
    DEBUG(3, "debug", "Debugging log type");

    private final int id;
    private final String label;
    private final String description;
}
