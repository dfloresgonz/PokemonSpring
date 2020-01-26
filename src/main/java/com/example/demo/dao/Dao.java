package com.example.demo.dao;

import com.example.demo.modelo.Pokemon;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository("pokedao")
public class Dao implements IDao{
    
    private static List<Pokemon> BASE_DATOS = new ArrayList<>();
    
    @Override
    public Optional<Pokemon> getPokemon(String nombre) {
        return BASE_DATOS.stream().filter(
                poke -> poke.getNombrePokemon().equalsIgnoreCase(nombre)
        ).findFirst();
    }

    @Override
    public int insertarPokemon(Pokemon pokemon) {
        BASE_DATOS.add(pokemon);
        return 1;
    }

    @Override
    public int actualizarPokemon(String nombre, Pokemon pokemonUpdate) {
        // 0 no actualizó // 1 = sí actualizó
        return getPokemon(nombre).map(pok -> {
            int indice = BASE_DATOS.indexOf(pok);
            if(indice >= 0) {
                BASE_DATOS.set(indice, pokemonUpdate);
                return 1;//ACTUALIZA
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int borrarPokemon(String nombre) {
        Optional<Pokemon> oPokemon = getPokemon(nombre);
        if(oPokemon == null) return 0;
        BASE_DATOS.remove(oPokemon.get());
        return 1;
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}