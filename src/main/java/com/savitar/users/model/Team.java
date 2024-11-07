package com.savitar.users.model;

import com.savitar.users.model.shared.EntityAud;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams", schema = "users_db")
public class Team extends EntityAud {
    @Id
    @Column(name = "team_id", nullable = false, length = 200)
    private String teamId;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Column(name = "description", nullable = false, length = 800)
    private String description;

    @Column(name = "type", nullable = false, length = 5)
    private String type;

    @OneToMany(mappedBy = "teamsTeam")
    private Set<UsersTeam> usersTeams = new LinkedHashSet<>();

}