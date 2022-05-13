package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class FlowerController {

    private List<Flower> flowerList;

    public FlowerController(){
        flowerList = new ArrayList<>();
        flowerList.add(new Flower("Petunia","Annuals","Purple"));
        flowerList.add(new Flower("Begonia","Annuals","Pink"));
        flowerList.add(new Flower("Hydrangea","Perennials","Purple"));
        flowerList.add(new Flower("Forget Me Not","Biennials","Purple"));
    }

    @GetMapping("/flowers")
    List<Flower> getAll(){return flowerList;}

    @PostMapping("/flowers")
    Flower post(@RequestBody Flower flower){
        flowerList.add(flower);
        return flowerList.get(flowerList.size()-1);
    }

    @DeleteMapping("/flowers/{id}")
    void delete(@PathVariable int id){flowerList.remove(id);}
}
