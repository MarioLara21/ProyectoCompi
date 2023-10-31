package scanner;
import java_cup.runtime.Symbol;

import java.io.*;

/**
 *
 * @author Mario Lara
 * @author Andrey Sanchez
 * @author Jonnathan Villalobos
 */

%%
%class LexerCup
%type java_cup.runtime.Symbol
%line
%maxmin
%cup
%full
%char
// Definición de estados

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type,Object value){
        return new Symbol(type,yyline,yycolumn,value);
};
    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
};
    
%}

%{
    public int GetLine() { return yyline + 1; }

%}

%%

// Definicion de palabras reservadas

"array" {return new Symbol(sym.Array, yychar, yyline,yytext());}
"begin" {return new Symbol(sym.Begin, yychar, yyline,yytext());}
"boolean" {return new Symbol(sym.Boolean, yychar, yyline,yytext());}
"byte" {return new Symbol(sym.Byte, yychar, yyline,yytext());}
"case" {return new Symbol(sym.Case, yychar, yyline,yytext());}
"char" {return new Symbol(sym.Char, yychar, yyline,yytext());}
"const" {return new Symbol(sym.Const, yychar, yyline,yytext());}
"do" {return new Symbol(sym.Do, yychar, yyline,yytext());}
"downto" {return new Symbol(sym.Downto, yychar, yyline,yytext());}
"else" {return new Symbol(sym.Else, yychar, yyline,yytext());}
"end" {return new Symbol(sym.End, yychar, yyline,yytext());}
"false" {return new Symbol(sym.False, yychar, yyline,yytext());}
"file" {return new Symbol(sym.File, yychar, yyline,yytext());}
"for" {return new Symbol(sym.For, yychar, yyline,yytext());}
"forward" {return new Symbol(sym.Forward, yychar, yyline,yytext());}
"function" {return new Symbol(sym.Function, yychar, yyline,yytext());}
"goto" {return new Symbol(sym.Goto, yychar, yyline,yytext());}
"if" {return new Symbol(sym.If, yychar, yyline,yytext());}
"in" {return new Symbol(sym.In, yychar, yyline,yytext());}
"inline" {return new Symbol(sym.Inline, yychar, yyline,yytext());}
"int" {return new Symbol(sym.Int, yychar, yyline,yytext());}
"label" {return new Symbol(sym.Label, yychar, yyline,yytext());}
"longint" {return new Symbol(sym.Longint, yychar, yyline,yytext());}
"nil" {return new Symbol(sym.Nil, yychar, yyline,yytext());}
"of" {return new Symbol(sym.Of, yychar, yyline,yytext());}
"packed" {return new Symbol(sym.Packed, yychar, yyline,yytext());}
"procedure" {return new Symbol(sym.Procedure, yychar, yyline,yytext());}
"program" {return new Symbol(sym.Program, yychar, yyline,yytext());}
"read" {return new Symbol(sym.Read, yychar, yyline,yytext());}
"real" {return new Symbol(sym.Real, yychar, yyline,yytext());}
"record" {return new Symbol(sym.Record, yychar, yyline,yytext());}
"repeat" {return new Symbol(sym.Repeat, yychar, yyline,yytext());}
"set" {return new Symbol(sym.Set, yychar, yyline,yytext());}
"shortint" {return new Symbol(sym.Shortint, yychar, yyline,yytext());}
"string" {return new Symbol(sym.String, yychar, yyline,yytext());}
"then" {return new Symbol(sym.Then, yychar, yyline,yytext());}
"to" {return new Symbol(sym.To, yychar, yyline,yytext());}
"true" {return new Symbol(sym.True, yychar, yyline,yytext());}
"type" {return new Symbol(sym.Type, yychar, yyline,yytext());}
"until" {return new Symbol(sym.Until, yychar, yyline,yytext());}
"var" {return new Symbol(sym.Var, yychar, yyline,yytext());}
"while" {return new Symbol(sym.While, yychar, yyline,yytext());}
"with" {return new Symbol(sym.With, yychar, yyline,yytext());}
"write" {return new Symbol(sym.Write, yychar, yyline,yytext());}

// Definicion de ignorar espacios en blanco y comentarios

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
("\(\*" [^]* "\*\)") {/*Ignore*/}
("\{" [^]* "\}") {/*Ignore*/}

// Definicion de operadores


"," {return new Symbol(sym.Coma, yychar, yyline,yytext());}
";" {return new Symbol(sym.PuntoComa, yychar, yyline,yytext());}
"\+\+" {return new Symbol(sym.SumaDoble, yychar, yyline,yytext());}
"--" {return new Symbol(sym.RestaDoble, yychar, yyline,yytext());}
">=" {return new Symbol(sym.MayorIgual, yychar, yyline,yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline,yytext());}
"<=" {return new Symbol(sym.MenorIgual, yychar, yyline,yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline,yytext());}
"<>" {return new Symbol(sym.Puntas, yychar, yyline,yytext());}
"=" {return new Symbol(sym.Igual, yychar, yyline,yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline,yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline,yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline,yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline,yytext());}
"\(" {return new Symbol(sym.ParentesisA, yychar, yyline,yytext());}
"\)" {return new Symbol(sym.ParentesisC, yychar, yyline,yytext());}
"\[" {return new Symbol(sym.CorcheteA, yychar, yyline,yytext());}
"\]" {return new Symbol(sym.CorcheteC, yychar, yyline,yytext());}
":=" {return new Symbol(sym.PuntoIgual, yychar, yyline,yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline,yytext());}
":" {return new Symbol(sym.DosPuntos, yychar, yyline,yytext());}
"\+=" {return new Symbol(sym.SumaS, yychar, yyline,yytext());}
"-=" {return new Symbol(sym.RestaS, yychar, yyline,yytext());}
"\*=" {return new Symbol(sym.MultiplicacionS, yychar, yyline,yytext());}
"/=" {return new Symbol(sym.DivisionS, yychar, yyline,yytext());}
">>" {return new Symbol(sym.MayorDoble, yychar, yyline,yytext());}
"<<" {return new Symbol(sym.MenorDoble, yychar, yyline,yytext());}
"<<=" {return new Symbol(sym.MenorDobleIgual, yychar, yyline,yytext());}
">>=" {return new Symbol(sym.MayorDobleIgual, yychar, yyline,yytext());}

// Definicion de operadores que son palabras reservadas

"not" {return new Symbol(sym.Not, yychar, yyline,yytext());}
"or" {return new Symbol(sym.Or, yychar, yyline,yytext());}
"and" {return new Symbol(sym.And, yychar, yyline,yytext());}
"xor" {return new Symbol(sym.Xor, yychar, yyline,yytext());}
"div" {return new Symbol(sym.Div, yychar, yyline,yytext());}
"mod" {return new Symbol(sym.Mod, yychar, yyline,yytext());}

// Definicion de la regla para identificadores

{L}({L}|{D}){0,126} {return new Symbol(sym.Identificador, yychar, yyline,yytext());}

//Definicion de las reglas para literales

([1-9][0-9]*|0)("\.")[0-9]+([eE][-+]?[0-9]+) {return new Symbol(sym.Literal, yychar, yyline,yytext());}
{D}+ | ([1-9][0-9]*|0)("\.")({D}+) {return new Symbol(sym.Literal, yychar, yyline,yytext());}
("\#")[0-9]+ {return new Symbol(sym.Literal, yychar, yyline,yytext());}
\"[^\n\"]*\" {return new Symbol(sym.Literal, yychar, yyline,yytext());}

// Definicion de reglas que producen errores léxicos

({D}{L}) {lexeme=yytext(); return Error;}
((("!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+)({L}+)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(({L}+) (("!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(("\"")({L}+)(" " |{L})*) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(({L}+)((" " |{L}+)*) ("\"")) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(({D}+)("\.")) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(([1-9][0-9]*|0)("\.")([eE][-+]?)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(([1-9][0-9]*|0)("\.")([0-9]+)([eE][-+]?)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(("\.")([eE][-+]?[0-9]+)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(("\.")([0-9]+)([eE][-+]?[0-9]+)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
(("\.")([0-9]+)) {return new Symbol(sym.Error, yychar, yyline,yytext());}
 . {return new Symbol(sym.Error, yychar, yyline,yytext());}
