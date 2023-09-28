package Codigo;
import java.io.File;
import java.io.IOException;
import jflex.exceptions.SilentExit;

public class Main {
    public static void main(String[] args) throws IOException, SilentExit {
        String ruta = "G:/ReposGit/ProyectoCompi/Scanner/src/Codigo/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta) throws IOException, SilentExit{
        File archivo = new File(ruta);
        //String archivoString = Files.readString(Paths.get(ruta));
        //String[] archivoArray = archivoString.split(" ");
        JFlex.Main.generate(archivo);
    }
}
