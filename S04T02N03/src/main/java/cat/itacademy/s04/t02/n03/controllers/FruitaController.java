package cat.itacademy.s04.t02.n03.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import cat.itacademy.s04.t02.n03.model.Fruita;
import cat.itacademy.s04.t02.n03.services.FruitaService;

import java.util.List;

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

    @Autowired
    private FruitRepository fruitRepository;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruit (@RequestBody Fruita fruit) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fruitaService.addFruit(fruit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruitDetails, @PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fruitaService.update(id, fruitDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruita> deleteFruit(@PathVariable int id) {
        fruitaService.deleteFruit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById (@PathVariable int id){
        Fruita fruita = fruitaService.getById(id);
        return ResponseEntity.ok(fruita);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruits (){
        return ResponseEntity.ok(fruitaService.getAll());
    }
}
