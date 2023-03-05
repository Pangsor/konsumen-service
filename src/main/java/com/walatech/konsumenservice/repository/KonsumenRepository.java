package com.walatech.konsumenservice.repository;

import com.walatech.konsumenservice.entity.Konsumen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KonsumenRepository extends JpaRepository<Konsumen,Integer> {

    Optional<Konsumen> findByNamaAndKotaAndProvinsi(String nama, String kota, String provinsi);
}
