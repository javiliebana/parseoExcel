import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CrearScript {
	public static String crearScript(ArrayList<Servicio> lista_servicios) {
		String script = "";
		// Comprobacion de parseo en una base de datos:
		script = "CREATE TABLE paquetes_off_service (paquetes VARCHAR(255), codigo VARCHAR(255),description VARCHAR(255), incluye VARCHAR(255), excluye VARCHAR(255), cuantificable VARCHAR(255),precio_lm VARCHAR(255), precio_1h VARCHAR(255),precio_next VARCHAR(255), tips VARCHAR(255));"
				+ "\n";
		for (Servicio servicio : lista_servicios) {
			System.out.println(servicio.getPaquete() + " / " + servicio.getCode() + " / " + servicio.getDescripcion()
					+ " / " + servicio.getIncluye() + " " + servicio.getExcluye() + " / " + servicio.getTipo_precio()
					+ " / " + servicio.getPrecio_sugeridoLM() + " / " + servicio.getPrecio_1h() + " / "
					+ servicio.getPrecio_nexth() + " / " + servicio.getTips());
			System.out.println("-----------------");
			script += "INSERT INTO paquetes_off_service (paquetes,codigo,description,incluye,excluye,cuantificable,precio_lm,precio_1h,precio_next,tips) VALUES('"
					+ servicio.getPaquete() + "','" + servicio.getCode() + "','" + servicio.getDescripcion() + "','"
					+ servicio.getIncluye() + "','" + servicio.getExcluye() + "','" + servicio.getTipo_precio() + "','"
					+ servicio.getPrecio_sugeridoLM() + "','" + servicio.getPrecio_1h() + "','"
					+ servicio.getPrecio_nexth() + "','" + servicio.getTips() + "'); " + "\n";
		}

		return script;

	}

	public static void crearFichero(String script) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("script.txt");
			pw = new PrintWriter(fichero);
			pw.print(script);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
