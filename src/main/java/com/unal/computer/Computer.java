package com.unal.computer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "computers")
public class Computer implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long computerId;

    @Column(name = "name", unique = true)// unique >> benzersin olacak diyor
    private String computerName;

    @Column(name = "trade")
    private String computerTrade;

    @Column(name = "price", length = 7, nullable = false) // null olamaz
    private double computerPrice;

    @Column(name = "date", insertable = false) // insertable ekleme yapılamaz
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

}
