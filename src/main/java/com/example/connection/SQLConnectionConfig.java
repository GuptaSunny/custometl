package com.example.connection;

import com.example.extractor.DataExtractor;
import com.example.extractor.SqlExtractor;
import com.example.loader.DataLoader;
import com.example.loader.SqlDataLoader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Service
public class SQLConnectionConfig implements ConnectionConfig {
    private String url;
    private String username;
    private String password;
    private String database;
    private DataBaseEngine dataBaseEngine = DataBaseEngine.MYSQL;

    public DataExtractor getExtractor() {
        return new SqlExtractor(createDataSource());
    }

    public DataLoader getLoader() {
        return new SqlDataLoader();
    }


    public DataSource createDataSource() {
        return DataSourceBuilder.create().username(username).password(password).url(buildURL())
                .driverClassName("com.mysql.cj.jdbc.Driver").build();
    }

    public enum DataBaseEngine {
        MYSQL
    }

    private String buildURL() {
        if (dataBaseEngine == DataBaseEngine.MYSQL)
            return "jdbc:mysql://" + url + "/" + database;
        throw new IllegalArgumentException();
    }
}
