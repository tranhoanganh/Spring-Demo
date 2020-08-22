package com.anhth.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    //Nếu không dùng AuditingEntityListener có thể dùng cách này
    //    @PrePersist
//    protected void prePersist() {
//        if (this.createdAt == null) createdAt = new Date();
//        if (this.updatedAt == null) updatedAt = new Date();
//    }
//
//    @PreUpdate
//    protected void preUpdate() {
//        this.updatedAt = new Date();
//    }
}
