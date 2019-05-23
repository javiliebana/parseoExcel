import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// arraylist de objetos servicios
		ArrayList<Servicio> lista_servicios = Parseo.parseoExcel();
		// creacion de un script con los atributros de los objetos
		String script = CrearScript.crearScript(lista_servicios);
		CrearScript.crearFichero(script);
	}

}
