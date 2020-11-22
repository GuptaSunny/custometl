package com.example.importer;

import java.util.List;

public interface DataAdapter {

    List<Object> extract();

    List<Object> transform(List<Object> object);

    void load(List<Object> object);

    default void runETL() {
        load(transform(extract()));
    }
}
