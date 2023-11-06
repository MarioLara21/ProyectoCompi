package scanner;
import static scanner.Tokens.*;

import java.io.*;

/**
 *
 * @author Mario Lara
 * @author Andrey Sanchez
 * @author Jonnathan Villalobos
 */

%%
%class Lexer
%type Tokens
%line

%unicode
%caseless
%ignorecase


// Definición de estados

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}

%{
    public int GetLine() { return yyline + 1; }

%}

%%

// Definicion de palabras reservadas

"array" {lexeme=yytext(); return Array;}
"begin" {lexeme=yytext(); return Begin;}
"boolean" {lexeme=yytext(); return Boolean;}
"byte" {lexeme=yytext(); return Byte;}
"case" {lexeme=yytext(); return Case;}
"char" {lexeme=yytext(); return Char;}
"const" {lexeme=yytext(); return Const;}
"do" {lexeme=yytext(); return Do;}
"downto" {lexeme=yytext(); return Downto;}
"else" {lexeme=yytext(); return Else;}
"end" {lexeme=yytext(); return End;}
"false" {lexeme=yytext(); return False;}
"file" {lexeme=yytext(); return File;}
"for" {lexeme=yytext(); return For;}
"forward" {lexeme=yytext(); return Forward;}
"function" {lexeme=yytext(); return Function;}
"goto" {lexeme=yytext(); return Goto;}
"if" {lexeme=yytext(); return If;}
"in" {lexeme=yytext(); return In;}
"inline" {lexeme=yytext(); return Inline;} 
"int" {lexeme=yytext(); return Int;}
"label" {lexeme=yytext(); return Label;}
"longint" {lexeme=yytext(); return Longint;}
"nil" {lexeme=yytext(); return Nil;}
"of" {lexeme=yytext(); return Of;}
"packed" {lexeme=yytext(); return Packed;}
"procedure" {lexeme=yytext(); return Procedure;}
"program" {lexeme=yytext(); return Program;}
"read" {lexeme=yytext(); return Read;}
"real" {lexeme=yytext(); return Real;}
"record" {lexeme=yytext(); return Record;}
"repeat" {lexeme=yytext(); return Repeat;}
"set" {lexeme=yytext(); return Set;}
"shortint" {lexeme=yytext(); return Shortint;}
"string" {lexeme=yytext(); return String;}
"then" {lexeme=yytext(); return Then;}
"to" {lexeme=yytext(); return To;}
"true" {lexeme=yytext(); return True;}
"type" {lexeme=yytext(); return Type;}
"until" {lexeme=yytext(); return Until;}
"var" {lexeme=yytext(); return Var;}
"while" {lexeme=yytext(); return While;}
"with" {lexeme=yytext(); return With;}
"write" {lexeme=yytext(); return Write;}

// Definicion de ignorar espacios en blanco y comentarios

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
("\(\*" [^]* "\*\)") {/*Ignore*/}
("\{" [^]* "\}") {/*Ignore*/}

// Definicion de operadores

"\n" {lexeme=yytext(); return SaltoLinea;}
"," {lexeme=yytext(); return Coma;}
";" {lexeme=yytext(); return PuntoComa;}
"\+\+" {lexeme=yytext(); return Sumadoble;}
"--" {lexeme=yytext(); return RestaDoble;}
">=" {lexeme=yytext(); return MayorIgual;}
">" {lexeme=yytext(); return Mayor;}
"<=" {lexeme=yytext(); return MenorIgual;}
"<" {lexeme=yytext(); return Menor;}
"<>" {lexeme=yytext(); return Puntas;}
"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"\(" {lexeme=yytext(); return ParentesisA;}
"\)" {lexeme=yytext(); return ParentesisC;}
"\[" {lexeme=yytext(); return CorcheteA;}
"\]" {lexeme=yytext(); return CorcheteC;}
":=" {lexeme=yytext(); return PuntoIgual;}
"." {lexeme=yytext(); return Punto;}
":" {lexeme=yytext(); return DosPuntos;}
"\+=" {lexeme=yytext(); return SumaS;}
"-=" {lexeme=yytext(); return RestaS;}
"\*=" {lexeme=yytext(); return MultiplicacionS;}
"/=" {lexeme=yytext(); return DivisionS;}
">>" {lexeme=yytext(); return MayorDoble;}
"<<" {lexeme=yytext(); return MenorDoble;}
"<<=" {lexeme=yytext(); return MenorDobleIgual;}
">>=" {lexeme=yytext(); return MayorDobleIgual;}

// Definicion de operadores que son palabras reservadas

"not" {lexeme=yytext(); return Not;}
"or" {lexeme=yytext(); return Or;}
"and" {lexeme=yytext(); return And;}
"xor" {lexeme=yytext(); return Xor;}
"div" {lexeme=yytext(); return Div;}
"mod" {lexeme=yytext(); return Mod;}

// Definicion de la regla para identificadores

{L}({L}|{D}){125,200} {lexeme=yytext(); return Error;}
{L}({L}|{D})?{1,125} {lexeme=yytext(); return Identificador;}

//Definicion de las reglas para literales

([1-9][0-9]*|0)("\.")[0-9]+([eE][-+]?[0-9]+) {lexeme=yytext(); return Literal;} 
{D}+ | ([1-9][0-9]*|0)("\.")({D}+) {lexeme=yytext(); return Literal;}
("\#")[0-9]+ {lexeme=yytext(); return Literal;}
\"[^\n\"]*\" {lexeme=yytext(); return Literal;}

// Definicion de reglas que producen errores léxicos

({D}{L}) {lexeme=yytext(); return Error;}
(({L}+)? (("�" | "!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+) ({L}+)?) {lexeme=yytext(); return Error;}
(("\"")({L}+)(" " |{L})*) {lexeme=yytext(); return Error;}
(({L}+)((" " |{L}+)*) ("\"")) {lexeme=yytext(); return Error;}
(({D}+)("\.")) {lexeme=yytext(); return Error;}
("-")([1-9][0-9]*|0)("\.")?([0-9]+)?([eE][-+]?[0-9]+) {lexeme=yytext(); return Error;} 
(([1-9][0-9]*|0)("\.")([eE][-+]?)) {lexeme=yytext(); return Error;} 
(([1-9][0-9]*|0)("\.")([0-9]+)([eE][-+]?)) {lexeme=yytext(); return Error;}
(("\.")([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)) {lexeme=yytext(); return Error;}

("\(\*" [^]* ) {lexeme=yytext(); return Error;}
 \"[^\r\n\"]*\" {lexeme=yytext(); return Error;}
 \"([^/\"])*\" {lexeme=yytext(); return Error;}
. {lexeme=yytext(); return Error;}

