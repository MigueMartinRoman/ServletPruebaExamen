package org.eclipse.jakarta.model;

import lombok.Data;

@Data
public class Usuari {

    private String username;
    private String password;
    private Long id_escola;
    private String rol;
}
