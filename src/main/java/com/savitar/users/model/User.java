package com.savitar.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "users_db")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 200)
    private String userId;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "names", nullable = false, length = 800)
    private String names;

    @Column(name = "last_names", nullable = false, length = 800)
    private String lastNames;

    @Column(name = "birthday", nullable = false)
    private Instant birthday;

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

    @OneToMany(mappedBy = "usersUser")
    private Set<RolsUser> rolsUsers = new LinkedHashSet<>();

}