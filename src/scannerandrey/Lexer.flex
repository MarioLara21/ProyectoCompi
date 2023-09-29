package scannerandrey;
import static scannerandrey.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
array | 
begin | 
boolena | 
byte | 
case | 
char | 
const | 
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
nil | 
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
write {lexeme=yytext(); return Reservada;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/} 
("{".*"}") {/*Ignore*/} 
("(*".*"*)") {/*Ignore*/}
"," | 
";" | 
"++" | 
"--" | 
">=" | 
">" | 
"<=" | 
"<" | 
"<>" | 
"=" | 
"+" | 
"-" | 
"*" | 
"/" | 
"(" | 
")" |
"[" | 
"]" | 
":=" | 
"." | 
":" | 
"+=" | 
"-=" | 
"*=" | 
"/=" | 
">>" | 
"<<" | 
"<<=" | 
">>=" {return Operador;}
not | 
or | 
and | 
xor | 
div | 
mod {lexeme=yytext(); return OperadorReservado;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("-"{D}+)| 
{D}+ | 
({D}+"."{D}+) | 
("-"{D}+"."{D}+) | 
(""".*""") | 
"#"{D}+ {lexeme=yytext(); return Literal;}
 . {return Error;}
