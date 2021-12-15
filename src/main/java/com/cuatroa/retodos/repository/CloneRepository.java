package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.CloneCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class CloneRepository {

    @Autowired
    private CloneCrudRepository crudRepository;

    public List<Clone> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Clone> getClone(int productId) {
        return crudRepository.findById(productId);
    }

    public Clone create(Clone gadget) {
        return crudRepository.save(gadget);
    }

    public void update(Clone product) {
        crudRepository.save(product);
    }

    public void delete(Clone product) {
        crudRepository.delete(product);
    }

    //Reto 5
    public List<Clone> clonesByPrice(double precio) {
        return crudRepository.findByPriceLessThanEqual(precio);
    }

    //Reto 5
    public List<Clone> findByDescriptionLike(String description) {
        return crudRepository.findByDescriptionLike(description);
    }
}
