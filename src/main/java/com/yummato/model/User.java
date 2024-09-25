package com.yummato.model;

import com.yummato.Dto.RestaurentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String fullname;

    private String email;

    private String password;

    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurentDto> favourites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Address> addresses = new ArrayList<>();
}
