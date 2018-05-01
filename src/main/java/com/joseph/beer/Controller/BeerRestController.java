package com.joseph.beer.Controller;

import com.joseph.beer.domain.BeerEntry;
import com.joseph.beer.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class BeerRestController {

    @Autowired
    private BeerService beerService;

    @GetMapping ("/comments")
    public List <BeerEntry> testMapping () {
        return beerService.findAllEntries ();
    }

    @GetMapping ("/comments/{id}")
    public BeerEntry findBeerEntryById (@PathVariable ("id") Integer id)  {
        return this.beerService.findBeerEntryById (id);
    }

    @GetMapping ("/beer/{beer}")
    public List <BeerEntry> findBeerEntryByBeer (@PathVariable ("beer") String beer) {
        return this.beerService.findBeerEntryByBeer (beer);
    }

    @DeleteMapping ("/comments/{id}")
    public void deleteBeerEntryById (@PathVariable ("id") Integer id) {
        this.beerService.deleteBeerEntryById (id);
    }

    @PostMapping ("/add")
    public void addComment (@RequestBody BeerEntry beerEntry) {
        this.beerService.save (beerEntry);
    }

    @PostMapping ("/update")
    public void updateComment (@RequestBody BeerEntry beerEntry) {
        this.beerService.save(beerEntry);
    }
}
