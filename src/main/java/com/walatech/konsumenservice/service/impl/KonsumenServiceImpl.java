package com.walatech.konsumenservice.service.impl;

import com.walatech.konsumenservice.dto.KonsumenDto;
import com.walatech.konsumenservice.entity.Konsumen;
import com.walatech.konsumenservice.exception.BadRequestConsumerException;
import com.walatech.konsumenservice.exception.DuplicateConsumerException;
import com.walatech.konsumenservice.repository.KonsumenRepository;
import com.walatech.konsumenservice.service.KonsumenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KonsumenServiceImpl implements KonsumenService {

    private KonsumenRepository konsumenRepository;
    private ModelMapper modelMapper;

    @Override
    public KonsumenDto createKonsumen(KonsumenDto konsumenDto) {
        Optional<Konsumen> optionalKonsumen = konsumenRepository.findByNamaAndKotaAndProvinsi(konsumenDto.getNama(),
                                                                                            konsumenDto.getKota(),
                                                                                            konsumenDto.getProvinsi());

        if(optionalKonsumen.isPresent()){
            throw new DuplicateConsumerException("Consumer Already Exists");
        }

        if(!konsumenDto.getStatus().equalsIgnoreCase("actif")){
            throw new BadRequestConsumerException("BAD_REQUEST_STATUS");
        }
        Konsumen konsumen = modelMapper.map(konsumenDto,Konsumen.class);
        Konsumen savedKonsumen = konsumenRepository.save(konsumen);
        return modelMapper.map(savedKonsumen,KonsumenDto.class);
    }

    @Override
    public KonsumenDto getKonsumenById(int konsumenId) {
        return null;
    }

    @Override
    public List<KonsumenDto> getAllKonsumens() {
        return null;
    }

    @Override
    public KonsumenDto updateKonsumen(KonsumenDto konsumenDto) {
        return null;
    }

    @Override
    public void deleteKonsumen(int konsumenId) {

    }
}
