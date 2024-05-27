package apimovie.ServiceImpl;

import apimovie.Model.Watched;
import apimovie.IService.IWatchedService;
import apimovie.Repository.WatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class WatchedService implements IWatchedService {

    @Autowired
    private final WatchedRepository watchedRepository;

    @Autowired
    public WatchedService(WatchedRepository watchedRepository) {
        this.watchedRepository = watchedRepository;
    }

    @Override
    public List<Watched> getAllWatcheds() {
        return watchedRepository.findAll();
    }

    @Override
    public Optional<Watched> getWatchedById(String id) {
        return watchedRepository.findById(id);
    }

    @Override
    public Watched createWatched(Watched Watched) {
        Watched.setId(UUID.randomUUID().toString());
        return watchedRepository.save(Watched);
    }

    @Override
    public Watched updateWatched(String id, Watched Watched) {
        Watched.setId(id);
        return watchedRepository.save(Watched);
    }

    @Override
    public void deleteWatched(String id) {
        watchedRepository.deleteById(id);
    }
    
}

