package com.example.demo.api;

import com.example.demo.modelo.Pokemon;
import com.example.demo.servicio.Servicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/pokemon")
@RestController
public class Controlador {
    
    private final Servicio servicio;//

    @Autowired
    public Controlador(Servicio servicio) {
        this.servicio = servicio;
    }
    
    @RequestMapping(value = "/getPokemon/{nombre}", method = RequestMethod.GET)
    public Optional<Pokemon> getPokemon(
            @PathVariable("nombre")
            String nombrePokemon) {
        return servicio.getPokemon(nombrePokemon);
    }
    
    @RequestMapping("/insertarPokemon")
    @PostMapping
    public int insertarPokemon(
            @RequestBody
            Pokemon pokemon) {
        return servicio.insertarPokemon(pokemon);
    }
    
    @RequestMapping("/actualizarPokemon")
    @PostMapping
    public int actualizarPokemon(
            @RequestBody
            Pokemon pokemon) {
        return servicio.actualizarPokemon(pokemon.getNombrePokemon(), pokemon);
    }
    
    @RequestMapping("/borrarPokemon")
    @PostMapping
    public int borrarPokemon(
            @RequestBody
            String nombrePokemon) {
        return servicio.borrarPokemon(nombrePokemon);
    }
    
    @RequestMapping(value = "/getAllPokemons", method = RequestMethod.GET)
    public List<Pokemon> getAllPokemons() {
        return servicio.getAllPokemons();
    }
}