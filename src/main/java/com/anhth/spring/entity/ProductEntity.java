package com.anhth.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

    @Column(name = "categoryid")
    private Integer categoryid;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.PERSIST) //EAGER
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_attribute",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    private List<AttributeEntity> listAttribute;

}
