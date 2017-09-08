package poidebugging;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class CreateWorkbook {
	static final String TEXT = "𝑦 = 𝑚𝑥 + 𝑏, 𝐴𝑥 + 𝐵𝑦 = 𝐶, and 𝑦 - 𝑦₁ = 𝑚(𝑥 - 𝑥₁)";
	static final String FILE_NAME = "test-workbook.xlsx";

	public static void main(String... args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
//		cell.setCellValue(TEXT);

		XSSFRichTextString string = new XSSFRichTextString(TEXT);
		cell.setCellValue(TEXT);

		try {
			File outputFile = new File("/output", FILE_NAME);
			System.out.println("Creating " + outputFile);
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
