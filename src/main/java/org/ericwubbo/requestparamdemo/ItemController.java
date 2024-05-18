package org.ericwubbo.requestparamdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public Iterable<Item> getAll(@RequestParam String contains,
                                 @RequestParam(name="max-price", required=false) Double maxPrice) {
        return maxPrice == null ? itemRepository.findByNameContainsIgnoreCase(contains) :
                itemRepository.findByNameContainsIgnoreCaseAndPriceLessThanEqual(contains, maxPrice);
    }
}
