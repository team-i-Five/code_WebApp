package com.ifive.front.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifive.front.entity.MusicalPast;

public interface MusicalPastRepository extends JpaRepository<MusicalPast, Integer>{
    // @Query("SELECT "
    //     + "mp.musicalId ,mp.title ,mp.posterUrl ,mp.genre ,mp.startDate "
    //     + ",mp.endDate ,mp.location ,mp.tag1 ,mp.tag2 ,mp.tag3 " 
    //     + "FROM MusicalPast mp "
    //     + "ORDER BY mp.endDate DESC "
    //     + "LIMIT 10")
    // List<MusicalPast> queryOrderByEndDate();

    // @Query("SELECT "
    //     + "mp.musicalId ,mp.title ,mp.genre ,mp.posterUrl ,mp.location ,mp.tag1 ,mp.tag2 ,mp.tag3 "
    //     + "FROM MusicalPast mp "
    //     + "ORDER BY mp.endDate DESC ")
    // List<MusicalPast> queryAllOrderByEndDate();

    @Override
    List<MusicalPast> findAll();

}
