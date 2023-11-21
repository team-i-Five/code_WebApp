package com.ifive.front.service.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ifive.front.dto.MusicalPresentDTO;
import com.ifive.front.entity.MusicalPresent;
import com.ifive.front.repository.MusicalPresentRepository;
import com.ifive.front.service.MusicalPresentService;

@Service
public class MusicalPresentServiceImpl implements MusicalPresentService {

    private MusicalPresentRepository musicalPresentRepository;

    @Autowired
    public MusicalPresentServiceImpl(MusicalPresentRepository musicalPresentRepository) {
        this.musicalPresentRepository = musicalPresentRepository;
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

    public List<Integer> getIDsFromJsonResponse(String jsonResponse) {
        return ;
    }

    public List<MusicalPresentDTO> getPresentDTOsbyIdFromML(String id) {
        try {
            String apiUrl = "http://13.124.169.226:8080/recommend/" + id;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 요청 메소드 설정
            connection.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 응답 데이터 읽기
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // 응답 데이터 출력
                System.out.println(response.toString());
            } else {
                System.out.println("API 호출 실패. 응답 코드: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }
}
