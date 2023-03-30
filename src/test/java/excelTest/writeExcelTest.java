package excelTest;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constants;



public class writeExcelTest {
public static void main(String[] args) throws IOException {
	//open connection to the file
	 //open connection to the file
    FileInputStream fs = new FileInputStream(Constants.excelDocument_path);

    // gets a workbook open
    XSSFWorkbook workbook = new XSSFWorkbook(fs);
    
    //get sheet index of
    XSSFSheet sheet = workbook.getSheet("Sheet2");
    
    int lastRowNum = sheet.getLastRowNum();
    System.out.println(lastRowNum);
    
    
    for(int i = 0; i<= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            //Row row = sheet.createRow(i);
            Cell cell = row.createCell(6);
            
            cell.setCellValue("Hello, hows the project going");
    
        
    }
    
    FileOutputStream fos = new FileOutputStream(Constants.excelDocument_path);
    
    workbook.write(fos);
    
    fos.close();



	
	
	
	
	
	
}
}
