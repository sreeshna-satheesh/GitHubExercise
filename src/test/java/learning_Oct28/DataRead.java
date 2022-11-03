package learning_Oct28;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRead {

	private static XSSFWorkbook workbook;

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("./testData/RegistrationData.xlsx");

		workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("smokeTest");

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i);

			String fName = currentRow.getCell(0).toString();

			/*String lName = currentRow.getCell(1).toString();

			String email = currentRow.getCell(2).toString();

			String phone = currentRow.getCell(3).toString();
*/
			String address = currentRow.getCell(4).toString();

			System.out.println("FirstName: " + fName);

			System.out.println("Address: " + address);

			System.out.println("====================================");

		}

	}
}
