package com.nutech.testnutech.controller;

import com.nutech.testnutech.model.*;
import com.nutech.testnutech.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

/**
 * IntelliJ IDEA 2021.1
 *
 * @author denisentanas at 08:31. 17 May 2023
 */
@RestController
@RequestMapping(path = "/file")
public class FileController {
    final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(path = "/from-db")
    public ResponseEntity<List<FileModel>> get(){
        return ResponseEntity.ok(fileService.getFromDatabase());
    }

    @PostMapping(path = "/to-db")
    public ResponseEntity create(@RequestBody FileModel model){
        fileService.saveToDataBase(model);
        return ResponseEntity.ok("succes");
    }

    @GetMapping(path = "/from-file")
    public ResponseEntity<ArrayList<String>> getFile (){
        return ResponseEntity.ok(fileService.getFile());
    }

    @PostMapping(path = "/to-file")
    public ResponseEntity<?> createToFile(@RequestBody FileModel model) throws IOException {
        fileService.saveToFile(model);
        return ResponseEntity.ok("String has been created");
    }

}
