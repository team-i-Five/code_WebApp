package com.ifive.front.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifive.front.entity.MusicalPresent;

public interface MusicalPresentRepository extends JpaRepository<MusicalPresent, Integer>{
    // Pageable 객체를 통해 SQL문 LIMIT 와 같이 가져올 쿼리 데이터 개수를 정함.
    // Service에서 해당 개수를 정함.
    List<MusicalPresent> findAllByOrderByEndDateDesc(Pageable pageable);

    @Query("SELECT mp FROM MusicalPast mp WHERE mp.tag1 = :tag1")
    List<MusicalPresent> queryByTag1(String tag1);

    @Query("SELECT mp FROM MusicalPast mp WHERE mp.tag1 = :tag1 AND mp.tag2 = :tag2")
    List<MusicalPresent> queryByTag1AndTag2(String tag1, String tag2);
    
    @Query("SELECT mp FROM MusicalPast mp WHERE mp.tag1 = :tag1 AND mp.tag2 = :tag2 AND mp.tag3 = :tag3")
    List<MusicalPresent> queryByAllTags(String tag1, String tag2, String tag3); 
}
