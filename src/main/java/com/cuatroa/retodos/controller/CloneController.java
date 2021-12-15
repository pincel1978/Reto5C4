package com.cuatroa.retodos.controller;

import com.cuatroa.retodos.model.Clone;
import com.cuatroa.retodos.service.CloneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin("*")
public class CloneController {

    @Autowired
    private CloneService cloneService;

    @GetMapping("/all")
    public List<Clone> getAll() {
        return cloneService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clone> getClone(@PathVariable("id") int id) {
        return cloneService.getClone(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone create(@RequestBody Clone clone) {
        return cloneService.create(clone);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return cloneService.update(clone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cloneService.delete(id);
    }
    
    //Reto 5
    @GetMapping("/price/{price}")
    public List<Clone> clonesByPrice(@PathVariable("price") double precio) {
        return cloneService.clonesByPrice(precio);
    }
    
    //Reto 5
    @GetMapping("/description/{description}")
    public List<Clone> findByDescriptionLike(@PathVariable("description") String description) {
        return cloneService.findByDescriptionLike(description);
    }
}
