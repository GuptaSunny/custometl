package com.example.extractor;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@AllArgsConstructor
@Service
public class SqlExtractor implements DataExtractor {
    private DataSource connection;

    public List<Object> extractData() {
        throw new UnsupportedOperationException();
    }


}
