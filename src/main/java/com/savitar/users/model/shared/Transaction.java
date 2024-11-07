package com.savitar.users.model.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String trHost;
    private String trUsuarioId;
    private Date trFecha;
}
