package com.anhth.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username")
    private String username;
}
