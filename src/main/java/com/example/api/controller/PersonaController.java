package com.example.api.controller;

import com.example.api.entities.Persona;
import com.example.api.service.PersonaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/personas")
@AllArgsConstructor
public class PersonaController {
    private final PersonaServiceImpl personaService;
    @GetMapping
    public ResponseEntity<List<Persona>>findAll(){
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona>findById(@PathVariable Long id){
        return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Persona>save(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Persona>update(@PathVariable Long id,@RequestBody Persona persona){
        persona.setId(id);
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>delete(@PathVariable Long id){
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
