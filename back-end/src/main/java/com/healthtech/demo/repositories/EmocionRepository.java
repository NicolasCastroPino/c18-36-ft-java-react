package com.healthtech.demo.repositories;

import com.healthtech.demo.entities.Emocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmocionRepository extends JpaRepository <Emocion, Long> {
}
