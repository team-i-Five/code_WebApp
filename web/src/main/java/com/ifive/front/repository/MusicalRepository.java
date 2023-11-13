package com.ifive.front.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ifive.front.entity.Musical;

public interface MusicalRepository extends JpaRepository<Musical, Long> {
}
