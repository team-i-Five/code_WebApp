package com.ifive.front.service;

import java.util.List;

import com.ifive.front.dto.MusicalPastDTO;

public interface MusicalPastService {
    
    // 과거의 뮤지컬 중 
    List<MusicalPastDTO> getMusicalPastListOrderByEndDate();
}
