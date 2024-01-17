package org.eclipse.jakarta.dao;

import org.eclipse.jakarta.controller.LoginController;
import org.eclipse.jakarta.model.Escola;

import java.util.List;

public interface EscolaDao {
    List<Escola> findAll();
    Escola getById(Long id);
}
