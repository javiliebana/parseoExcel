import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Servicio> lista_servicios=Parseo.parseoExcel();
		String script=CrearScript.crearScript(lista_servicios);
		CrearScript.crearFichero(script);
	}

}
