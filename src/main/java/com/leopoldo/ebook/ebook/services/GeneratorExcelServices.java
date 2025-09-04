package com.leopoldo.ebook.ebook.services;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Book.BookByCategoryDto;
import com.leopoldo.ebook.ebook.services.interfaces.IAuthorServices;
import com.leopoldo.ebook.ebook.services.interfaces.IBookServices;
import com.leopoldo.ebook.ebook.services.interfaces.ICategoryServices;

@Service
public class GeneratorExcelServices {

    @Autowired
    private IAuthorServices as;

    @Autowired
    private IBookServices bs;

    @Autowired
    private ICategoryServices cs;

    public byte[] excelGeneralReport() throws Exception {

        Workbook workbook= new XSSFWorkbook();

        // Crear una hoja en el libro de trabajo
        Sheet sheet= workbook.createSheet("Reporte General");

        // Crear estilo para ajuste de texto
        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setAlignment(HorizontalAlignment.CENTER);

        // Cambiar color de fondo
        wrapStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        wrapStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Crear y configurar fuente
        Font headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.getIndex()); // Color del texto
        headerFont.setBold(true);
        wrapStyle.setFont(headerFont);

        // Agregar datos a la hoja staticamente
        Row header= sheet.createRow(0);
        header.createCell(0).setCellValue("Tot. Libros");
        header.createCell(1).setCellValue("Tot. autores");
        header.createCell(2).setCellValue("Tot. categorias");


        List<BookByCategoryDto> bookByCategoryDtoList= (List<BookByCategoryDto>) bs.countByCategory().getData();
        int x=3; 
        for(BookByCategoryDto bc: bookByCategoryDtoList){
            header.createCell(x).setCellValue("Tot. libros de "+bc.getCategoryName());
            x++;
        }
        
        // Aplica el estilo a cada celda del header
        for (int i = 0; i < x; i++) {
            header.getCell(i).setCellStyle(wrapStyle);
        }

        // Agregar datos a la hoja
        Row dataRow= sheet.createRow(1);
        dataRow.createCell(0).setCellValue((long)bs.countBooks().getData());
        dataRow.createCell(1).setCellValue((long)as.countAuthors().getData());
        dataRow.createCell(2).setCellValue((long)cs.countCategories().getData());

        x=3;
        for(BookByCategoryDto bc: bookByCategoryDtoList){
            dataRow.createCell(x).setCellValue(bc.getTotalBooks());
            x++;
        }

        // Autoajustar el ancho de las columnas del header
        int totalColumns= x; //ultimo indice
        for (int i = 0; i < totalColumns; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el libro de trabajo en un archivo    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();
        byte[] data = bos.toByteArray();
        bos.close();
        return data;
    }

}
