package cat.itacademy.s04.t02.n03.services;

import java.util.List;

import cat.itacademy.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n03.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.s04.t02.n03.model.Fruita;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FruitaService {

    @Autowired
    private FruitRepository repository;

    public FruitaService(FruitRepository repository) {
        this.repository = repository;
    }

    public Fruita addFruit(Fruita fruit) {
        if(fruit.getName() == null || fruit.getName().trim().isEmpty()) {
            throw new InvalidDataException("INVALID_NAME","El nom no pot estar buit...");
        }
        if(fruit.getQuantityKg() <= 0) {
            throw new InvalidDataException("INVALID_KG", "La quantitat no pot ser menor a zero...");
        }
        return repository.save(fruit);
    }

    @Transactional(readOnly = true)
    public Fruita getById(int id) {
        return repository.findById(String.valueOf(id))
                .orElseThrow(() -> new FruitNotFoundException("FRUIT_NOT_FOUND", "No existe una fruta con id " + id));
    }

    @Transactional(readOnly = true)
    public List<Fruita> getAll() {

        if(repository.findAll().isEmpty()) {
            throw new FruitNotFoundException("FRUIT_NOT_FOUND", "No hay ninguna fruta");
        }
        return repository.findAll();
    }

    public Fruita update(int id, Fruita f) {
        Fruita existing = getById(id);
        existing.setName(f.getName());
        existing.setQuantityKg(f.getQuantityKg());
        return repository.save(existing);
    }

    public void deleteFruit(int id) {
        if (!repository.existsById(String.valueOf(id))) {
            throw new FruitNotFoundException("FRUIT_NOT_FOUND", "No existe una fruta con id " + id);
        }
        repository.deleteById(String.valueOf(id));
    }
}
