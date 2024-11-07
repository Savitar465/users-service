package com.savitar.users.model.shared;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EntityAud {
    @Column(name = "_status", nullable = false)
    private Integer status;

    @Column(name = "creator", nullable = false, length = 200)
    private String creator;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updater", nullable = false, length = 200)
    private String updater;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
