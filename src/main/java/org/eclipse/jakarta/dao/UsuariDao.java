package org.eclipse.jakarta.dao;

import org.eclipse.jakarta.model.Escola;
import org.eclipse.jakarta.model.Usuari;

import java.util.List;

public interface UsuariDao {

    List<Usuari> findAll();
    Usuari findByUsernamePasswordEscola(String usuari,String password, Long escola);
}
