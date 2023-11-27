package com.ifive.front.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifive.front.entity.Musical;

public interface MusicalRepository extends JpaRepository<Musical, Long> {

    @Query("SELECT m FROM Musical m WHERE m.musicalId = musicalId")
    Optional<Musical> findByMusicalId(@Param("musicalId") String musicalId);

    //모든 Musical 테이블 객체가져옴
    List<Musical> findAll();
}

