package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDateExelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Employee.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Employee");
		Row row = sheet.createRow(3);
		Cell cell = row.createCell(0);
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		Cell cell3 = row.createCell(3);
		
		
		cell.setCellValue("Md Mir Hossain");
		cell1.setCellValue("developer");
		cell2.setCellValue("MIRinda");
		cell3.setCellValue("Khottapar");
		
		
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Employee.xlsx");
		wb.write(fos);
		System.out.println("upadete is done");

	}

}
