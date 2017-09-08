package debugging;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WorkbookTest {
	static final String TEXT = "𝑦 = 𝑚𝑥 + 𝑏, 𝐴𝑥 + 𝐵𝑦 = 𝐶, and 𝑦 - 𝑦₁ = 𝑚(𝑥 - 𝑥₁)";
	static final String FILE_NAME = "test-workbook.xlsx";

	@Test
	public void testWorkbook() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(TEXT);

		FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
		workbook.write(outputStream);
		workbook.close();
	}
}
