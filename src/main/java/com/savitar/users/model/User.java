package com.savitar.users.model;

import com.savitar.users.model.shared.EntityAud;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "users_db")
public class User extends EntityAud {
    @Id
    @Column(name = "user_id", nullable = false, length = 200)
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @OneToMany(mappedBy = "usersUser")
    private Set<RolsUser> rolsUsers = new LinkedHashSet<>();

}