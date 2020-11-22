package com.example.importer;

import com.example.connection.FileConnectionConfig;
import com.example.connection.SQLConnectionConfig;
import com.example.transformer.DataSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomDataAdapterTest {

    @Autowired
    SQLConnectionConfig  targetConnection;
    @Autowired
    FileConnectionConfig  sourceConnection;

    @Test
    void runETLTest() {
        DataAdapterConfig dataAdapterConfig = new DataAdapterConfig();
        dataAdapterConfig.setSourceConfig(new FileConnectionConfig("D://product.xlsx"));
        dataAdapterConfig.setTargetConfig(targetConnection);
        dataAdapterConfig.setDataSet(DataSet.PRODUCT);
               DataAdapter dataAdapter = new CustomDataAdapter(dataAdapterConfig);
        dataAdapter.runETL();
    }
}