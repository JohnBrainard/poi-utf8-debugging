package debugging;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.junit.Assert;
import org.junit.Test;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SharedStingsTableTest {
	@Test
	public void testSharedStringsTable() throws IOException {
		String text = "𝑦 = 𝑚𝑥 + 𝑏, 𝐴𝑥 + 𝐵𝑦 = 𝐶, and 𝑦 - 𝑦₁ = 𝑚(𝑥 - 𝑥₁)";
		SharedStringsTable table = new SharedStringsTable();
		CTRst st = CTRst.Factory.newInstance();
		st.setT(text);
		table.addEntry(st);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		table.writeTo(baos);
		String output = baos.toString("UTF-8");

		// This assertion passes
		Assert.assertEquals(st.getT(), text);

		// This assertion fails
		Assert.assertEquals(output, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<sst count=\"1\" uniqueCount=\"1\" xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\"><si><t>𝑦 = 𝑚𝑥 + 𝑏, 𝐴𝑥 + 𝐵𝑦 = 𝐶, and 𝑦 - 𝑦₁ = 𝑚(𝑥 - 𝑥₁)</t></si></sst>");
	}
}
