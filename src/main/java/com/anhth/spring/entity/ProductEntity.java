package com.anhth.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne() //EAGER
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private CategoryEntity category;

    //cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}
    //CascadeType.REMOVE: khi xóa thì các data liên quan cũng bị xóa
    //CascadeType.PERSIST: Khi insert listAttribute thì tạo mới luôn các Attribute
    //CascadeType.MERGE: Khi insert listAttribute, nếu truyền thêm param Attribute id thì update không tạo mới các Attribute
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "product_attribute",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    private List<AttributeEntity> listAttribute;

}
/* Request mẫu dùng MERGE,
// Nếu dùng PERSIST thì bỏ id trong listAttribute
{
        "name": "Note 11",
        "price": 1000,
        "quantity": 10,
        "categoryid":2,
        "listAttribute": [
        {
            "id": 4,
            "name":"Size L"
        },
        {
            "id": 5,
            "name":"Size XL"
        }
        ]
        }

 */