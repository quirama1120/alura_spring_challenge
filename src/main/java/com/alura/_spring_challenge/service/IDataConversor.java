package com.alura._spring_challenge.service;

public interface IDataConversor {
    <T> T obtainingData (String json, Class <T> tClass);
}
