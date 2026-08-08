import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 1. Escribir datos en un archivo APPEND.
 * 2. Modo APPEND (agregar): FileWriter con "append=true" agregará al final del archivo sin borrar el contenido.
 * 3. Modo WRITE (escritura): FileWriter con "append=false" sobreescribirá el contenido existente.
 * 4. Modo READ (lectura): BufferedReader/FileReader solo permiten leer los datos del archivo.
 */
public class ManejoArchivosTxt {

    public static void main(String[] args) throws IOException {
        try (FileWriter archivo = new FileWriter("datos.txt", true)) {
            archivo.write("Holas\n");
        }

        FileWriter archivo = new FileWriter("datos.txt", false);
        archivo.write("idk");
        archivo.close();

        BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
        lector.close();

        System.out.println(contenido.toString());
    }
}
