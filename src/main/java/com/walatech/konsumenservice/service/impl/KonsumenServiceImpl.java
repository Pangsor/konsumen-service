package com.walatech.konsumenservice.service.impl;

import com.walatech.konsumenservice.dto.KonsumenDto;
import com.walatech.konsumenservice.entity.Konsumen;
import com.walatech.konsumenservice.exception.BadRequestConsumerException;
import com.walatech.konsumenservice.exception.DuplicateConsumerException;
import com.walatech.konsumenservice.exception.ResourceNotFoundException;
import com.walatech.konsumenservice.repository.KonsumenRepository;
import com.walatech.konsumenservice.service.KonsumenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Konsumen konsumen = konsumenRepository.findById(konsumenId).orElseThrow(
                () -> new ResourceNotFoundException("Konsumen","id",konsumenId)
        );
        return modelMapper.map(konsumen,KonsumenDto.class);
    }

    @Override
    public List<KonsumenDto> getAllKonsumens() {
        List<Konsumen> konsumenList = konsumenRepository.findAll();
        return konsumenList.stream().map((konsumen) -> modelMapper.map(konsumen,KonsumenDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public KonsumenDto updateKonsumen(KonsumenDto konsumenDto) {
        Konsumen existingKonsumen = konsumenRepository.findById(konsumenDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Konsumen","id",konsumenDto.getId())
        );
        if(!konsumenDto.getStatus().equalsIgnoreCase("actif") &&
                !konsumenDto.getStatus().equalsIgnoreCase("non-actif")){
            throw new BadRequestConsumerException("BAD_REQUEST_STATUS");
        }
        existingKonsumen.setNama(konsumenDto.getNama());
        existingKonsumen.setAlamat(konsumenDto.getAlamat());
        existingKonsumen.setKota(konsumenDto.getKota());
        existingKonsumen.setProvinsi(konsumenDto.getProvinsi());
        existingKonsumen.setStatus(konsumenDto.getStatus());
        Konsumen updatedKonsumen = konsumenRepository.save(existingKonsumen);
        return modelMapper.map(updatedKonsumen,KonsumenDto.class);
    }

    @Override
    public void deleteKonsumen(int konsumenId) {

    }
}
