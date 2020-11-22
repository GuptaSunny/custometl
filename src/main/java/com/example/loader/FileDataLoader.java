package com.example.loader;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class FileDataLoader implements DataLoader {
    private InputStream inputStream;

    public int[] loadData(List<Object> products) {
        throw new UnsupportedOperationException();
    }
}
