package com.alura._spring_challenge.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversor implements IDataConversor{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtainingData(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
