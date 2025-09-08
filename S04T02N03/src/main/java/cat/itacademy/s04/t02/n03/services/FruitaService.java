package cat.itacademy.s04.t02.n03.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.s04.t02.n03.model.Fruita;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;

@Service
public class FruitaService {

    @Autowired
    private FruitRepository repository;

    public Fruita addFruit(Fruita fruita) {
        return repository.save(fruita);
    }

    public Optional<Fruita> getFruitById(String id) {
        return repository.findById(id);
    }

 public Optional<Fruita> updateFruit(String id, Fruita fruitaDetails) {
    return repository.findById(id).map(existingFruit -> {
        existingFruit.setName(fruitaDetails.getName());
        existingFruit.setQuantityKg(fruitaDetails.getQuantityKg());
        return repository.save(existingFruit);
    });
}

    public boolean deleteFruit(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public java.util.List<Fruita> getAllFruits() {
        return repository.findAll();
    }
}
