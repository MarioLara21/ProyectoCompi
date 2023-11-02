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
%caseless
%ignorecase

// Definición de estados

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}

%{
    public int GetLine() { return yyline + 1; }

%}

%%

// Definicion de palabras reservadas

"array" |"begin" | "boolean" | "byte" | "case" | "char" | "const" | "do" | "downto" | "else" | "end" | "false" |
"file" | "for" | "forward" | "function" | "goto" | "if" | "in" | "inline" | "int" | "label" | "longint" | "nil" |
"of" | "packed" | "procedure" | "program" | "read" | "real" | "record" | "repeat" | "set" | "shortint" | "string" | "then" |
"to" | "true" | "type" | "until" | "var" | "while" | "with" | "write" {lexeme=yytext(); return Reservada;}

// Definicion de ignorar espacios en blanco y comentarios

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
("\(\*" [^]* "\*\)") {/*Ignore*/}
("\{" [^]* "\}") {/*Ignore*/}

// Definicion de operadores

"," | ";" | "\+\+" | "--" | ">=" | ">" | "<=" | "<" | "<>" | "=" | "+" | "-" | "*" | "/" | "\(" | "\)" |
"\[" | "\]" | ":=" | "." | ":" | "\+=" | "-=" | "\*=" | "/=" | ">>" | "<<" | "<<=" |
">>=" {lexeme=yytext(); return Operador;}

// Definicion de operadores que son palabras reservadas

"not" | "or" | "and" | "xor" | "div" | "mod" {lexeme=yytext(); return OperadorReservado;}

// Definicion de la regla para identificadores

{L}({L}|{D}){125,200} {lexeme=yytext(); return Error;}
{L}({L}|{D}){1,125} {lexeme=yytext(); return Identificador;}

//Definicion de las reglas para literales

([1-9][0-9]*|0)("\.")[0-9]+([eE][-+]?[0-9]+) {lexeme=yytext(); return Literal;} 
{D}+ | ([1-9][0-9]*|0)("\.")({D}+) {lexeme=yytext(); return Literal;}
("\#")[0-9]+ {lexeme=yytext(); return Literal;}
\"[^\n\"]*\" {lexeme=yytext(); return Literal;}

// Definicion de reglas que producen errores léxicos

({D}{L}) {lexeme=yytext(); return Error;}
((("!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+)({L}+)) {lexeme=yytext(); return Error;}
(({L}+) (("!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+)) {lexeme=yytext(); return Error;}
(("\"")({L}+)(" " |{L})*) {lexeme=yytext(); return Error;}
(({L}+)((" " |{L}+)*) ("\"")) {lexeme=yytext(); return Error;}
(({D}+)("\.")) {lexeme=yytext(); return Error;}
(([1-9][0-9]*|0)("\.")([eE][-+]?)) {lexeme=yytext(); return Error;} 
(([1-9][0-9]*|0)("\.")([0-9]+)([eE][-+]?)) {lexeme=yytext(); return Error;}
(("\.")([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)) {lexeme=yytext(); return Error;}
 . {return Error;}
