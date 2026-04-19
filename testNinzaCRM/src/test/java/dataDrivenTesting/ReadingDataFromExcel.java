package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\m13.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
//		Row r = sh.getRow(1);
//		Cell c = r.getCell(0);
//		String value=c.getStringCellValue();
		String value=sh.getRow(1).getCell(0).getStringCellValue();
		String value1=sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(value+"  "+value1);
		wb.close();
	}

}
