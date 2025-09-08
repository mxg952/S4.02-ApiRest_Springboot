package cat.itacademy.s04.t02.n01_n02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.s04.t02.n01_n02.model.Fruita;

@Repository
public interface FruitRepository extends JpaRepository<Fruita, Integer>  {
    
}
