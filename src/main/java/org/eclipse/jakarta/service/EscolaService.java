package org.eclipse.jakarta.service;

import org.eclipse.jakarta.model.Escola;

import java.util.List;

public interface EscolaService {
    List<Escola> findAll();

    Escola getById(Long id);
}
