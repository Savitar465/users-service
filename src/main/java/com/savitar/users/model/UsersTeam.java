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
@Table(name = "users_teams", schema = "users_db")
public class UsersTeam {
    @Id
    @Column(name = "team_user_id", nullable = false, length = 200)
    private String teamUserId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teams_team_id", nullable = false)
    private Team teamsTeam;

    @Column(name = "users_user_id", nullable = false)
    private String usersUser;

}