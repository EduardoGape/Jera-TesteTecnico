
package apimovie.IService;

import java.util.List;
import java.util.Optional;

import apimovie.Model.Watched;

public interface IWatchedService {
    List<Watched> getAllWatcheds();
    Optional<Watched> getWatchedById(String id);
    Watched createWatched(Watched watched);
    Watched updateWatched(String id, Watched watched);
    void deleteWatched(String id);
}
