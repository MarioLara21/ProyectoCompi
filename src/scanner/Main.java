/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import jflex.exceptions.SilentExit;

/**
 *
 * @author Mario Lara
 * @author Andrey Sanchez
 * @author Jonnathan Villalobos
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SilentExit, Exception{
        var scanner = new Scanner();
        String ruta1 = "src/scanner/Lexer.flex";
        String ruta2 = "src/scanner/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "src/scanner//Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
        InterfazScanner interfaz = new InterfazScanner();
        interfaz.show();
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("src/scanner/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("Scanner/sym.java"), 
                Paths.get("src/scanner/sym.java")
        );
        Path rutaSin = Paths.get("src/scanner/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("Scanner/Sintax.java"), 
                Paths.get("src/scanner/Sintax.java")
        );
    }
}
