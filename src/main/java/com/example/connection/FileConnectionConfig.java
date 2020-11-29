package com.example.connection;

import com.example.extractor.DataExtractor;
import com.example.extractor.FileExtractor;
import com.example.loader.DataLoader;
import com.example.loader.FileDataLoader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FileConnectionConfig implements ConnectionConfig {
    String filepath;

    private InputStream getInputStream() {
        try {
            File file = new File(filepath);
            return new FileInputStream(file);
        } catch (FileNotFoundException f) {
            log.error("File Not found");
        }
        return null;
    }

    public DataExtractor getExtractor() {
        return new FileExtractor(getInputStream());
    }

    public DataLoader getLoader() {
        return new FileDataLoader(getInputStream());
    }
}
