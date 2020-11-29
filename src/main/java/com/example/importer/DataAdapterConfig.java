package com.example.importer;

import com.example.connection.ConnectionConfig;
import com.example.transformer.DataSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataAdapterConfig {
    private ConnectionConfig sourceConfig;
    private ConnectionConfig targetConfig;
    private DataSet dataSet;
}
