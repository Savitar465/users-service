package com.savitar.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "permissions", schema = "users_db")
public class Permission {
    @Id
    @Column(name = "permission_id", nullable = false, length = 200)
    private String permissionId;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "_status", nullable = false)
    private Integer status;

    @Column(name = "creator", nullable = false, length = 200)
    private String creator;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updater", nullable = false, length = 200)
    private String updater;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "permisssionsPermission")
    private Set<PermissionsRol> permissionsRols = new LinkedHashSet<>();

}