package io.carter.guitar.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.carter.guitar.Pickups;

public interface PickupsRepo extends JpaRepository<Pickups, Integer> {

}
