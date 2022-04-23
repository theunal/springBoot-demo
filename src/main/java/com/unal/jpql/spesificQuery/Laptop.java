package com.unal.jpql.spesificQuery;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "laptops")
public class Laptop implements Serializable {
    public final static long serialVersionUID = 1L;


    @Id
    @Column(name = "laptopId",nullable = false)
    private Long id;

    @Column(name = "laptopName")
    private String laptopName;


    @Column(name = "laptopPrice")
    private double laptopPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
