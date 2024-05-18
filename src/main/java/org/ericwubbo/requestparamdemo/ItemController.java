package org.ericwubbo.requestparamdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public Iterable<Item> getAll(@RequestParam String contains, @RequestParam(required=false) Double maxPrice) {
        // note: @RequestParam(required=false) Double maxPrice _could_ be written as
        // @RequestParam Optional<Double> maxPrice, but IntelliJ doesn't like Optional arguments
        return itemRepository.findAll();
    }
}
