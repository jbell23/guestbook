package com.joseph.beer.service;

import com.joseph.beer.domain.BeerEntry;
import com.joseph.beer.domain.BeerEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerEntryRepository beerEntryRepository;

    public List <BeerEntry> findAllEntries () {
        return this.beerEntryRepository.findAll ();
    }

    public BeerEntry findBeerEntryById (Integer id) {
        return this.beerEntryRepository.findBeerEntryById(id);
    }

    public List <BeerEntry> findBeerEntryByBeer (String beer) {
        return this.beerEntryRepository.findBeerEntryByBeer (beer);
    }

    public void deleteBeerEntryById (Integer id) {
        this.beerEntryRepository.delete (id);
    }

    public void save (BeerEntry newEntry) {
        this.beerEntryRepository.save (newEntry);
    }

    public BeerEntry findOne (Integer id) {
        return this.beerEntryRepository.findOne(id);
    }
}
