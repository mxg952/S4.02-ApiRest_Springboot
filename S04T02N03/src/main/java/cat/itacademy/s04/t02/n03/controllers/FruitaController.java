package cat.itacademy.s04.t02.n03.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n03.model.Fruita;
import cat.itacademy.s04.t02.n03.services.FruitaService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/fruita")

public class FruitaController {

     @Autowired
    private FruitaService fruitaService;

     @PostMapping("/add")
    public Fruita addFruit (@RequestBody Fruita fruit){
        return fruitaService.addFruit(fruit);
    }
    
    @PutMapping("/update")
    public Optional<Fruita> updateFruita(@RequestBody Fruita fruitaDetails) {
    return fruitaService.updateFruit(fruitaDetails.getId(), fruitaDetails);
  }

    @DeleteMapping("/delete/{id}")
    public void deleteFruit(@PathVariable String id) {
   if (!fruitaService.deleteFruit(id)) {
        throw new FruitNotFoundException("Fruita amb ID " + id + " no trobada");
    }
    }

    @GetMapping("/getOne/{id}")
    public Optional<Fruita> getFruitById (@PathVariable String id){
        return fruitaService.getFruitById(id);
    }

    @GetMapping("/getAll")
    public Iterable<Fruita> getAllFruits (){
        return fruitaService.getAllFruits();
    }
    
    
}
