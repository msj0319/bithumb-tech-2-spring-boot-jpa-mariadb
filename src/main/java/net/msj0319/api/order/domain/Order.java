package net.msj0319.api.order.domain;

import lombok.Data;
import net.msj0319.api.item.domain.Item;
import net.msj0319.api.user.domain.User;

import javax.persistence.*;

@Entity
@Data
@Table(name =  "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "price")
    private long price;

    @Column(name = "order_status")
    private String count;

    //user하고 item이 등록이 되어야만 order 객체가 생성되는 방식이다. -> LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    //유저와 아이템을 조인하여 연결
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    //유저와 아이템을 조인하여 연결
    @JoinColumn(name = "item_id")
    private Item item;
}
