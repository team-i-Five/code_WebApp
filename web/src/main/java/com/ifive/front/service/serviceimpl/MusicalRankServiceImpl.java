package com.ifive.front.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifive.front.dto.MusicalRankDTO;
import com.ifive.front.entity.MusicalRank;
import com.ifive.front.repository.MusicalRankRepository;
import com.ifive.front.service.MusicalRankService;

public class MusicalRankServiceImpl implements MusicalRankService {
    
    private MusicalRankRepository musicalRankRepository;

    @Autowired
    public MusicalRankServiceImpl(MusicalRankRepository musicalRankRepository){
        this.musicalRankRepository = musicalRankRepository;
    }

    // 각 사이트 별 랭크 조회
    @Override
    public List<MusicalRankDTO> getMusicalRankListBySiteName(String siteName){
        List<MusicalRank> mrList = musicalRankRepository.queryBySiteName(siteName);
        
        return mrList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


//-------- ServiceImpl 내에서만 활용되는 함수들 -----------------------

    // 뮤지컬랭크 : Entity -> DTO 변환
    private MusicalRankDTO convertToDTO(MusicalRank musicalRank){
        MusicalRankDTO dto = new MusicalRankDTO();
        dto.setDate(musicalRank.getDate());
        dto.setGoodsUrl(musicalRank.getGoodsUrl());
        dto.setSiteName(musicalRank.getSiteName());
        dto.setLocation(musicalRank.getLocation());
        dto.setPosterUrl(musicalRank.getPosterUrl());
        dto.setRanking(musicalRank.getRanking());
        dto.setTitle(musicalRank.getTitle());

        return dto;
    }
}
