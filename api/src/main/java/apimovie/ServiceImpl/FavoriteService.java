package apimovie.ServiceImpl;

import apimovie.Model.Favorite;
import apimovie.IService.IFavoriteService;
import apimovie.Repository.FavoriteRepository;
import apimovie.Repository.WatchedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FavoriteService implements IFavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

     @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public Optional<Favorite> getFavoriteById(String id) {
        return favoriteRepository.findById(id);
    }

    @Override
    public Favorite createFavorite(Favorite Favorite) {
        Favorite.setId(UUID.randomUUID().toString());
        return favoriteRepository.save(Favorite);
    }

    @Override
    public Favorite updateFavorite(String id, Favorite Favorite) {
        Favorite.setId(id);
        return favoriteRepository.save(Favorite);
    }

    @Override
    public void deleteFavorite(String id) {
        favoriteRepository.deleteById(id);
    }
    
}

