package com.example.extractor;

import com.example.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Service
public class FileExtractor implements DataExtractor {

    private InputStream inputStream;


    public List<Object> extractData() {
        List products = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0)
                    continue;
                ProductDTO product = new ProductDTO();
                product.setName(row.getCell(0).getStringCellValue());
                product.setCategory(row.getCell(1).getStringCellValue());
                product.setPrice(row.getCell(2).getNumericCellValue());
                product.setDescription(row.getCell(3).getStringCellValue());
                product.setProvider(row.getCell(4).getStringCellValue());
                products.add(product);
            }
        } catch (Exception e) {
            log.error("Unable to extract data", e);
        }
        log.info(" File Data extracted.......");
        return products;
    }
}
