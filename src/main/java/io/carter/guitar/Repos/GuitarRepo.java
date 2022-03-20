package io.carter.guitar.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.carter.guitar.Guitar;

public interface GuitarRepo extends JpaRepository<Guitar, Integer> {

}
