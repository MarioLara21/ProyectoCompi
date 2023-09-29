/*Codigo del usuario*/
package Codigo;
import static Codigo.Tokens.*;

%%  /*Opciones declaraciones y configuraciones */
%public
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%% /*Reglas lexicas*/
and |
array |
begin |
booleana |
byte |
case |
char |
const |
div |
do |
downto |
else | 
end |
false |
file |
for |
forward |
function |
goto |
if |
in |
inline |
int |
label |
longint |
mod |
nil |
not |
of |
packed |
procedure |
program |
read |
real |
record |
repeat |
set |
shortint |
string |
then |
to |
true |
type |
until |
var |
while |
with |
write |
xor |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return OperadorIgualdad;}
"+" {return OperadorSuma;}
"-" {return OperadorResta;}
"*" {return OperadorMultiplicacion;}
"/" {return OperadorDivision;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}