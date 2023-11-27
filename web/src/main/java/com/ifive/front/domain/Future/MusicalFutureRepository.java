package com.ifive.front.domain.Future;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalFutureRepository extends JpaRepository<MusicalFuture, Integer>{

    List<MusicalFuture> findByMusicalIdIn(List<Integer> musicalIds);
}
