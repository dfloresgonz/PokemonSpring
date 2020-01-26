package com.example.demo.servicio;

import com.example.demo.dao.Dao;
import com.example.demo.dao.MySqlDao;
import com.example.demo.modelo.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    
    private final MySqlDao dao;

    @Autowired
    public Servicio(
            @Qualifier("pokemysqldao")
            MySqlDao dao) {
        this.dao = dao;
    }
    
    public Optional<Pokemon> getPokemon(String nombre) {
        return dao.getPokemon(nombre);
    }
    
    public int insertarPokemon(Pokemon pokemon) {
        return dao.insertarPokemon(pokemon);
    }
    
    public int actualizarPokemon(String nombre, Pokemon pokemonUpt) {
        return dao.actualizarPokemon(nombre, pokemonUpt);
    }
    
    public int borrarPokemon(String nombre) {
        return dao.borrarPokemon(nombre);
    }
    
    public List<Pokemon> getAllPokemons() {
        return dao.getAllPokemons();
    }
}