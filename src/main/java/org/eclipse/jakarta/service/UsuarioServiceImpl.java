package org.eclipse.jakarta.service;

import org.eclipse.jakarta.dao.UsuariDao;
import org.eclipse.jakarta.dao.UsuariDaoImpl;
import org.eclipse.jakarta.model.Usuari;

public class UsuarioServiceImpl implements UsuarioService{

    private UsuariDao usuariDao;

    public UsuarioServiceImpl(){
        this.usuariDao = new UsuariDaoImpl();
    }

    @Override
    public Usuari findUserByUsernamePasswordEscola(String user, String pass, Long escola) {
        return this.usuariDao.findByUsernamePasswordEscola(user,pass,escola);
    }
}
