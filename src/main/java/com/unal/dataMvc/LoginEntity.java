package com.unal.dataMvc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2


@Entity
@Table(name="admin_entity" )
public class LoginEntity {
    @Id//
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name="id" , updatable = false)
    private Long id;

    @Column( name="name")
    private String name;

    @Column( name="email")
    private String email;

    @Column( name="password")
    private int password;
}