-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-07-23 06:37:31.625

-- tables
-- Table: permissions
CREATE TABLE permissions (
    permission_id varchar(200)  NOT NULL,
    name varchar(500)  NOT NULL,
    description varchar(200)  NOT NULL,
    _status int  NOT NULL,
    creator varchar(200)  NOT NULL,
    created_at datetime  NOT NULL,
    updater varchar(200)  NOT NULL,
    updated_at datetime  NOT NULL,
    CONSTRAINT permissions_pk PRIMARY KEY (permission_id)
);

-- Table: permissions_rols
CREATE TABLE permissions_rols (
    permission_rol_id varchar(200)  NOT NULL,
    rols_rol_id varchar(200)  NOT NULL,
    permisssions_permission_id varchar(200)  NOT NULL,
    CONSTRAINT permissions_rols_pk PRIMARY KEY (permission_rol_id)
);

CREATE INDEX permissions_idx_permission_rols ON permissions_rols (permisssions_permission_id);

CREATE INDEX rols_idx_permissions_rols ON permissions_rols (rols_rol_id);

-- Table: rols
CREATE TABLE rols (
    rol_id varchar(200)  NOT NULL,
    name varchar(500)  NOT NULL,
    description int  NOT NULL,
    _status int  NOT NULL,
    creator varchar(200)  NOT NULL,
    created_at datetime  NOT NULL,
    updater varchar(200)  NOT NULL,
    updated_at datetime  NOT NULL,
    CONSTRAINT rols_pk PRIMARY KEY (rol_id)
);

-- Table: rols_users
CREATE TABLE rols_users (
    rol_usuario_id varchar(200)  NOT NULL,
    users_user_id varchar(200)  NOT NULL,
    rols_rol_id varchar(200)  NOT NULL,
    CONSTRAINT rols_users_pk PRIMARY KEY (rol_usuario_id)
);

CREATE INDEX users_idx_rols_users ON rols_users (users_user_id);

CREATE INDEX rols_idx_rols_users ON rols_users (rols_rol_id);

-- Table: teams
CREATE TABLE teams (
    team_id varchar(200)  NOT NULL,
    name varchar(500)  NOT NULL,
    description varchar(800)  NOT NULL,
    type char(5)  NOT NULL,
    _status int  NOT NULL,
    creator varchar(200)  NOT NULL,
    created_at datetime  NOT NULL,
    updater varchar(200)  NOT NULL,
    updated_at datetime  NOT NULL,
    CONSTRAINT teams_pk PRIMARY KEY (team_id)
);

-- Table: users
CREATE TABLE users (
    user_id varchar(200)  NOT NULL,
    email varchar(200)  NOT NULL,
    username varchar(200)  NOT NULL,
    password text  NOT NULL,
    names varchar(800)  NOT NULL,
    last_names varchar(800)  NOT NULL,
    birthday datetime  NOT NULL,
    _status int  NOT NULL,
    creator varchar(200)  NOT NULL,
    created_at datetime  NOT NULL,
    updater varchar(200)  NOT NULL,
    updated_at datetime  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);

-- Table: users_teams
CREATE TABLE users_teams (
    team_user_id varchar(200)  NOT NULL,
    teams_team_id varchar(200)  NOT NULL,
    users_user_id varchar(200)  NOT NULL,
    CONSTRAINT users_teams_pk PRIMARY KEY (team_user_id)
);

CREATE INDEX users_teams_idx_teams ON users_teams (teams_team_id);

CREATE INDEX users_teams_idx_users ON users_teams (users_user_id);

-- foreign keys
-- Reference: permisions_rols_permissions (table: permissions_rols)
ALTER TABLE permissions_rols ADD CONSTRAINT permisions_rols_permissions FOREIGN KEY permisions_rols_permissions (permisssions_permission_id)
    REFERENCES permissions (permission_id);

-- Reference: permissions_rols_rols (table: permissions_rols)
ALTER TABLE permissions_rols ADD CONSTRAINT permissions_rols_rols FOREIGN KEY permissions_rols_rols (rols_rol_id)
    REFERENCES rols (rol_id);

-- Reference: rols_users_rols (table: rols_users)
ALTER TABLE rols_users ADD CONSTRAINT rols_users_rols FOREIGN KEY rols_users_rols (rols_rol_id)
    REFERENCES rols (rol_id);

-- Reference: rols_users_users (table: rols_users)
ALTER TABLE rols_users ADD CONSTRAINT rols_users_users FOREIGN KEY rols_users_users (users_user_id)
    REFERENCES users (user_id);

-- Reference: teams_users_teams (table: users_teams)
ALTER TABLE users_teams ADD CONSTRAINT teams_users_teams FOREIGN KEY teams_users_teams (teams_team_id)
    REFERENCES teams (team_id);

-- Reference: teams_users_users (table: users_teams)
ALTER TABLE users_teams ADD CONSTRAINT teams_users_users FOREIGN KEY teams_users_users (users_user_id)
    REFERENCES users (user_id);

-- End of file.

