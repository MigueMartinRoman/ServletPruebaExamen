package org.eclipse.jakarta.service;

import org.eclipse.jakarta.dao.Crud;
import org.eclipse.jakarta.model.Escola;
import org.eclipse.jakarta.model.Usuari;

public interface UsuarioService extends Crud<Usuari> {
    //Usuari login(String user, String password, Escola escola);

    Usuari findUserByUsernamePasswordEscola(String user, String pass, Long escola);
}
