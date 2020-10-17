package com.microservices.msscbrewery.web.services.v2;

import com.microservices.msscbrewery.web.model.v2.BeerDtoV2;
import com.microservices.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.DESI)
                .build();
    }

    @Override
    public BeerDtoV2 createBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).build();

    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.info("Updating....");
    }

    @Override
    public void deleteByID(UUID beerId) {
        log.info("Deleting...");
    }
}
