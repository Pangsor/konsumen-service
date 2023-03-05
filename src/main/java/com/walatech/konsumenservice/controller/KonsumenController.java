package com.walatech.konsumenservice.controller;

import com.walatech.konsumenservice.dto.KonsumenDto;
import com.walatech.konsumenservice.service.KonsumenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/konsumens")
public class KonsumenController {

    private KonsumenService konsumenService;

    @PostMapping
    public ResponseEntity<KonsumenDto> createKonsumen(@Valid @RequestBody KonsumenDto konsumenDto){
        KonsumenDto savedMovie = konsumenService.createKonsumen(konsumenDto);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
}
