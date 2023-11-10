package com.ifive.front.service.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifive.front.entity.Musical;
import com.ifive.front.service.MusicalService;

@Service
public class MusicalServiceImpl implements MusicalService {
    private final Logger log = LoggerFactory.getLogger(MusicalServiceImpl.class);


    // objectMapper를 통해, jsonStr을 List<Musical>에 매핑합니다. 이후 List 반환
    @Override
    public List<Musical> getMusicalsFromJsonString(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Musical> musicals = objectMapper.readValue(jsonString, new TypeReference<List<Musical>>() {});
            //log.info("ObjectMapper로 매핑한 musicals[0] : {}", musicals.get(0));
            return musicals;

        } catch (Exception e) {
            e.printStackTrace();
            List<Musical> nullList = new ArrayList<>();
            return nullList;
        }
    }

    @Override
    public List<Musical> getMusicalsFromJsonFile(String classpathResource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassPathResource resource = new ClassPathResource(classpathResource);
            List<Musical> musicals = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Musical>>() {});
            //log.info("ObjectMapper로 매핑한 musicals[0] : {}", musicals.get(0));
            return musicals;
        } catch (IOException e) {
            e.printStackTrace();
            List<Musical> nullList = new ArrayList<>();
            return nullList;
        }
    }
}
