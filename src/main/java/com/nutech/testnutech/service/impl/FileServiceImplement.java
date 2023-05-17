package com.nutech.testnutech.service.impl;

import com.nutech.testnutech.model.*;
import com.nutech.testnutech.repository.*;
import com.nutech.testnutech.service.*;
import org.springframework.stereotype.*;

import javax.servlet.*;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 * IntelliJ IDEA 2021.1
 *
 * @author denisentanas at 08:32. 17 May 2023
 */
@Service
public class FileServiceImplement implements FileService {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    final ServletContext context;
    final FileRepository repository;

    public FileServiceImplement(ServletContext context, FileRepository repository) {
        this.context = context;
        this.repository = repository;
    }

    @Override
    public List<FileModel> getFromDatabase() {
        return repository.findAll();
    }

    @Override
    public FileModel saveToDataBase(FileModel object) {
        return repository.save(object);
    }

    @Override
    public FileModel saveToFile(FileModel object) throws IOException {
        String stringContent = object.getNik() + "," + object.getName() + "," + object.getBirthDay();
        addFile("profile.txt", stringContent, true);
        return null;
    }

    @Override
    public ArrayList<String> getFile() {
        try {
            File file = new File("profile.txt");
            Scanner reader = new Scanner(file);
            String data = null;
            ArrayList<String> output = new ArrayList<>();
            while (reader.hasNextLine()) {
                data = reader.nextLine();
                String[] arr = data.split(",");
                for (int i = 0; i < arr.length; i++) {
                    if(i==1){
                        output.add(arr[i]);
                    }
                }
            }
            System.out.println("data berhasil dibaca.");
            reader.close();
            return output;
        } catch (FileNotFoundException e) {
            System.out.println("file tidak ditemukan");
            e.printStackTrace();
        }
        return null;
    }

    void addFile(String fileName, String content, boolean append) throws IOException {
        /* 1. Buat File*/
        File file = new File("profile.txt");

        /* 2. buat sebuat class file writer */
        FileWriter fileWriter = new FileWriter(file, append);

        /* 3. buat sebuah class print writer */
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(content);
        printWriter.close();
    }
}
