package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Clone;
import com.cuatroa.retodos.repository.CloneRepository;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class CloneService {

    @Autowired
    private CloneRepository laptopRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Clone> getAll() {
        return laptopRepository.getAll();
    }

    public Optional<Clone> getClone(int id) {
        return laptopRepository.getClone(id);
    }

    public Clone create(Clone laptop) {
        if (laptop.getId() == null) {
            return laptop;
        } else {
            return laptopRepository.create(laptop);
        }
    }

    public Clone update(Clone laptop) {

        if (laptop.getId() != null) {
            Optional<Clone> laptopDb = laptopRepository.getClone(laptop.getId());
            if (!laptopDb.isEmpty()) {
                if (laptop.getBrand() != null) {
                    laptopDb.get().setBrand(laptop.getBrand());
                }
                if (laptop.getProcesor() != null) {
                    laptopDb.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    laptopDb.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    laptopDb.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    laptopDb.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    laptopDb.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getQuantity() != 0) {
                    laptopDb.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPrice() != 0.0) {
                    laptopDb.get().setPrice(laptop.getPrice());
                }
                if (laptop.getPhotography() != null) {
                    laptopDb.get().setPhotography(laptop.getPhotography());
                }
                laptopDb.get().setAvailability(laptop.isAvailability());
                laptopRepository.update(laptopDb.get());
                return laptopDb.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(int gatgetId) {
        Boolean aBoolean = getClone(gatgetId).map(product -> {
            laptopRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     //Reto 5
    public List<Clone> clonesByPrice(double price) {
        return laptopRepository.clonesByPrice(price);
    }

    //Reto 5
    public List<Clone> findByDescriptionLike(String description) {
        return laptopRepository.findByDescriptionLike(description);
    }
}
