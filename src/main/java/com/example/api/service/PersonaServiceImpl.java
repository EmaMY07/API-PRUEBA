package com.example.api.service;

import com.example.api.entities.Persona;

import java.util.List;

public interface PersonaServiceImpl {
    public List<Persona> findAll();
    public Persona findById(Long id);
    public Persona save(Persona persona);
    public void delete(Long id);
}
