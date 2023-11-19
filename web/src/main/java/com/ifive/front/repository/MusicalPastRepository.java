package com.ifive.front.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifive.front.entity.MusicalPast;

public interface MusicalPastRepository extends JpaRepository<MusicalPast, Integer>{
    // Pageable 객체를 통해 SQL문 LIMIT 와 같이 가져올 쿼리 데이터 개수를 정함.
    // Service에서 해당 개수를 정함.
    List<MusicalPast> findAllByOrderByEndDateDesc(Pageable pageable);

}
