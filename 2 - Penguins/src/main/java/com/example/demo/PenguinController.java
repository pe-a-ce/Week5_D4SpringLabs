package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class PenguinController {

    private List<Penguin> penguinList;

    public PenguinController() {
        penguinList = new ArrayList<>();
        penguinList.add(new Penguin("Pingu", "Emperor"));
        penguinList.add(new Penguin("Skipper", "Little"));
        penguinList.add(new Penguin("Caruso", "King"));
        penguinList.add(new Penguin("Wheezy", "Macaroni"));
    }

    @GetMapping("/penguins")
    List<Penguin> getAll(){return penguinList;}

    @PostMapping("/penguins")
    Penguin post(@RequestBody Penguin penguin){
        penguinList.add(penguin);
        return penguinList.get(penguinList.size()-1);
    }

    @DeleteMapping("/penguins/{id}")
    void delete(@PathVariable int id){penguinList.remove(id);}
}
