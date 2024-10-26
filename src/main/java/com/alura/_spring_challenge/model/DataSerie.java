package com.alura._spring_challenge.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(
        String title,
        Integer year,
        Integer score,
        Integer popularity) {
}
