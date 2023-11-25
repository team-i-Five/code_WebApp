package com.ifive.front.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifive.front.entity.MusicalRank;

public interface MusicalRankRepository extends JpaRepository<MusicalRank, Integer>{
    // 오늘 날짜 기준으로 뮤지컬 랭크 데이터 조회
    @Query("SELECT mr FROM MusicalRank mr WHERE mr.updateDate = :updateDate and mr.siteName = :siteName")
    List<MusicalRank> queryByUpdateDateSiteName(String updateDate, String siteName);
    
    // 테스트 : 사이트 이름 값으로 뮤지컬 랭크 데이터 조회
    // @Query("SELECT mr FROM MusicalRank mr WHERE mr.siteName = :siteName")
    // List<MusicalRank> queryBySiteName(String siteName);

}
