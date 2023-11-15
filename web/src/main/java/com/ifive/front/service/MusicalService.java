package com.ifive.front.service;

import java.util.List;

import com.ifive.front.dto.MusicalDTO;
import com.ifive.front.entity.Musical;

public interface MusicalService {
    // JSON데이터를 가지고 Musical 객체에 파싱하고, 리스트로 만들어 반환합니다.
    List<Musical> getMusicalsFromJsonString(String jsonString);

    // JSON파일을 가지고 Musical 객체에 파싱하고, 리스트 만들어 반환, JSON파일은 resources/static에 위치해야함
    List<Musical> getMusicalsFromJsonFile(String jsonPath);

    // Musical List의 정보가 담긴 Json파일을 읽어와서 DB에 저장하는 메소드
    void saveMusicalFromJson(String jsonPath) throws Exception;

    // DB에서 모든 뮤지컬 가져와서 DTO로 변환해서 반환
    List<MusicalDTO> getAllMusicals();


    // // jsonResponse(rank, musicalId)를 MusicalWithRankDTO에 매핑하는 메소드, 내부에서 getMusicalFromDB를 호출함.
    // List<MusicalIdWithRankDTO> getMusicalIdWithRankListDTOFromJson(String jsonResponse);

    // // musicalId를 받아왔을때, 이걸로 DB를조회해서 매핑하는 처리
    // Musical getMusicalFromDB(String musicalId);

    // // jsonResponce를 이용해서 int rank, Musical Musical로 구성된 맵을 생성해서 반환
    // Map<Integer, Musical> getMusicalRankMapFromJson(String jsonResponse);
}
