import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// arraylist de objetos servicios
		ArrayList<Servicio> lista_servicios = Parseo.parseExcel();
		// creacion de un script con los atributros de los objetos
		String script = Script.crearScript(lista_servicios);
		Script.crearFichero(script);
	}

}
