package com.savitar.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rols_users", schema = "users_db")
public class RolsUser {
    @Id
    @Column(name = "rol_usuario_id", nullable = false, length = 200)
    private String rolUsuarioId;

    @Column(name = "users_user_id", nullable = false)
    private String usersUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rols_rol_id", nullable = false)
    private Rol rolsRol;

}