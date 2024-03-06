package co.icesi.edu.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Archivo {
    private File archivo;

    public Archivo(String path) {
        this.archivo = new File(path);
    }

    public long darTamano() {
        return this.archivo.length();
    }

    public String darRuta() {
        return this.archivo.getAbsolutePath();
    }

    public Date darFechaModificacion() {
        return new Date(this.archivo.lastModified());
    }

    public boolean contienePrefijo(String prefijo)
            throws IOException {
        boolean contiene = false;
        FileReader reader = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(reader);
        String linea = lector.readLine();
        while (linea != null && !contiene) {
            contiene = lineaContiene(linea, prefijo);
            linea = lector.readLine();
        }
        lector.close();
        reader.close();
        return contiene;
    }

    public boolean esTexto() {
        String nombre = archivo.getName();
        return nombre.toUpperCase().endsWith(".TXT");
    }

    private boolean lineaContiene(String linea, String prefijo) {
        linea = limpiarLinea(linea);
        String[] palabras = linea.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].toLowerCase().startsWith(
                    prefijo.toLowerCase()))
                return true;
        }
        return false;
    }

    private String limpiarLinea(String linea) {
        linea = linea.replace(".", " ");
        linea = linea.replace(",", " ");
        linea = linea.replace(":", " ");
        linea = linea.replace(";", " ");
        linea = linea.replace("!", " ");
        linea = linea.replace("*", " ");
        linea = linea.replace("(", " ");
        linea = linea.replace(")", " ");
        return linea.trim();
    }

    public void escribirArchivo(String contenido)
            throws IOException {
        PrintWriter escritor = new PrintWriter(archivo);
        escritor.println(contenido);
        escritor.close();
    }
}
