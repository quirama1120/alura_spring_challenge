package com.alura._spring_challenge.main;
import com.alura._spring_challenge.model.ApiResponse;
import com.alura._spring_challenge.model.DataSerie;
import com.alura._spring_challenge.service.ApiCall;
import com.alura._spring_challenge.service.DataConversor;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    public List<DataSerie> principalLogic () throws IOException, InterruptedException {
        boolean out = true;
        while   (out) {
            System.out.println("""
                    Escoge la opción que deseas visualizar
                    1. Los animes más vistos.
                    2. Los películas de anime mejor calificadas.
                    3. Los estrenos de las próximas temporadas.
                    4. ¿Deseas buscar los datos de un anime en específico?
                    0. Terminar la ejecución del programa.
                    """);
            Scanner keyword = new Scanner(System.in);
            int userInput = keyword.nextInt();
            DataConversor dataConversor = new DataConversor();
            ApiCall apiCall = new ApiCall();
            switch (userInput) {
                case 1 -> {
                    System.out.println("El top 5 de los animes más populares es: ");
                    String apiCallResponse =  apiCall.apiCallRequest("https://api.jikan.moe/v4/top/anime?sfw");
                    ApiResponse apiResponse = dataConversor.obtainingData(apiCallResponse, ApiResponse.class);
                    apiResponse.data().stream()
                            .limit(5)
                            .forEach(an -> System.out.println(
                                    " -- " + an.title()));
                } case 2 -> {
                    System.out.println("El top 5 de las películas mejor calificados son: ");
                    String apiCallResponse =  apiCall.apiCallRequest("https://api.jikan.moe/v4/top/anime?type=ova");
                    ApiResponse apiResponse = dataConversor.obtainingData(apiCallResponse, ApiResponse.class);
                    apiResponse.data().stream()
                            .limit(5)
                            .forEach(an -> {
                                System.out.println(" -- " + an.title() + " con una puntuación de: "
                                + an.score());
                            });
                }
                case 3 -> {
                    System.out.println("Los próximos estrenos son: ");
                    String apiCallResponse =  apiCall.apiCallRequest("https://api.jikan.moe/v4/seasons/upcoming");
                    ApiResponse apiResponse = dataConversor.obtainingData(apiCallResponse, ApiResponse.class);
                    apiResponse.data().stream()
                            .limit(7)
                            .forEach(an -> {
                                System.out.println(an.title() +  " con fecha de estreno estimada " + an.year());
                            });
                } case 4 -> {
                    System.out.println("Ingresa el nombre del anime que deseas buscar");
                    keyword.nextLine();
                    String animeInput = keyword.nextLine();
                    String animeInputUrl = animeInput.replaceAll(" ", "+");
                    String apiCallResponse =  apiCall.apiCallRequest("https://api.jikan.moe/v4/anime?q="
                            + animeInputUrl);
                    ApiResponse apiResponse = dataConversor.obtainingData(apiCallResponse, ApiResponse.class);
                    apiResponse.data().stream()
                            .limit(1)
                            .forEach(an -> {
                                System.out.println("Anime: " + an.title()
                                + " Año: " + an.year()
                                + " Calificación " + an.score() +
                                " Popularidad: " + an.popularity());
                            });
                }
                case 0 -> {
                    System.out.println("Terminando la ejecución del programa...");
                    out = false;
                }
            }
        }
        return null;
    }
}
