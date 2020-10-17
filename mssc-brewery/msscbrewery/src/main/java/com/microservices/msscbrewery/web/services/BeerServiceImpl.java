package com.microservices.msscbrewery.web.services;

import com.microservices.msscbrewery.web.model.BeerDto;
import com.microservices.msscbrewery.web.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo - we will be adding the impl later
    }

    @Override
    public void deleteByID(UUID beerID) {
      log.info("Delting a beer");
    }
}
