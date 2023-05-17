package com.nutech.testnutech.service;

import com.nutech.testnutech.model.*;

import java.io.*;
import java.util.*;

/**
 * IntelliJ IDEA 2021.1
 *
 * @author denisentanas at 08:31. 17 May 2023
 */
public interface FileService {
    List<FileModel> getFromDatabase();
    FileModel saveToDataBase(FileModel object);

    FileModel saveToFile(FileModel object) throws IOException;

    ArrayList<String> getFile();
}
