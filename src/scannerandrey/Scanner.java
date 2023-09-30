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
import java.util.ArrayList;
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
    private static ArrayList<ArrayList> tokensList = new ArrayList<ArrayList>();
    private static ArrayList<ArrayList> errores = new ArrayList<ArrayList>();
    private static String linesaux = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SilentExit{
        String ruta = "C:/Users/XPC/Documents/TEC/II Semestre 2023/Compi/Proyectos/Proyecto 1/ProyectoCompi/src/scannerandrey/Lexer.flex";
        generarLexer(ruta);
        ruta = "C:/Users/XPC/Downloads/para pruebas.txt";
        readFile(ruta);
        organizador();
        System.out.println("TOKEN       \tTIPO                      \tLinea(s)\n");
        for (int i = 0; i < tokensList.size(); i++) {
            String prnt = (String) tokensList.get(i).get(0);
            String prnt2 = (String) tokensList.get(i).get(1);
            String prnt3 = (String) tokensList.get(i).get(2);
            System.out.println(prnt + prnt2 + prnt3);
        }
        System.out.println("\n___________________________________________________________________");
        System.out.println("ERROR LEXICO       \tLinea                     \n");
        for (int i = 0; i < errores.size(); i++) {
            String prnt = (String) errores.get(i).get(0);
            String prnt2 = (String) errores.get(i).get(1);
            System.out.println(prnt + prnt2 );
        }
        
    }
    
    public static void readFile (String path) throws FileNotFoundException, IOException
    {   
        ArrayList<String> aux = new ArrayList<String>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            Lexer lexer = new Lexer(br);
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null){
                    return;                    
                }
                switch (tokens){
                    case Error:
                        aux = new ArrayList<String>();
                        aux.add(String.valueOf(lexer.lexeme+ "       \t"));
                        aux.add(String.valueOf(lexer.GetLine()));
                        errores.add(aux);
                        break;
                    case Identificador:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme+ "       \t"));
                            aux.add("IDENTIFICADOR             \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                        }break;
                    case Literal:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("LITERAL                   \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                        }break;
                    case Reservada:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("PALABRA RESERVADA         \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                        }break;
                    case Operador:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("OPERADOR                  \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                        }break;
                    case OperadorReservado:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("PALABRA RESERVADA/OPERADOR\t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                        }break;
                    default:
                        aux = new ArrayList<String>();
                        aux.add("Token" + "\t" + tokens  + "\n");
                        tokensList.add(aux);
                        break;
                }
                
               
            }
        }   
    }
    
    public static void generarLexer(String ruta) throws IOException, SilentExit{
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        
    }
    
    public static boolean yaExiste(String token, int line){
        for (int i = 0; tokensList.size() > i; i++) {
            String aux = (String) tokensList.get(i).get(0);
            if(token.trim().toLowerCase().equals(aux.trim().toLowerCase())){
               tokensList.get(i).add(String.valueOf(line));
               return true;
            }   
        }
        return false;

    }
    
   
    public static void organizador(){
        for (int i = 0; i < tokensList.size(); i++) {
            int pivote = 3;
            int contador=1;
            while(tokensList.get(i).size()>= pivote){
                if (tokensList.get(i).size() == pivote && pivote == 3){
                    if(contador == 1){
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + "\n";
                        tokensList.get(i).set(2, linesaux);
                        linesaux = "";
                    }else{
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + "("+ String.valueOf(contador) +")\n";
                        tokensList.get(i).set(2, linesaux);
                        linesaux = "";
                    }
                    break;
                }
                else if(tokensList.get(i).size() == pivote && pivote!= 3){
                    if(contador == 1){
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + ", ";
                        tokensList.get(i).remove(2);
                    }else{
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + "("+ String.valueOf(contador) +"), ";
                        tokensList.get(i).remove(2);
                    }
                    pivote = 3;
                    contador = 1;
                }else {
                    String existente = (String) tokensList.get(i).get(2);
                    String nuevo = (String) tokensList.get(i).get(pivote);
                    if (existente.trim().equals(nuevo.trim())){
                        contador++;
                        tokensList.get(i).remove(pivote);
                        tokensList.get(i).trimToSize();
                    }
                    else{
                        pivote++;
                    }
                }
            }
            pivote = 3;
            contador = 1;
            
        }
    }
    
    
}
