package com.ifive.front.service;

import java.util.List;

import com.ifive.front.dto.MusicalPresentDTO;
import com.ifive.front.entity.MusicalPresent;

public interface MusicalPresentService {
    
    // 과거의 뮤지컬에서 end_date 최신순으로 정렬한 전체 데이터 조회
    List<MusicalPresentDTO> getMusicalPresentListOrderByEndDate();

    // ID값 파라미터로 넣어서 호출하면, ML서버에 접속해서 ID값으로 유사한 뮤지컬 5개의 ID값을 가져오고
    // 해당 ID값으로 DB를 조회해서 MusicalPresent 정보를 가져와서 DTO에 담습니다.
    List<MusicalPresentDTO> getPresentDTOsbyIdFromML(String id);

    //getPresentDTOsbyIdFromML 내부에서 동작하는 함수로 ML에서 응답한 jsonResponse에서 ID값을 가져옵니다.
    List<Integer> getIDsFromJsonResponse(String jsonResponse);

    
    // List<Integer>를 이용해서 DB에서 id값에 일치하는 것들 가져옴
    List<MusicalPresentDTO> getMusicalsByIds(List<Integer> musicalIds);

    // TEST
    // MusicalPresent 객체 반환값 확인용 하나만 가져오는 것.
    // List<MusicalPresentDTO> getMusicalById(Integer musicalId);
}
