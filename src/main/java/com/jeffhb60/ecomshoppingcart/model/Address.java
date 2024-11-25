package com.jeffhb60.ecomshoppingcart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotBlank
    @Column(name = "street")
    private String street;

    @NotBlank
    @Column(name = "building_name")
    private String buildingName;

    @NotBlank
    @Column(name = "city")
    private String city;

    @NotBlank
    @Column(name = "state")
    private String state;

    @NotBlank
    @Column(name = "zip")
    private String zip;

    @NotBlank
    @Column(name = "country")
    private String country;

    @NotBlank
    @Column(name = "pin_code")
    private String pinCode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String buildingName, String city, String country, String pinCode, String state, String street, List<User> users, String zip) {
        this.buildingName = buildingName;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
        this.state = state;
        this.street = street;
        this.users = users;
        this.zip = zip;
    }
}
