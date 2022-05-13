package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonController {

    private List<Pokemon> pokemons;
    public PokemonController() {
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Charmander", "Fire"));
        pokemons.add(new Pokemon("Vulpix", "Fire"));
        pokemons.add(new Pokemon("Squirtle", "Water"));
        pokemons.add(new Pokemon("Bayleef", "Grass"));
        pokemons.add(new Pokemon("Diglett","Ground"));
    }

    @GetMapping("/pokemons")
    List<Pokemon> getAll() {
        return pokemons;
    }

    @PostMapping("/pokemons")
    Pokemon post(@RequestBody Pokemon pokemon){
        pokemons.add(pokemon);
        return pokemons.get(pokemons.size()-1);
    }
    @DeleteMapping("/pokemons/{id}")
    void delete(@PathVariable int id){
        pokemons.remove(id);
    }

}
