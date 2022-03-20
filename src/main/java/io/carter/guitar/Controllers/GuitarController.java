package io.carter.guitar.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.carter.guitar.Guitar;
import io.carter.guitar.Repos.GuitarRepo;

@RestController
public class GuitarController {
    private GuitarRepo repo;

    public GuitarController(GuitarRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/guitars")
    public Guitar createGuitar(@RequestBody Guitar guitarData) {
        return repo.save(guitarData);
    }

    @GetMapping("/guitars")
    public List<Guitar> getAll() {
        return repo.findAll();
    }

    @GetMapping("/guitars/{id}")
    public Guitar getOne(@PathVariable Integer id) {
        return repo.findById(id).get();
    }

    @PutMapping("/guitars/{id}")
    public Guitar updateOne(@RequestBody Guitar updateGuitar, @PathVariable Integer id) {
        return repo.findById(id).map(guitar -> {
            guitar.setName(updateGuitar.getName());
            guitar.setImage(updateGuitar.getImage());
            return repo.save(guitar);
        }).orElseThrow();
    }

    @DeleteMapping("/guitars/{id}")
    public void updateOne(@PathVariable Integer id) {
        repo.deleteById(id);
    }

}
