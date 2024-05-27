package apimovie.Repository;

import apimovie.Model.Watched;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WatchedRepository extends MongoRepository<Watched, String> {
    
}