package com.walatech.konsumenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KonsumenDto {

    private int id;

    @NotEmpty(message = "Nama should not be null or empty")
    private String nama;

    @NotEmpty(message = "Address should not be null or empty")
    private String alamat;

    @NotEmpty(message = "City should not be null or empty")
    private String kota;

    @NotEmpty(message = "Province should not be null or empty")
    private String provinsi;

    private Date tgl_registrasi;

    @NotEmpty(message = "Status should not be null or empty")
    private String status;
}
