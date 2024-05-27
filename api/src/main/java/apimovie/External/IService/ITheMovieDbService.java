package apimovie.External.IService;

import java.util.concurrent.CompletableFuture;

import apimovie.External.Model.ApiResponse;

public interface  ITheMovieDbService {
    CompletableFuture<ApiResponse> callExternalApi(); 
}
