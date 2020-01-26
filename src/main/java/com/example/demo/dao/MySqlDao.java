package com.example.demo.dao;

import com.example.demo.modelo.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("pokemysqldao")
public class MySqlDao implements IDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int insertarPokemon(Pokemon pokemon) {
        String sql = "INSERT INTO pokedex VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                pokemon.getNombrePokemon(),
                pokemon.getTipoPokemon(),
                pokemon.getAtaque(),
                pokemon.getDefensa()
        );
    }

    @Override
    public Optional<Pokemon> getPokemon(String nombre) {
        return jdbcTemplate.queryForObject("SELECT * FROM pokedex WHERE nombre = ?",
                new Object[]{nombre},
                (rs, rowNum) -> 
                    Optional.of(
                            new Pokemon(
                            rs.getString("nombre"),
                            rs.getString("tipo"),
                            rs.getInt("ataque"),
                            rs.getInt("defensa")
                            )
                    )
                );
    }

    @Override
    public int actualizarPokemon(String nombre, Pokemon pokemon) {
        return jdbcTemplate.update("UPDATE pokedex "
                                    + "SET tipo = ?,"
                                    + "ataque   = ?,"
                                    + "defensa  = ? "
                                    + "WHERE nombre = ?",
                pokemon.getTipoPokemon(),
                pokemon.getAtaque(),
                pokemon.getDefensa(),
                pokemon.getNombrePokemon()
        );
    }

    @Override
    public int borrarPokemon(String nombre) {
        return jdbcTemplate.update("DELETE FROM pokedex WHERE nombre = ?", nombre);
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        return jdbcTemplate.query("SELECT * FROM pokedex",
                (rs, rowNum) ->
                        new Pokemon(
                                rs.getString("nombre"),
                                rs.getString("tipo"),
                                rs.getInt("ataque"),
                                rs.getInt("defensa"))
                );
    }
}