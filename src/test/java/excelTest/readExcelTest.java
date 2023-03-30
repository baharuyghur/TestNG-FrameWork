package excelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constants;



public class readExcelTest{
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fs= new FileInputStream(Constants.excelDocument_path);
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
			//Row row= sheet.getRow(6);
			//Cell cell= row.getCell(1);
		    //System.out.println(cell);
		
		for (Row row : sheet) {

            for (Cell cell : row) {
//                System.out.println(cell.getStringCellValue());
                switch (cell.getCellType()) {
                
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case NUMERIC:
                    System.out.println(cell.getNumericCellValue());
                    break;
                case STRING: 
                    System.out.println(cell.getRichStringCellValue());
                    break;
                case FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                }
                System.out.println(" ");
            }
        }
            workbook.close();	
				
			}
	}