package com.example.connection;


import com.example.extractor.DataExtractor;
import com.example.loader.DataLoader;

public interface ConnectionConfig {
    DataExtractor getExtractor();
    DataLoader getLoader();
}
