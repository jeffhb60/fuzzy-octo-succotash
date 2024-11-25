package com.jeffhb60.ecomshoppingcart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "role_name", nullable = false)
    private AppRole roleName;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }

}
