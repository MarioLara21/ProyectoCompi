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
    public static void main(String[] args) throws IOException, SilentExit{
        /*String ruta = "./src/scanner/Lexer.flex";
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        */InterfazScanner interfaz = new InterfazScanner();
        interfaz.show();
        
    }
}
