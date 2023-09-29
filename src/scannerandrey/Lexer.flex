package scannerandrey;
import static scannerandrey.Tokens.*;

import java.io.*;


%%
%class Lexer
%type Tokens
%line

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

"array"|"begin"|"boolean"|"byte"|"case"|"char"|"const"|"do"|"downto"|"else"|"end"|"false"|
"file"|"for"|"forward"|"function"|"goto"|"if"|"in"|"inline"|"int"|"label"|"longint"|"nil"|
"of"|"packed"|"procedure"|"program"|"read"|"real"|"record"|"repeat"|"set"|"shortint"|"string"|"then"|
"to"|"true"|"type"|"until"|"var"|"while"|"with"|"write" {lexeme=yytext(); return Reservada;}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
("\(\*" [^]* "\*\)") {/*Ignore*/}
("\{" [^]* "\}") {/*Ignore*/}

"," | ";" | "\+\+" | "--" | ">=" | ">" | "<=" | "<" | "<>" | "=" | "+" | "-" | "*" | "/" | "\(" | "\)" |
"\[" | "\]" | ":=" | "." | ":" | "\+=" | "-=" | "\*=" | "/=" | ">>" | "<<" | "<<=" |
">>=" {lexeme=yytext(); return Operador;}

"not" | "or" | "and" | "xor" | "div" | "mod" {lexeme=yytext(); return OperadorReservado;}

{L}({L}|{D}){0,126} {lexeme=yytext(); return Identificador;}

([1-9][0-9]*|0)("\.")[0-9]+([eE][-+]?[0-9]+) {lexeme=yytext(); return Literal;} 
{D}+ | ([1-9][0-9]*|0)("\.")({D}+) {lexeme=yytext(); return Literal;}
("\#")[0-9]+ {lexeme=yytext(); return Literal;}
\"[^\n\"]*\" {lexeme=yytext(); return Literal;}

({D}{L}) {lexeme=yytext(); return Error;}
((("!" | "#" | "$" | "%" | "&" | "*" | "+" | "-" | "@" | "`" | "~")+)({L}+)) {lexeme=yytext(); return Error;}
(("\"")({L}+)(" " |{L})*) {lexeme=yytext(); return Error;}
(({L}+)((" " |{L}+)*) ("\"")) {lexeme=yytext(); return Error;}
(({D}+)("\.")) {lexeme=yytext(); return Error;}
(([1-9][0-9]*|0)("\.")([eE][-+]?)) {lexeme=yytext(); return Error;} 
(([1-9][0-9]*|0)("\.")([0-9]+)([eE][-+]?)) {lexeme=yytext(); return Error;}
(("\.")([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)([eE][-+]?[0-9]+)) {lexeme=yytext(); return Error;}
(("\.")([0-9]+)) {lexeme=yytext(); return Error;}
 . {return Error;}