package com.alura._spring_challenge.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties (ignoreUnknown = true)
public record ApiResponse(List<DataSerie> data) {
}
