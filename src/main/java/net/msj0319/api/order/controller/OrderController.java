package net.msj0319.api.order.controller;

import net.msj0319.api.order.domain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    public List<Order> findAll() {
        return null;
    }

    public Optional<Order> findById(@PathVariable long id) {
        return Optional.empty();
    }

    public void save(Order order) {

    }
    public void update(Order order){

    }

    @GetMapping("/exists/{id}")
    public boolean existsById(long id) {
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
