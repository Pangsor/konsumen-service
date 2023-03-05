package com.walatech.konsumenservice.controller;

import com.walatech.konsumenservice.dto.KonsumenDto;
import com.walatech.konsumenservice.service.KonsumenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/konsumens")
public class KonsumenController {

    private KonsumenService konsumenService;

    @PostMapping
    public ResponseEntity<KonsumenDto> createKonsumen(@Valid @RequestBody KonsumenDto konsumenDto){
        KonsumenDto savedKonsumen = konsumenService.createKonsumen(konsumenDto);
        return new ResponseEntity<>(savedKonsumen, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<KonsumenDto> getKonsumenById(@PathVariable("id") int konsumenId){
        KonsumenDto konsumen = konsumenService.getKonsumenById(konsumenId);
        return new ResponseEntity<>(konsumen, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<KonsumenDto>> getAllKondumens(){
        List<KonsumenDto> konsumenList = konsumenService.getAllKonsumens();
        return new ResponseEntity<>(konsumenList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<KonsumenDto> updateKonsumen(@PathVariable("id") int konsumenId,
                                                    @Valid @RequestBody KonsumenDto konsumenDto){
        konsumenDto.setId(konsumenId);
        KonsumenDto updatedKonsumen = konsumenService.updateKonsumen(konsumenDto);
        return new ResponseEntity<>(updatedKonsumen, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteKonsumen(@PathVariable("id") int konsumenId){
        konsumenService.deleteKonsumen(konsumenId);
        return new ResponseEntity<>("Konsumen successfully deleted",HttpStatus.OK);
    }
}
