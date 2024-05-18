package org.ericwubbo.requestparamdemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameContainsIgnoreCase(String query);

    List<Item> findByNameContainsIgnoreCaseAndPriceLessThanEqual(String query, double price);
}
