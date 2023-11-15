package com.ifive.front.service;

import java.util.List;

import com.ifive.front.dto.MusicalRankDTO;

public interface MusicalRankService {
    // 오늘 날짜 기준으로 일간 뮤지컬 랭킹 리스트 가져오기
    List<MusicalRankDTO> getMusicalRankListByUpdateDateSiteName(String updateDate, String siteName);

    // 각 사이트별 일간 뮤지컬 랭킹 리스트 가져오기
    // List<MusicalRankDTO> getMusicalRankListBySiteName(String siteName);

} 