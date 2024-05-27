package apimovie.Controller;

import apimovie.Model.Watched;
import apimovie.IService.IWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Watched")
public class WatchedController {


    @Autowired
    private IWatchedService WatchedService;

    @GetMapping("/")
    public List<Watched> getAllWatcheds() {
        return WatchedService.getAllWatcheds();
    }

    @GetMapping("/{id}")
    public Optional<Watched> getWatchedById(@PathVariable String id) {
        return WatchedService.getWatchedById(id);
    }

    @PostMapping("/")
    public Watched createWatched(@RequestBody Watched Watched) {
        return WatchedService.createWatched(Watched);
    }

    @PutMapping("/{id}")
    public Watched updateWatched(@PathVariable String id, @RequestBody Watched Watched) {
        return WatchedService.updateWatched(id, Watched);
    }

    @DeleteMapping("/{id}")
    public void deleteWatched(@PathVariable String id) {
        WatchedService.deleteWatched(id);
    }

}
