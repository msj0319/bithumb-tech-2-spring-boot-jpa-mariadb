package net.msj0319.api.order.controller;

import net.msj0319.api.order.domain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public List<Order> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable long id) {
        return Optional.empty();
    }

    @PostMapping
    public void save(Order order) {

    }
    @PutMapping
    public void update(Order order) {

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
