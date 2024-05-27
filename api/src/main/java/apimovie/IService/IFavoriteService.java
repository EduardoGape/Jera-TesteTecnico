package apimovie.IService;

import java.util.List;
import java.util.Optional;

import apimovie.Model.Favorite;

public interface IFavoriteService {
    List<Favorite> getAllFavorites();
    Optional<Favorite> getFavoriteById(String id);
    Favorite createFavorite(Favorite favorite);
    Favorite updateFavorite(String id, Favorite favorite);
    void deleteFavorite(String id);
}
