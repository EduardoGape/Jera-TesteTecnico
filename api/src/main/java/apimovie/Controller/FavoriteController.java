package apimovie.Controller;

import apimovie.Model.Favorite;
import apimovie.IService.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Favorite")
public class FavoriteController {


    @Autowired
    private IFavoriteService FavoriteService;

    @GetMapping("/")
    public List<Favorite> getAllFavorites() {
        return FavoriteService.getAllFavorites();
    }

    @GetMapping("/{id}")
    public Optional<Favorite> getFavoriteById(@PathVariable String id) {
        return FavoriteService.getFavoriteById(id);
    }

    @PostMapping("/")
    public Favorite createFavorite(@RequestBody Favorite Favorite) {
        return FavoriteService.createFavorite(Favorite);
    }

    @PutMapping("/{id}")
    public Favorite updateFavorite(@PathVariable String id, @RequestBody Favorite Favorite) {
        return FavoriteService.updateFavorite(id, Favorite);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable String id) {
        FavoriteService.deleteFavorite(id);
    }

}
