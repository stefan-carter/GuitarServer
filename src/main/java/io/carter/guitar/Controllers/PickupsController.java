package io.carter.guitar.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.carter.guitar.Guitar;
import io.carter.guitar.Pickups;
import io.carter.guitar.Repos.GuitarRepo;
import io.carter.guitar.Repos.PickupsRepo;

@RestController
public class PickupsController {
    private GuitarRepo guitarRepo;
    private PickupsRepo pickupsRepo;

    public PickupsController(GuitarRepo guitarRepo, PickupsRepo pickupsRepo) {
        this.guitarRepo = guitarRepo;
        this.pickupsRepo = pickupsRepo;
    }

    @PostMapping("/guitars/{guitar_id}/pickups")
    public Guitar createPickups(@RequestBody Pickups pickupData, @PathVariable Integer guitar_id) {
        Guitar guitar = guitarRepo.findById(guitar_id).get();
        pickupData.setGuitar(guitar);
        pickupsRepo.save(pickupData);
        return guitar;
    }
}
