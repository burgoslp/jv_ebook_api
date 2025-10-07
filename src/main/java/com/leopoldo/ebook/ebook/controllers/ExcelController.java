package com.leopoldo.ebook.ebook.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leopoldo.ebook.ebook.services.GeneratorExcelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/excels")
public class ExcelController {

    @Autowired
    private GeneratorExcelServices ges;

    @GetMapping("/report/general")
    public ResponseEntity<byte[]> generalReport() throws Exception {
        byte[] excel = ges.excelGeneralReport();
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=general_report.xlsx")
            .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            .body(excel);
    }
    
}
