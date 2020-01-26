package com.example.demo.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    
    public String nombrePokemon;
    public String tipoPokemon;
    public int ataque;
    public int defensa;

    public Pokemon(
            @JsonProperty("nombrePokemon")
            String nombrePokemon,
            @JsonProperty("tipoPokemon")
            String tipoPokemon,
            @JsonProperty("ataque")
            int ataque,
            @JsonProperty("defensa")
            int defensa) {
        this.nombrePokemon = nombrePokemon;
        this.tipoPokemon = tipoPokemon;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    
}