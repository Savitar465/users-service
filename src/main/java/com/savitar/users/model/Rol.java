package com.savitar.users.model;

import com.savitar.users.model.shared.EntityAud;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "rols", schema = "users_db")
public class Rol extends EntityAud {
    @Id
    @Column(name = "rol_id", nullable = false, length = 200)
    private String rolId;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Column(name = "description", nullable = false)
    private Integer description;

}