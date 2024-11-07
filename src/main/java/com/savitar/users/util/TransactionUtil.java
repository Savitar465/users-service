package com.savitar.users.util;

import com.savitar.users.model.shared.Transaction;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public class TransactionUtil {

    private TransactionUtil() {
    }

    public static Transaction createTransaction(HttpServletRequest request) {
        return Transaction.builder()
                .trFecha(new Date())
                .trHost(request.getRemoteHost())
//                .trUsuarioId(idUser) TODO: Implementar el id del usuario
                .build();
    }
}
