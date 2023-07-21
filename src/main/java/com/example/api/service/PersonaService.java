package com.example.api.service;

import com.example.api.entities.Persona;
import com.example.api.repository.PersonaDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaService implements PersonaServiceImpl{
    private final PersonaDAO personaDAO;
    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaDAO.findById(id).orElseThrow(()-> new RuntimeException("no se encontro a la persona"));
    }

    @Override
    public Persona save(Persona persona) {
        return new Persona(personaDAO.save(persona).getId());
    }

    @Override
    public void delete(Long id) {
        personaDAO.findById(id).orElseThrow(()-> new RuntimeException("no se encontro a la persona"));
        personaDAO.deleteById(id);
    }
}
