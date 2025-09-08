package cat.itacademy.s04.t02.n03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.s04.t02.n03.model.Fruita;

@Repository
public interface FruitRepository extends MongoRepository<Fruita, String>  {
    
}
    