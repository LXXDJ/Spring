package com.ohgiraffers.section02.annotation.subsection01;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    private Pokemon pokemon;

    public PokemonService(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void pokemonAttack(){
        pokemon.attack();
    }
}