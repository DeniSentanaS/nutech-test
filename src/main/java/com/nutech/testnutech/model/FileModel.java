package com.nutech.testnutech.model;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

/**
 * IntelliJ IDEA 2021.1
 *
 * @author denisentanas at 08:31. 17 May 2023
 */
@Data
@Entity(name = "FileEntity")
@NoArgsConstructor
@AllArgsConstructor
public class FileModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nik;
    private String nama;
    private Date tanggalLahir;
}
