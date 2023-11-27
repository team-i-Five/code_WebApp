package com.ifive.front.Rank;

import java.util.List;

public interface MusicalRankService {
    // 오늘 날짜 기준으로 일간 뮤지컬 랭킹 리스트 가져오기
    List<MusicalRankDTO> getMusicalRankListByUpdateDateSiteName(String updateDate, String siteName);

    // 각 사이트별 일간 뮤지컬 랭킹 리스트 가져오기
    // List<MusicalRankDTO> getMusicalRankListBySiteName(String siteName);

} 