package com.example.loader;

import com.example.dto.ProductDTO;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SqlDataLoader implements DataLoader {
    ProductRepository productRepository;
    DataSource dataSource;

    public int[] loadData(List<Object> objects) {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            final String INSERT_QUERY = "insert into product (name, price) values (?, ?)";
            List<Object[]> list = new ArrayList<>();
            for (Object object : objects) {
                ProductDTO product = (ProductDTO) object;
                Object[] values = new Object[]{product.getName(), product.getPrice()};
                list.add(values);
            }
            return jdbcTemplate.batchUpdate(INSERT_QUERY, list);
        } catch (Exception e) {
            log.error("Data loading failed", e);
        }
        log.info(" Data loaded to database.......");
        return null;
    }
}
