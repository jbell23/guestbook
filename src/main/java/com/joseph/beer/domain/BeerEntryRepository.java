package com.joseph.beer.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BeerEntryRepository
        extends CrudRepository<BeerEntry, Integer> {

    @Override
    List <BeerEntry> findAll ();

    BeerEntry findBeerEntryById (Integer id);

    List<BeerEntry> findBeerEntryByBeer (String beer);
}