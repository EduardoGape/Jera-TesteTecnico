package apimovie.External.Service;

import apimovie.External.IService.ITheMovieDbService;
import apimovie.External.Model.ApiResponse;
import apimovie.External.Model.MovieApiResponse;
import apimovie.External.Model.EnumTheMovieDBUrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


@Service
public class TheMovieDbService implements ITheMovieDbService {

    @Value("${themoviedb.app.url}")
    private String url;

    @Value("${themoviedb.app.token}")
    private String token;

    @Override
    public CompletableFuture<ApiResponse> callExternalApi() {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url+EnumTheMovieDBUrl.AUTHENTICATION.getDescription()))
            .header("accept", "application/json")
            .header("Authorization", "Bearer " + token)
            .GET()
            .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> {
                ApiResponse apiResponse = new ApiResponse();
                apiResponse.setSuccess(response.statusCode() == 200);
                apiResponse.setStatusCode(response.statusCode());
                apiResponse.setStatusMessage(response.body());

                System.out.println(apiResponse.toString());

                return apiResponse;
            });
    }
    public CompletableFuture<MovieApiResponse> searchMovie(String query) {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + EnumTheMovieDBUrl.SEARCHMOVIE.getDescription() + "?query=" + query))
            .header("accept", "application/json")
            .header("Authorization", "Bearer " + token)
            .GET()
            .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> {
                ObjectMapper mapper = new ObjectMapper();
                MovieApiResponse apiResponse = null;
                try {
                    apiResponse = mapper.readValue(response.body(), MovieApiResponse.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    apiResponse = new MovieApiResponse();
                }

                System.out.println(apiResponse.toString());

                return apiResponse;
            });
    }
}
