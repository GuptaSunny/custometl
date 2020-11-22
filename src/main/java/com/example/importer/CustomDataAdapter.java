package com.example.importer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class CustomDataAdapter implements DataAdapter {

    private DataAdapterConfig dataAdapterConfig;

    @Override
    public List<Object> extract() {
        return dataAdapterConfig.getSourceConfig().getExtractor().extractData();
    }

    @Override
    public List<Object> transform(List<Object> object) {
        return object;
    }

    @Override
    public void load(List<Object> object) {
        dataAdapterConfig.getTargetConfig().getLoader().loadData(object);
    }
}
