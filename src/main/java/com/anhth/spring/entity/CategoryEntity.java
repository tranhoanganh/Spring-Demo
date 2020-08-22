package com.anhth.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "url")
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}
