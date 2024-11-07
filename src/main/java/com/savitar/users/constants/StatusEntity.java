package com.savitar.users.constants;

import lombok.Getter;

@Getter
public enum StatusEntity {
    ACTIVE(1),
    INACTIVE(0);

    private final int status;

    StatusEntity(int status) {
        this.status = status;
    }

}
