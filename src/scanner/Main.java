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
        Scanner scanner = new Scanner();
        String ruta = "./src/scanner/Lexer.flex";
        scanner.generarLexer(ruta);
        ruta = "./src/scanner/para pruebas.txt";
        scanner.readFile(ruta);     //Se realiza el analisis lexico del txt
        scanner.organizador();      //Se organiza la lista de Tokens
        System.out.println("TOKEN       \tTIPO                      \tLinea(s)\n");
        
        String columnsTokens[] = {"Token","Tipo","Linea(s)"};
        String columnsErrors[] = {"Error", "Linea"};
        String datosTokens[][] = new String[scanner.getTokensList().size()][3];
        String datosErrores[][] = new String[scanner.getErrores().size()][3];
        for (int i = 0; i < scanner.getTokensList().size(); i++) {
            String prnt = (String) scanner.getTokensList().get(i).get(0);
            String prnt2 = (String) scanner.getTokensList().get(i).get(1);
            String prnt3 = (String) scanner.getTokensList().get(i).get(2);
            datosTokens[i][0]= prnt;
            datosTokens[i][1]= prnt2;
            datosTokens[i][2]= prnt3;
            System.out.println(prnt + prnt2 + prnt3);
        }
        System.out.println("\n___________________________________________________________________");
        System.out.println("ERROR LEXICO       \tLinea                     \n");
        for (int i = 0; i < scanner.getErrores().size(); i++) {
            String prnt = (String) scanner.getErrores().get(i).get(0);
            String prnt2 = (String) scanner.getErrores().get(i).get(1);
            datosErrores[i][0]= prnt;
            datosErrores[i][1]= prnt;
            System.out.println(prnt + prnt2 );
        }
        //DefaultTableModel modelTokens = new DefaultTableModel(datosTokens,columnsTokens);
        //DefaultTableModel modelErrors = new DefaultTableModel(datosErrores,columnsErrors);
        //jTableTokens.setModel(modelTokens);
        //jTableErrors.setModel(modelErrors);
    }
    
    
}
