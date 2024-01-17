package org.eclipse.jakarta.service;

import org.eclipse.jakarta.dao.EscolaDao;
import org.eclipse.jakarta.dao.EscolaDaoImpl;
import org.eclipse.jakarta.model.Escola;

import java.util.List;

public class EscolaServiceImpl implements EscolaService{

    private EscolaDao escolaDao;

    public EscolaServiceImpl(){
        this.escolaDao = new EscolaDaoImpl();
    }

    @Override
    public List<Escola> findAll() {
        return this.escolaDao.findAll();
    }

    @Override
    public Escola getById(Long id) {
        return this.escolaDao.getById(id);
    }

    /*
    public List<Escola> findAllActiva() {
        return this.escolaDao.findAll().stream().filter();
    }

    public List<Escola> findAllP() {
        return this.escolaDao.findAll().stream().filter(e->e.getNom().contains("P")).toList();
    }

     */


}
