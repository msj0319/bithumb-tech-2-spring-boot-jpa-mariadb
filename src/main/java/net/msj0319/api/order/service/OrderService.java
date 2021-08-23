package net.msj0319.api.order.service;

import net.msj0319.api.order.domain.Order;
import net.msj0319.api.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(long id);
    void save(Order item);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
}
