package net.msj0319.api.item.controller;

import net.msj0319.api.item.domain.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @GetMapping
    public List<Item> findAll() {
        return null;
    }

    @GetMapping("{/id}")
    public Optional<Item> findById(@PathVariable long id) {
        return Optional.empty();
    }

    @PostMapping
    public void save(Item item) {

    }
    @PutMapping
    public void update(Item item) {

    }

    @GetMapping("/exist/{id}")
    public boolean existById(long id) {
        return false;
    }

    @GetMapping("/count")
    public long count() {
        return 0;
    }

    @DeleteMapping
    public void deleteById(long id) {

    }

}
