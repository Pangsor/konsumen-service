package com.walatech.konsumenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "konsumens")
public class Konsumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "kota", nullable = false)
    private String kota;

    @Column(name = "provinsi", nullable = false)
    private String provinsi;

    @CreationTimestamp
    @Column(name = "tgl_registrasi", nullable = false,updatable = false)
    private Date tgl_registrasi;

    @Column(name = "status", nullable = false)
    private String status;
}
