package com.ifive.front.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifive.front.dto.MusicalPastDTO;
import com.ifive.front.entity.MusicalPast;
import com.ifive.front.repository.MusicalPastRepository;
import com.ifive.front.service.MusicalPastService;

@Service
public class MusicalPastServiceImpl implements MusicalPastService{
    
    private MusicalPastRepository musicalPastRepository;

    @Autowired
    public MusicalPastServiceImpl(MusicalPastRepository musicalPastRepository){
        this.musicalPastRepository = musicalPastRepository;
    }

    @Override
    public List<MusicalPastDTO> getMusicalPastListOrderByEndDate(){
        List<MusicalPast> mpl = musicalPastRepository.findAll();
        List<MusicalPastDTO> mplDto = new ArrayList<>();

        for(MusicalPast mp : mpl){
            mplDto.add(mp.toDTO());
        }

        return mplDto;
    }
}
