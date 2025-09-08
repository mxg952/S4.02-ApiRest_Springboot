package cat.itacademy.s04.t02.n01_n02.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.s04.t02.n01_n02.model.Fruita;
import cat.itacademy.s04.t02.n01_n02.repository.FruitRepository;

@Service
public class FruitaService {

    @Autowired
    private FruitRepository repository;

    public Fruita addFruit(Fruita fruita) {
        return repository.save(fruita);
    }

    public Optional<Fruita> getFruitById(int id) {
        return repository.findById(id);
    }

    public Optional<Fruita> updateFruit(int id, Fruita fruita) {
        if (repository.existsById(id)) {
            fruita.setId(id);
            return Optional.of(repository.save(fruita));
        }
        return Optional.empty();
    }

    public boolean deleteFruit(int id) {
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
