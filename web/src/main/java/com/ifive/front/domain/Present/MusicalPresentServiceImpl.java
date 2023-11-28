package com.ifive.front.domain.Present;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MusicalPresentServiceImpl implements MusicalPresentService {

    // 사용하려면 application-aws에 ml_url={ml url} 추가
    @Value("${ml_url}"+"/recommend/present/")
    private String mlUrl;

    private final RestTemplate restTemplate;

    private MusicalPresentRepository musicalPresentRepository;

    @Autowired
    public MusicalPresentServiceImpl(MusicalPresentRepository musicalPresentRepository, RestTemplate restTemplate) {
        this.musicalPresentRepository = musicalPresentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<MusicalPresentDTO> getMusicalPresentListOrderByEndDate() {
        // Pageable을 통해 0부터 50까지의 쿼리 데이터만 가져옴.
        Pageable pageable = PageRequest.of(0, 50);

        List<MusicalPresent> mpl = musicalPresentRepository.findAllByOrderByEndDateDesc(pageable);
        // log.info("mpl 보여줘 : "+mpl);
        List<MusicalPresentDTO> mplDto = new ArrayList<>();

        for (MusicalPresent mp : mpl) {
            mplDto.add(mp.toDTO());
        }

        return mplDto;
    }

    @Override
    public List<Integer> getIDsFromJsonResponse(String jsonResponse) {
        // 이전 출력값과 다름;;
        // 함수 다시 짜야할 듯
        List<Integer> musicalIds = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray resultArray = jsonObject.getJSONArray("result");
        log.info("결과 어레이 : "+resultArray);

        for (int i = 0; i < resultArray.length(); i++) {
            JSONObject musicalObject = resultArray.getJSONObject(i);
            int musicalId = musicalObject.getInt("musical_id");
            musicalIds.add(musicalId);
        }

        return musicalIds;
    }

    @Override
    public List<MusicalPresentDTO> getMusicalsByIds(List<Integer> musicalIds) {
        List<MusicalPresent> mpl = musicalPresentRepository.findByMusicalIdIn(musicalIds);
        List<MusicalPresentDTO> mplDto = new ArrayList<>();
        
        for(MusicalPresent mp : mpl){
            log.info("****************add mp : {}",mp.toDTO());
            mplDto.add(mp.toDTO());
            log.info("****************added mplDto : {}",mplDto.toString());
        }
        
        
        return mplDto;
    }

    @Override
    public List<MusicalPresentDTO> getPresentDTOsbyIdFromML(String id) {
        // application-aws.properties
        String apiUrl = mlUrl + id;
        // ml에서 받은 json string 파싱할 곳
        List<Integer> ids;

        // GET 요청 보내고 JSON 응답 받기
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        log.info("제이슨 : "+jsonResponse);

        // JSON String 파싱해서 id리스트로 가져옴
        ids =  getIDsFromJsonResponse(jsonResponse);

        log.info("아이디스 : "+ids);

        return getMusicalsByIds(ids);
    }
}
