package com.ifive.front.Rank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicalRankServiceImpl implements MusicalRankService {
    
    private MusicalRankRepository musicalRankRepository;

    @Autowired
    public MusicalRankServiceImpl(MusicalRankRepository musicalRankRepository){
        this.musicalRankRepository = musicalRankRepository;
    }

    @Override
    public List<MusicalRankDTO> getMusicalRankListByUpdateDateSiteName(String updateDate, String siteName){
        List<MusicalRank> mrList = musicalRankRepository.queryByUpdateDateSiteName(updateDate, siteName);
        List<MusicalRankDTO> mrd = new ArrayList<>();
        
        for(MusicalRank mr : mrList){
            mrd.add(mr.toDTO());
        }

        return mrd;        
        // return mrList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // 각 사이트 별 랭크 조회
    // @Override
    // public List<MusicalRankDTO> getMusicalRankListBySiteName(String siteName){
    //     List<MusicalRank> mrList = musicalRankRepository.queryBySiteName(siteName);
        
    //     return mrList.stream().map(this::convertToDTO).collect(Collectors.toList());
    // }


//-------- ServiceImpl 내에서만 활용되는 함수들 -----------------------

    // 뮤지컬랭크 : Entity -> DTO 변환
    // private MusicalRankDTO convertToDTO(MusicalRank musicalRank){
    //     MusicalRankDTO dto = new MusicalRankDTO();
    //     dto.setDate(musicalRank.getDate());
    //     dto.setGoodsUrl(musicalRank.getGoodsUrl());
    //     dto.setSiteName(musicalRank.getSiteName());
    //     dto.setLocation(musicalRank.getLocation());
    //     dto.setPosterUrl(musicalRank.getPosterUrl());
    //     dto.setRanking(musicalRank.getRanking());
    //     dto.setTitle(musicalRank.getTitle());
    //     dto.setUpdateDate(musicalRank.getUpdateDate());

    //     return dto;
    // }
}
