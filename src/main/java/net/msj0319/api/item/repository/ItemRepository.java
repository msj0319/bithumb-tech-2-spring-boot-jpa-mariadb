package net.msj0319.api.item.repository;

import net.msj0319.api.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//CRUD
public interface ItemRepository extends JpaRepository<Item, Long> { //JPARepositiory<domain, pk type>

}
