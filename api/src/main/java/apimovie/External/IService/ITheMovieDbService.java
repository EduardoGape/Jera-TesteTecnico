package apimovie.External.IService;

import java.util.concurrent.CompletableFuture;

import apimovie.External.Model.ApiResponse;
import apimovie.External.Model.MovieApiResponse;

public interface  ITheMovieDbService {
    CompletableFuture<ApiResponse> callExternalApi(); 
    CompletableFuture<MovieApiResponse> searchMovie(String query);
}
