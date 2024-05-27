package apimovie.Controller;

import apimovie.External.Model.ApiResponse;
import apimovie.External.Service.TheMovieDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/theMovieDb")
public class TheMovieDBController {


    @Autowired
    private TheMovieDbService theMovieDb;

    @GetMapping("/Token")
    public CompletableFuture<ApiResponse> callExternalApi() {
        return theMovieDb.callExternalApi();
    }

}
