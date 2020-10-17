package com.microservices.msscbrewery.web.controller;

import com.microservices.msscbrewery.web.model.BeerDto;
import com.microservices.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    // Note: It's easy to miss RequestBody Annotation, keep an eye
    @PostMapping
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.createBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo: Add host name to the return url
        headers.add("location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody  BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);

        // NO-CONTENT means I accepted your request and did an update, nothing to return as such
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // ResponseStatus annotation will send the response status without actually returning ResponseEntity
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable  UUID beerId) {
        beerService.deleteByID(beerId);
    }
}
