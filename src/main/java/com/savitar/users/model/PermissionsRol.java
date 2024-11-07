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
@Table(name = "permissions_rols", schema = "users_db")
public class PermissionsRol {
    @Id
    @Column(name = "permission_rol_id", nullable = false, length = 200)
    private String permissionRolId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rols_rol_id", nullable = false)
    private Rol rolsRol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permisssions_permission_id", nullable = false)
    private Permission permisssionsPermission;

}