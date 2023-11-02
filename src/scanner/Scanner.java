/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import jflex.exceptions.SilentExit;
import static scanner.Tokens.Error;
import static scanner.Tokens.Identificador;
import static scanner.Tokens.Literal;
import static scanner.Tokens.Operador;
import static scanner.Tokens.OperadorReservado;
import static scanner.Tokens.Reservada;

/**
 *
 * @author XPC
 */
public class Scanner {
    private static ArrayList<ArrayList> tokensList = new ArrayList<ArrayList>();
    private static ArrayList<ArrayList> errores = new ArrayList<ArrayList>();
    private static String linesaux = "";
    
    /**
     * Constructor de la clase
     */
    public Scanner() {
        this.tokensList = new ArrayList<ArrayList>();
        this.errores = new ArrayList<ArrayList>();
        this.linesaux = "";
    }
    
    /**
     * Metodo que recibe el path de un txt y le realiza el analisis lexico
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void readFile (String path) throws FileNotFoundException, IOException
    {   
        ArrayList<String> aux = new ArrayList<String>(); //Cada token se guarda en un arraylist con la informacion a desplegar

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            Lexer lexer = new Lexer(br);
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null){
                    return;                    
                }
                //Se categorizan los tokens
                switch (tokens){                 
                    case Error:
                        aux = new ArrayList<String>();
                        aux.add(String.valueOf(lexer.lexeme+ "       \t"));
                        aux.add(String.valueOf(lexer.GetLine()));
                        errores.add(aux);
                        break;
                    case Reservada:
                        if (!yaExiste(lexer.lexeme, lexer.GetLine())) {
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("PALABRA RESERVADA         \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                            System.out.println("Entra reservada");
                        }
                        break;
                    case Identificador:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme+ "       \t"));
                            aux.add("IDENTIFICADOR             \t");
                            aux.add(String.valueOf(lexer.GetLine()));
                            tokensList.add(aux);
                            System.out.println("Entra id");
                        }break;
                    case Literal:
                        if(!yaExiste(lexer.lexeme,lexer.GetLine())){
                            aux = new ArrayList<String>();
                            aux.add(String.valueOf(lexer.lexeme + "       \t"));
                            aux.add("LITERAL                   \t");
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
    
    /**
     * Metodo para generar la clase Lexer a partir del file Lexer.flex
     * @param ruta
     * @throws IOException
     * @throws SilentExit 
     */
    public static void generarLexer(String ruta) throws IOException, SilentExit{
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        
    }
    
    /**
     * Metodo para verificar si el token ya fue utilizado en el txt
     * Recibe el nombre del token y la linea en la que se encuentra
     * Retorna true si ya fue utilizado y false en caso contrario
     * @param token
     * @param line
     * @return boolean
     */
    public static boolean yaExiste(String token, int line){
        for (int i = 0; tokensList.size() > i; i++) {
            String aux = (String) tokensList.get(i).get(0);
            if(token.trim().toLowerCase().equals(aux.trim().toLowerCase())){  //Se verifica y se asegura que no haya distincion de mayusculas
               tokensList.get(i).add(String.valueOf(line));
               return true;
            }   
        }
        return false;

    }
    
   /**
    * Metodo para organizar la lista de tokens una vez finalizado el analisis léxico
    * Agrega en un solo string las lineas en las que aparece el token
    */
    public static void organizador(){
        for (int i = 0; i < tokensList.size(); i++) {
            int pivote = 3;
            int contador=1;
            while(tokensList.get(i).size()>= pivote){
                if (tokensList.get(i).size() == pivote && pivote == 3){ //Caso 1: el token solo se utiliza una vez o ya se analizaron todas las lineas
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
                else if(tokensList.get(i).size() == pivote && pivote!= 3){ //Caso 2: El token ya se comparo con todas las lineas, pero quedan lineas por analizar
                    if(contador == 1){
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + ", ";
                        tokensList.get(i).remove(2);
                    }else{
                        linesaux = linesaux + String.valueOf(tokensList.get(i).get(2)) + "("+ String.valueOf(contador) +"), ";
                        tokensList.get(i).remove(2);
                    }
                    pivote = 3;
                    contador = 1;
                }else { //Caso 3: No se ha terminado de analizar la linea con las demas menciones del token
                    String existente = (String) tokensList.get(i).get(2);
                    String nuevo = (String) tokensList.get(i).get(pivote);
                    if (existente.trim().equals(nuevo.trim())){ //Se analiza si un mismo token aparece mas de una vez en la misma linea
                        contador++;
                        tokensList.get(i).remove(pivote); //Si aparece varias veces se elimina el pivote para llevar la cuenta sin repeticiones
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
    
    public ArrayList<ArrayList> getTokensList() {
        return tokensList;
    }

    public ArrayList<ArrayList> getErrores() {
        return errores;
    }
    
}
