/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scannerandrey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import jflex.exceptions.SilentExit;
import static scannerandrey.Tokens.Error;
import static scannerandrey.Tokens.Identificador;
import static scannerandrey.Tokens.Literal;
import static scannerandrey.Tokens.Operador;
import static scannerandrey.Tokens.OperadorReservado;
import static scannerandrey.Tokens.Reservada;

/**
 *
 * @author XPC
 */
public class Scanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SilentExit{
        String ruta = "C:/Users/XPC/Documents/TEC/II Semestre 2023/Compi/Proyectos/Proyecto 1/ProyectoCompi/src/scannerandrey/Lexer.flex";
        generarLexer(ruta);
        ruta = "C:/Users/XPC/Downloads/para pruebas.txt";
        System.out.println(readFile(ruta));
        
    }
    
    public static String readFile (String path) throws FileNotFoundException, IOException
    {
        String everything = "";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            Lexer lexer = new Lexer(br);
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null){
                    everything += "FIN";
                    return everything;                    
                }
                switch (tokens){
                    case Error:
                        everything += lexer.lexeme + ": Simbolo erroneo\n";
                        break;
                    case Identificador:
                        everything += lexer.lexeme + "\t" + "IDENTIFICADOR\t" + "LINEA\n";
                        break;
                    case Literal:
                        everything += lexer.lexeme + "\t" + "LITERAL\t" + "LINEA\n";
                        break;
                    case Reservada:
                        everything += lexer.lexeme + "\t" + "PALABRA RESERVADA\t" + "LINEA\n";
                        break;
                    case Operador:
                        everything += lexer.lexeme + "\t" + "OPERADOR\t" + "LINEA\n";
                        break;
                    case OperadorReservado:
                        everything += lexer.lexeme + "\t" + "PALABRA RESERVADA/OPERADOR\t" + "LINEA\n";
                        break;
                    default:
                        everything +=  "Token" + "\t" + tokens  + "\n";
                        break;
                }
                
               
            }
        }   
    }
    
    public static void generarLexer(String ruta) throws IOException, SilentExit{
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        
    }
    
    
}
