package net.msj0319.api.item.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.msj0319.api.order.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name =  "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //PK를 자동으로 생성해주는 어노테이션
    @Column(name = "Item_id")
    private long itemNo;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "model_no")
    private String modelNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_color")
    private String itemColor;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "sold_out")
    private Boolean soldOut;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    @Builder //All, NoArgs도 아닌 내가 필요한 것만
    public Item(String itemBrand, String itemName,String itemColor){
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemColor = itemColor;
    }
    @Override public String toString(){
        return String.format("아이템 스펙: %s, %s, %s ", itemBrand, itemName,itemColor);
    }
}
