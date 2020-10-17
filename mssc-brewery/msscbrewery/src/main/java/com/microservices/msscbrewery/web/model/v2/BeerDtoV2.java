package com.microservices.msscbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
/* Version Demo: This class is an enhancement over BeerDto class,
here BeerStyls is an enum.

Once common convention to manage versoning is creating a separate package(as we have done here) for
each version/
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
