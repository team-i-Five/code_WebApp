package com.ifive.front.service;

import java.util.List;

import com.ifive.front.entity.Musical;

public interface MusicalService {
    // JSON데이터를 가지고 Musical 객체에 파싱하고, 리스트로 만들어 반환합니다.
    List<Musical> getMusicalsFromJsonString(String jsonString);

    // JSON파일을 가지고 Musical 객체에 파싱하고, 리스트 만들어 반환, JSON파일은 resources/static에 위치해야함
    List<Musical> getMusicalsFromJsonFile(String classpathResource);
}
