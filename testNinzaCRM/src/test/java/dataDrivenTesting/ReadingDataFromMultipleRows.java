package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromMultipleRows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\m13.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
//		Row r = sh.getRow(1);
//		Cell c = r.getCell(0);
//		String value=c.getStringCellValue();
		int rownum=sh.getLastRowNum();
		for(int i=1;i<=rownum;i++)
		{
			String name=sh.getRow(i).getCell(0).getStringCellValue();
			String yoe=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(name+"-----"+yoe);
		}
		
		wb.close();

	}

}
