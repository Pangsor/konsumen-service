package com.walatech.konsumenservice.service;

import com.walatech.konsumenservice.dto.KonsumenDto;

import java.util.List;

public interface KonsumenService {

    KonsumenDto createKonsumen(KonsumenDto konsumenDto);
    KonsumenDto getKonsumenById(int konsumenId);
    List<KonsumenDto> getAllKonsumens();
    KonsumenDto updateKonsumen(KonsumenDto konsumenDto);
    void deleteKonsumen(int konsumenId);
}
