package com.example.demo.dao;

import com.example.demo.modelo.Pokemon;
import java.util.List;
import java.util.Optional;

public interface IDao {
    
    int insertarPokemon(Pokemon pokemon);
    Optional<Pokemon> getPokemon(String nombre);
    int actualizarPokemon(String nombre, Pokemon pokemon);
    int borrarPokemon(String nombre);
    List<Pokemon> getAllPokemons();
}