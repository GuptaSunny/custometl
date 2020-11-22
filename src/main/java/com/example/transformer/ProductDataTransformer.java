package com.example.transformer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDataTransformer implements DataTransformer
{
    @Override
    public void transformData() {
       log.info(" Data Transformed.......");
    }
}
