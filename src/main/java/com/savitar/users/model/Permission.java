package com.savitar.users.model;

import com.savitar.users.model.shared.EntityAud;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "permissions", schema = "users_db")
public class Permission extends EntityAud {
    @Id
    @Column(name = "permission_id", nullable = false, length = 200)
    private String permissionId;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @OneToMany(mappedBy = "permisssionsPermission")
    private Set<PermissionsRol> permissionsRols = new LinkedHashSet<>();

}