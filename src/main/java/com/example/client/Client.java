//package com.example.client;
//
//import com.example.connection.FileConnectionConfig;
//import com.example.connection.SQLConnectionConfig;
//import com.example.importer.DataAdapter;
//import com.example.importer.DataAdapterConfig;
//import com.example.importer.CustomDataAdapter;
//import com.example.transformer.DataSet;
//
//public class Client {
//
//    public static void main(String a[]) {
//        DataAdapterConfig dataAdapterConfig = new DataAdapterConfig
//                (new FileConnectionConfig("D://product.xlsx"),
//                        new SQLConnectionConfig(), DataSet.PRODUCT);
//        DataAdapter dataAdapter = new CustomDataAdapter(dataAdapterConfig);
//        dataAdapter.runETL();
//    }
//}
