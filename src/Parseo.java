import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parseo {
	public static ArrayList<Servicio> parseoExcel() {
		File f = new File("tabla.xlsx");

		FileInputStream fl;
		try {

			fl = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fl);
			XSSFSheet sheet = wb.getSheetAt(0);
			ArrayList<Servicio> lista_servicios = new ArrayList<Servicio>();
			Iterator<Row> rit = sheet.rowIterator();

			// saltamos la primera fila que son el nombre de las columnas
			Row row = rit.next();

			/*
			 * for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) { problema:hay
			 * 1000 filas y apareceria como null en el script, solucion:como se el numero de
			 * filas exacto, lo indico en el blucle
			 */

			for (int i = 1; i < 28; i++) {

				row = rit.next();
				Servicio s = new Servicio();

				s.setPaquete(getCellValueAsString(row.getCell(0)));
				s.setCode(getCellValueAsString(row.getCell(1)));
				s.setDescripcion(getCellValueAsString(row.getCell(2)));
				s.setIncluye(getCellValueAsString(row.getCell(3)));
				s.setExcluye(getCellValueAsString(row.getCell(4)));
				s.setTipo_precio(getCellValueAsString(row.getCell(5)));
				s.setPrecio_sugeridoLM(getCellValueAsString(row.getCell(6)));
				s.setPrecio_1h(getCellValueAsString(row.getCell(7)));
				s.setPrecio_nexth(getCellValueAsString(row.getCell(8)));
				s.setTips(getCellValueAsString(row.getCell(9)));

				lista_servicios.add(s);

			}
			return lista_servicios;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getCellValueAsString(Cell cell) {

		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:

				strCellValue = cell.toString();

				break;

			case NUMERIC:

				if (DateUtil.isCellDateFormatted(cell)) {

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());

				} else {

					Double value = cell.getNumericCellValue();

					Long longValue = value.longValue();

					strCellValue = new String(longValue.toString());
				}

				break;

			case BOOLEAN:

				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());

				break;

			case BLANK:

				strCellValue = "";

				break;
			}
		}
		return strCellValue;
	}

}
