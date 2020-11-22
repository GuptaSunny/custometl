package com.example.transformer;

public class DataTransformerFactory {
    public static DataTransformer getDataTransformer(DataSet type) {
        switch (type) {
            case PRODUCT:
                return new ProductDataTransformer();
            default:
                throw new IllegalArgumentException("Adapter is not implemented");
        }
    }
}
