package com.microservices.msscbrewery.web.controller.v2;

import com.microservices.msscbrewery.web.model.BeerDto;
import com.microservices.msscbrewery.web.model.v2.BeerDtoV2;
import com.microservices.msscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    // Note: It's easy to miss RequestBody Annotation, keep an eye
    @PostMapping
    public ResponseEntity createBeer(@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = beerService.createBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo: Add host name to the return url
        headers.add("location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerId, beerDto);

        // NO-CONTENT means I accepted your request and did an update, nothing to return as such
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // ResponseStatus annotation will send the response status without actually returning ResponseEntity
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteByID(beerId);
    }
}
