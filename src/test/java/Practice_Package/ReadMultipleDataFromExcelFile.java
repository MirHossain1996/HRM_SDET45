package Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Employee.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Employee");
		int countrow=sheet.getLastRowNum();
	
		int countcell=sheet.getRow(0).getLastCellNum();
		System.out.println("number of row:  "+countrow);
		for (int i = 0; i < countrow; i++) {
			for (int j = 0; j <countcell; j++) {
			String name = sheet.getRow(i).getCell(j).getStringCellValue();
		
			
			System.out.print(name+"   ");
		}
			System.out.println();
			
		}
		
		  
	}

}