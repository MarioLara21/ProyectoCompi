/* The following code was generated by JFlex 1.4.3 on 30/9/23, 18:56 */

package scanner;
import static scanner.Tokens.*;

import java.io.*;

/**
 *
 * @author Mario Lara
 * @author Andrey Sanchez
 * @author Jonnathan Villalobos
 */


class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\33\2\0\1\3\22\0\1\57\1\56\1\55\1\54"+
    "\1\56\1\56\1\56\1\0\1\34\1\36\1\35\1\42\1\3\1\43"+
    "\1\50\1\32\1\2\11\52\1\47\1\41\1\46\1\45\1\44\1\0"+
    "\1\56\4\1\1\53\25\1\1\41\1\0\1\41\1\0\1\1\1\56"+
    "\1\4\1\7\1\17\1\22\1\10\1\24\1\11\1\21\1\12\1\1"+
    "\1\27\1\15\1\30\1\13\1\14\1\26\1\1\1\5\1\20\1\16"+
    "\1\25\1\31\1\23\1\51\1\6\1\1\1\37\1\0\1\40\1\56"+
    "\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\23\2\4\5\1\1"+
    "\6\5\1\2\1\3\3\1\1\2\2\6\1\0\1\6"+
    "\1\3\1\6\11\2\2\7\2\2\1\10\12\2\1\7"+
    "\13\2\1\4\3\0\1\4\1\5\1\6\1\0\1\2"+
    "\1\3\1\0\1\6\1\3\1\2\1\3\1\6\21\2"+
    "\1\7\4\2\1\0\1\6\1\0\1\2\1\6\15\2"+
    "\1\4\1\2\1\6\204\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[274];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0"+
    "\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420\0\u0450"+
    "\0\u0480\0\u04b0\0\u04e0\0\60\0\u0510\0\u0540\0\u0570\0\u05a0"+
    "\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690\0\u06c0\0\u06f0\0\u0720"+
    "\0\u0750\0\u0780\0\60\0\u07b0\0\u07e0\0\u0810\0\u0840\0\u0870"+
    "\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0"+
    "\0\u0a20\0\140\0\u0a50\0\u0a80\0\140\0\u0ab0\0\u0ae0\0\u0b10"+
    "\0\u0b40\0\u0b70\0\u0ba0\0\u0bd0\0\u0c00\0\u0c30\0\u0c60\0\u0c90"+
    "\0\u0cc0\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\u0db0\0\u0de0\0\u0e10"+
    "\0\u0e40\0\u0e70\0\u0ea0\0\u0ed0\0\u0f00\0\u0720\0\u0510\0\u0510"+
    "\0\u0720\0\u0630\0\u0f30\0\u0f60\0\u0f90\0\u0fc0\0\u0ff0\0\60"+
    "\0\u1020\0\u1050\0\u1080\0\u10b0\0\u10e0\0\u1110\0\u1140\0\u1170"+
    "\0\u11a0\0\u11d0\0\u1200\0\u1230\0\u1260\0\u1290\0\u12c0\0\u12f0"+
    "\0\u1320\0\u1350\0\u1380\0\u13b0\0\u13e0\0\u1410\0\u1440\0\u1470"+
    "\0\u14a0\0\u14d0\0\u1500\0\u1500\0\u1530\0\u1560\0\u1590\0\u15c0"+
    "\0\u15f0\0\u1620\0\u1650\0\u1680\0\u16b0\0\u16e0\0\u1710\0\u1740"+
    "\0\u1770\0\u17a0\0\u17d0\0\u0f00\0\u1800\0\u0f90\0\u1830\0\u1860"+
    "\0\u1890\0\u18c0\0\u18f0\0\u1920\0\u1950\0\u1980\0\u19b0\0\u19e0"+
    "\0\u1a10\0\u1a40\0\u1a70\0\u1aa0\0\u1ad0\0\u1b00\0\u1b30\0\u1b60"+
    "\0\u1b90\0\u1bc0\0\u1bf0\0\u1c20\0\u1c50\0\u1c80\0\u1cb0\0\u1ce0"+
    "\0\u1d10\0\u1d40\0\u1d70\0\u1da0\0\u1dd0\0\u1e00\0\u1e30\0\u1e60"+
    "\0\u1e90\0\u1ec0\0\u1ef0\0\u1f20\0\u1f50\0\u1f80\0\u1fb0\0\u1fe0"+
    "\0\u2010\0\u2040\0\u2070\0\u20a0\0\u20d0\0\u2100\0\u2130\0\u2160"+
    "\0\u2190\0\u21c0\0\u21f0\0\u2220\0\u2250\0\u2280\0\u22b0\0\u22e0"+
    "\0\u2310\0\u2340\0\u2370\0\u23a0\0\u23d0\0\u2400\0\u2430\0\u2460"+
    "\0\u2490\0\u24c0\0\u24f0\0\u2520\0\u2550\0\u2580\0\u25b0\0\u25e0"+
    "\0\u2610\0\u2640\0\u2670\0\u26a0\0\u26d0\0\u2700\0\u2730\0\u2760"+
    "\0\u2790\0\u27c0\0\u27f0\0\u2820\0\u2850\0\u2880\0\u28b0\0\u28e0"+
    "\0\u2910\0\u2940\0\u2970\0\u29a0\0\u29d0\0\u2a00\0\u2a30\0\u2a60"+
    "\0\u2a90\0\u2ac0\0\u2af0\0\u2b20\0\u2b50\0\u2b80\0\u2bb0\0\u2be0"+
    "\0\u2c10\0\u2c40\0\u2c70\0\u2ca0\0\u2cd0\0\u2d00\0\u2d30\0\u2d60"+
    "\0\u2d90\0\u2dc0\0\u2df0\0\u2e20\0\u2e50\0\u2e80\0\u2eb0\0\u2ee0"+
    "\0\u2f10\0\u2f40\0\u2f70\0\u2fa0\0\u2fd0\0\u3000\0\u3030\0\u3060"+
    "\0\u3090\0\u30c0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[274];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\3\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\3\1\22\1\23\1\24\1\25\1\26\1\3"+
    "\1\27\1\30\1\31\1\5\1\32\1\33\1\34\1\35"+
    "\1\2\1\34\1\36\1\37\1\40\1\34\1\41\1\42"+
    "\1\43\1\44\1\45\1\3\1\46\1\47\1\50\1\5"+
    "\61\0\1\3\1\51\1\0\26\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\55\1\56\1\0\26\55\16\0\1\57"+
    "\1\55\1\56\1\55\7\0\1\5\27\0\1\5\23\0"+
    "\1\5\1\0\1\3\1\51\1\0\1\3\1\60\5\3"+
    "\1\61\16\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\4\3\1\62\21\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\2\3\1\63\1\3"+
    "\1\64\3\3\1\65\15\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\7\3\1\66\1\3\1\67"+
    "\14\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\10\3\1\70\15\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\7\3\1\71\10\3\1\72"+
    "\5\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\6\3\1\73\1\3\1\74\15\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\1\3\1\75"+
    "\16\3\1\72\5\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\1\76\7\3\1\77\15\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\1\3"+
    "\1\100\1\101\5\3\1\72\4\3\1\102\10\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\1\67"+
    "\7\3\1\103\4\3\1\30\10\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\4\3\1\104\5\3"+
    "\1\105\2\3\1\106\10\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\6\3\1\107\1\3\1\110"+
    "\15\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\1\3\1\111\4\3\1\112\6\3\1\113\10\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\1\114\5\3\1\115\1\3\1\116\10\3\1\117\4\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\7\3\1\120\16\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\1\121\1\122\24\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\10\3\1\61"+
    "\15\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\1\123\25\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\32\0"+
    "\1\124\12\0\1\34\47\0\1\125\23\0\1\55\2\0"+
    "\26\55\3\0\1\126\4\0\2\126\1\0\1\34\3\0"+
    "\1\55\1\0\1\55\1\126\1\0\1\126\1\0\40\127"+
    "\1\130\17\127\1\0\1\55\2\0\26\55\3\0\1\126"+
    "\4\0\1\131\1\126\1\0\1\34\3\0\1\55\1\0"+
    "\1\55\1\126\1\0\1\126\2\0\1\55\2\0\26\55"+
    "\3\0\1\126\4\0\1\126\1\131\1\0\1\34\3\0"+
    "\1\55\1\0\1\55\1\126\1\0\1\126\45\0\1\42"+
    "\1\34\56\0\2\34\1\42\56\0\1\34\14\0\1\132"+
    "\5\0\1\133\41\0\1\132\1\133\5\0\1\3\1\51"+
    "\1\0\10\3\1\134\15\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\55\1\45\1\0\26\55\16\0\1\57\1\55"+
    "\1\45\1\55\5\0\1\55\1\135\1\0\26\55\3\0"+
    "\1\126\4\0\2\126\5\0\1\55\1\135\1\55\1\126"+
    "\1\0\1\126\1\0\1\136\1\137\2\136\26\137\1\136"+
    "\1\0\15\136\1\137\1\136\1\137\1\136\1\140\2\136"+
    "\1\0\1\55\2\0\26\55\3\0\1\126\4\0\2\126"+
    "\5\0\1\55\1\0\1\55\1\126\1\0\1\126\2\0"+
    "\1\141\1\51\1\0\26\141\17\0\1\141\1\51\1\141"+
    "\41\0\1\52\4\0\2\52\10\0\1\52\1\0\1\52"+
    "\2\0\1\54\2\0\26\54\17\0\1\54\1\0\1\54"+
    "\1\0\1\53\1\0\1\54\1\0\1\55\2\0\26\55"+
    "\17\0\1\55\1\0\1\55\5\0\1\55\1\56\1\0"+
    "\26\55\16\0\1\53\1\55\1\56\1\55\6\0\1\142"+
    "\5\0\1\143\41\0\1\142\1\143\5\0\1\3\1\51"+
    "\1\0\1\3\1\144\24\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\16\3\1\75\7\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\1\145"+
    "\12\3\1\146\6\3\1\147\3\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\12\3\1\150\13\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\5\3\1\151\20\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\10\3\1\152\15\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\16\3\1\72"+
    "\7\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\14\3\1\150\11\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\12\3\1\153\13\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\11\3"+
    "\1\154\1\72\13\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\11\3\1\72\14\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\12\3\1\75"+
    "\13\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\3\3\1\155\22\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\7\3\1\156\16\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\21\3"+
    "\1\150\4\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\22\3\1\150\3\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\4\3\1\157\21\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\7\3\1\160\16\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\12\3\1\72\13\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\1\3\1\161"+
    "\24\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\10\3\1\162\15\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\25\3\1\75\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\17\3\1\163"+
    "\6\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\6\3\1\63\17\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\12\3\1\164\13\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\6\3"+
    "\1\115\17\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\11\3\1\67\14\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\11\3\1\150\14\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\1\3\1\165\24\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\7\3\1\166\16\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\12\3\1\167"+
    "\13\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\13\3\1\170\12\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\10\3\1\171\15\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\1\3"+
    "\1\72\24\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\33\124\1\0"+
    "\24\124\35\125\1\172\22\125\2\0\1\173\37\0\2\174"+
    "\6\0\1\173\6\0\1\3\1\51\1\0\1\3\1\75"+
    "\24\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\2\0\1\135\47\0"+
    "\1\135\5\0\33\136\1\0\21\136\1\140\3\136\1\137"+
    "\2\136\26\137\1\136\1\0\15\136\1\137\1\136\1\137"+
    "\1\136\1\140\1\136\1\137\1\0\1\141\1\175\1\0"+
    "\26\141\17\0\1\141\1\175\1\141\6\0\1\142\5\0"+
    "\1\176\41\0\1\142\1\176\46\0\2\53\15\0\1\3"+
    "\1\51\1\0\1\177\25\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\11\3\1\72\4\3\1\72"+
    "\7\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\10\3\1\200\15\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\4\3\1\201\21\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\4\3"+
    "\1\72\21\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\6\3\1\157\17\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\11\3\1\202\14\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\10\3\1\72\15\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\6\3\1\203\17\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\4\3\1\73"+
    "\21\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\5\3\1\204\20\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\7\3\1\72\16\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\14\3"+
    "\1\104\11\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\6\3\1\205\17\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\1\3\1\206\24\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\7\3\1\70\16\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\15\3\1\72\10\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\17\3\1\207"+
    "\6\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\13\3\1\210\12\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\6\3\1\73\17\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\23\3"+
    "\1\211\2\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\5\3\1\212\5\3\1\213\12\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\35\125\1\172\1\214\21\125\2\0"+
    "\1\173\47\0\1\173\6\0\1\215\1\175\1\0\26\215"+
    "\17\0\1\215\1\175\1\215\6\0\1\135\37\0\2\216"+
    "\6\0\1\135\6\0\1\3\1\51\1\0\2\3\1\72"+
    "\23\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\1\3\1\66\24\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\1\104\25\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\4\3\1\217"+
    "\21\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\7\3\1\150\16\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\6\3\1\220\17\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\7\3"+
    "\1\221\16\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\12\3\1\204\13\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\1\200\25\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\12\3"+
    "\1\222\13\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\3"+
    "\1\51\1\0\4\3\1\66\21\3\3\0\1\52\4\0"+
    "\2\52\5\0\1\3\1\51\1\3\1\52\1\53\1\52"+
    "\1\54\1\0\1\3\1\51\1\0\1\3\1\223\24\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\4\3\1\224\21\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\215\1\225\1\0\26\215\17\0\1\215\1\225\1\215"+
    "\5\0\1\3\1\51\1\0\1\157\25\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\3\1\51\1\0\7\3\1\104"+
    "\16\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\5\3\1\72\20\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\3\1\51\1\0\6\3\1\226\17\3\3\0"+
    "\1\52\4\0\2\52\5\0\1\3\1\51\1\3\1\52"+
    "\1\53\1\52\1\54\1\0\1\3\1\51\1\0\1\227"+
    "\25\3\3\0\1\52\4\0\2\52\5\0\1\3\1\51"+
    "\1\3\1\52\1\53\1\52\1\54\1\0\1\3\1\51"+
    "\1\0\16\3\1\230\7\3\3\0\1\52\4\0\2\52"+
    "\5\0\1\3\1\51\1\3\1\52\1\53\1\52\1\54"+
    "\1\0\1\231\1\225\1\0\26\231\17\0\1\231\1\225"+
    "\1\231\5\0\1\3\1\51\1\0\10\3\1\157\15\3"+
    "\3\0\1\52\4\0\2\52\5\0\1\3\1\51\1\3"+
    "\1\52\1\53\1\52\1\54\1\0\1\3\1\51\1\0"+
    "\24\3\1\72\1\3\3\0\1\52\4\0\2\52\5\0"+
    "\1\3\1\51\1\3\1\52\1\53\1\52\1\54\1\0"+
    "\1\3\1\51\1\0\21\3\1\232\4\3\3\0\1\52"+
    "\4\0\2\52\5\0\1\3\1\51\1\3\1\52\1\53"+
    "\1\52\1\54\1\0\1\231\1\233\1\0\26\231\17\0"+
    "\1\231\1\233\1\231\5\0\1\3\1\51\1\0\1\3"+
    "\1\150\24\3\3\0\1\52\4\0\2\52\5\0\1\3"+
    "\1\51\1\3\1\52\1\53\1\52\1\54\1\0\1\234"+
    "\1\233\1\0\26\234\17\0\1\234\1\233\1\234\5\0"+
    "\1\234\1\235\1\0\26\234\17\0\1\234\1\235\1\234"+
    "\5\0\1\236\1\235\1\0\26\236\17\0\1\236\1\235"+
    "\1\236\5\0\1\236\1\237\1\0\26\236\17\0\1\236"+
    "\1\237\1\236\5\0\1\240\1\237\1\0\26\240\17\0"+
    "\1\240\1\237\1\240\5\0\1\240\1\241\1\0\26\240"+
    "\17\0\1\240\1\241\1\240\5\0\1\242\1\241\1\0"+
    "\26\242\17\0\1\242\1\241\1\242\5\0\1\242\1\243"+
    "\1\0\26\242\17\0\1\242\1\243\1\242\5\0\1\244"+
    "\1\243\1\0\26\244\17\0\1\244\1\243\1\244\5\0"+
    "\1\244\1\245\1\0\26\244\17\0\1\244\1\245\1\244"+
    "\5\0\1\246\1\245\1\0\26\246\17\0\1\246\1\245"+
    "\1\246\5\0\1\246\1\247\1\0\26\246\17\0\1\246"+
    "\1\247\1\246\5\0\1\250\1\247\1\0\26\250\17\0"+
    "\1\250\1\247\1\250\5\0\1\250\1\251\1\0\26\250"+
    "\17\0\1\250\1\251\1\250\5\0\1\252\1\251\1\0"+
    "\26\252\17\0\1\252\1\251\1\252\5\0\1\252\1\253"+
    "\1\0\26\252\17\0\1\252\1\253\1\252\5\0\1\254"+
    "\1\253\1\0\26\254\17\0\1\254\1\253\1\254\5\0"+
    "\1\254\1\255\1\0\26\254\17\0\1\254\1\255\1\254"+
    "\5\0\1\256\1\255\1\0\26\256\17\0\1\256\1\255"+
    "\1\256\5\0\1\256\1\257\1\0\26\256\17\0\1\256"+
    "\1\257\1\256\5\0\1\260\1\257\1\0\26\260\17\0"+
    "\1\260\1\257\1\260\5\0\1\260\1\261\1\0\26\260"+
    "\17\0\1\260\1\261\1\260\5\0\1\262\1\261\1\0"+
    "\26\262\17\0\1\262\1\261\1\262\5\0\1\262\1\263"+
    "\1\0\26\262\17\0\1\262\1\263\1\262\5\0\1\264"+
    "\1\263\1\0\26\264\17\0\1\264\1\263\1\264\5\0"+
    "\1\264\1\265\1\0\26\264\17\0\1\264\1\265\1\264"+
    "\5\0\1\266\1\265\1\0\26\266\17\0\1\266\1\265"+
    "\1\266\5\0\1\266\1\267\1\0\26\266\17\0\1\266"+
    "\1\267\1\266\5\0\1\270\1\267\1\0\26\270\17\0"+
    "\1\270\1\267\1\270\5\0\1\270\1\271\1\0\26\270"+
    "\17\0\1\270\1\271\1\270\5\0\1\272\1\271\1\0"+
    "\26\272\17\0\1\272\1\271\1\272\5\0\1\272\1\273"+
    "\1\0\26\272\17\0\1\272\1\273\1\272\5\0\1\274"+
    "\1\273\1\0\26\274\17\0\1\274\1\273\1\274\5\0"+
    "\1\274\1\275\1\0\26\274\17\0\1\274\1\275\1\274"+
    "\5\0\1\276\1\275\1\0\26\276\17\0\1\276\1\275"+
    "\1\276\5\0\1\276\1\277\1\0\26\276\17\0\1\276"+
    "\1\277\1\276\5\0\1\300\1\277\1\0\26\300\17\0"+
    "\1\300\1\277\1\300\5\0\1\300\1\301\1\0\26\300"+
    "\17\0\1\300\1\301\1\300\5\0\1\302\1\301\1\0"+
    "\26\302\17\0\1\302\1\301\1\302\5\0\1\302\1\303"+
    "\1\0\26\302\17\0\1\302\1\303\1\302\5\0\1\304"+
    "\1\303\1\0\26\304\17\0\1\304\1\303\1\304\5\0"+
    "\1\304\1\305\1\0\26\304\17\0\1\304\1\305\1\304"+
    "\5\0\1\306\1\305\1\0\26\306\17\0\1\306\1\305"+
    "\1\306\5\0\1\306\1\307\1\0\26\306\17\0\1\306"+
    "\1\307\1\306\5\0\1\310\1\307\1\0\26\310\17\0"+
    "\1\310\1\307\1\310\5\0\1\310\1\311\1\0\26\310"+
    "\17\0\1\310\1\311\1\310\5\0\1\312\1\311\1\0"+
    "\26\312\17\0\1\312\1\311\1\312\5\0\1\312\1\313"+
    "\1\0\26\312\17\0\1\312\1\313\1\312\5\0\1\314"+
    "\1\313\1\0\26\314\17\0\1\314\1\313\1\314\5\0"+
    "\1\314\1\315\1\0\26\314\17\0\1\314\1\315\1\314"+
    "\5\0\1\316\1\315\1\0\26\316\17\0\1\316\1\315"+
    "\1\316\5\0\1\316\1\317\1\0\26\316\17\0\1\316"+
    "\1\317\1\316\5\0\1\320\1\317\1\0\26\320\17\0"+
    "\1\320\1\317\1\320\5\0\1\320\1\321\1\0\26\320"+
    "\17\0\1\320\1\321\1\320\5\0\1\322\1\321\1\0"+
    "\26\322\17\0\1\322\1\321\1\322\5\0\1\322\1\323"+
    "\1\0\26\322\17\0\1\322\1\323\1\322\5\0\1\324"+
    "\1\323\1\0\26\324\17\0\1\324\1\323\1\324\5\0"+
    "\1\324\1\325\1\0\26\324\17\0\1\324\1\325\1\324"+
    "\5\0\1\326\1\325\1\0\26\326\17\0\1\326\1\325"+
    "\1\326\5\0\1\326\1\327\1\0\26\326\17\0\1\326"+
    "\1\327\1\326\5\0\1\330\1\327\1\0\26\330\17\0"+
    "\1\330\1\327\1\330\5\0\1\330\1\331\1\0\26\330"+
    "\17\0\1\330\1\331\1\330\5\0\1\332\1\331\1\0"+
    "\26\332\17\0\1\332\1\331\1\332\5\0\1\332\1\333"+
    "\1\0\26\332\17\0\1\332\1\333\1\332\5\0\1\334"+
    "\1\333\1\0\26\334\17\0\1\334\1\333\1\334\5\0"+
    "\1\334\1\335\1\0\26\334\17\0\1\334\1\335\1\334"+
    "\5\0\1\336\1\335\1\0\26\336\17\0\1\336\1\335"+
    "\1\336\5\0\1\336\1\337\1\0\26\336\17\0\1\336"+
    "\1\337\1\336\5\0\1\340\1\337\1\0\26\340\17\0"+
    "\1\340\1\337\1\340\5\0\1\340\1\341\1\0\26\340"+
    "\17\0\1\340\1\341\1\340\5\0\1\342\1\341\1\0"+
    "\26\342\17\0\1\342\1\341\1\342\5\0\1\342\1\343"+
    "\1\0\26\342\17\0\1\342\1\343\1\342\5\0\1\344"+
    "\1\343\1\0\26\344\17\0\1\344\1\343\1\344\5\0"+
    "\1\344\1\345\1\0\26\344\17\0\1\344\1\345\1\344"+
    "\5\0\1\346\1\345\1\0\26\346\17\0\1\346\1\345"+
    "\1\346\5\0\1\346\1\347\1\0\26\346\17\0\1\346"+
    "\1\347\1\346\5\0\1\350\1\347\1\0\26\350\17\0"+
    "\1\350\1\347\1\350\5\0\1\350\1\351\1\0\26\350"+
    "\17\0\1\350\1\351\1\350\5\0\1\352\1\351\1\0"+
    "\26\352\17\0\1\352\1\351\1\352\5\0\1\352\1\353"+
    "\1\0\26\352\17\0\1\352\1\353\1\352\5\0\1\354"+
    "\1\353\1\0\26\354\17\0\1\354\1\353\1\354\5\0"+
    "\1\354\1\355\1\0\26\354\17\0\1\354\1\355\1\354"+
    "\5\0\1\356\1\355\1\0\26\356\17\0\1\356\1\355"+
    "\1\356\5\0\1\356\1\357\1\0\26\356\17\0\1\356"+
    "\1\357\1\356\5\0\1\360\1\357\1\0\26\360\17\0"+
    "\1\360\1\357\1\360\5\0\1\360\1\361\1\0\26\360"+
    "\17\0\1\360\1\361\1\360\5\0\1\362\1\361\1\0"+
    "\26\362\17\0\1\362\1\361\1\362\5\0\1\362\1\363"+
    "\1\0\26\362\17\0\1\362\1\363\1\362\5\0\1\364"+
    "\1\363\1\0\26\364\17\0\1\364\1\363\1\364\5\0"+
    "\1\364\1\365\1\0\26\364\17\0\1\364\1\365\1\364"+
    "\5\0\1\366\1\365\1\0\26\366\17\0\1\366\1\365"+
    "\1\366\5\0\1\366\1\367\1\0\26\366\17\0\1\366"+
    "\1\367\1\366\5\0\1\370\1\367\1\0\26\370\17\0"+
    "\1\370\1\367\1\370\5\0\1\370\1\371\1\0\26\370"+
    "\17\0\1\370\1\371\1\370\5\0\1\372\1\371\1\0"+
    "\26\372\17\0\1\372\1\371\1\372\5\0\1\372\1\373"+
    "\1\0\26\372\17\0\1\372\1\373\1\372\5\0\1\374"+
    "\1\373\1\0\26\374\17\0\1\374\1\373\1\374\5\0"+
    "\1\374\1\375\1\0\26\374\17\0\1\374\1\375\1\374"+
    "\5\0\1\376\1\375\1\0\26\376\17\0\1\376\1\375"+
    "\1\376\5\0\1\376\1\377\1\0\26\376\17\0\1\376"+
    "\1\377\1\376\5\0\1\u0100\1\377\1\0\26\u0100\17\0"+
    "\1\u0100\1\377\1\u0100\5\0\1\u0100\1\u0101\1\0\26\u0100"+
    "\17\0\1\u0100\1\u0101\1\u0100\5\0\1\u0102\1\u0101\1\0"+
    "\26\u0102\17\0\1\u0102\1\u0101\1\u0102\5\0\1\u0102\1\u0103"+
    "\1\0\26\u0102\17\0\1\u0102\1\u0103\1\u0102\5\0\1\u0104"+
    "\1\u0103\1\0\26\u0104\17\0\1\u0104\1\u0103\1\u0104\5\0"+
    "\1\u0104\1\u0105\1\0\26\u0104\17\0\1\u0104\1\u0105\1\u0104"+
    "\5\0\1\u0106\1\u0105\1\0\26\u0106\17\0\1\u0106\1\u0105"+
    "\1\u0106\5\0\1\u0106\1\u0107\1\0\26\u0106\17\0\1\u0106"+
    "\1\u0107\1\u0106\5\0\1\u0108\1\u0107\1\0\26\u0108\17\0"+
    "\1\u0108\1\u0107\1\u0108\5\0\1\u0108\1\u0109\1\0\26\u0108"+
    "\17\0\1\u0108\1\u0109\1\u0108\5\0\1\u010a\1\u0109\1\0"+
    "\26\u010a\17\0\1\u010a\1\u0109\1\u010a\5\0\1\u010a\1\u010b"+
    "\1\0\26\u010a\17\0\1\u010a\1\u010b\1\u010a\5\0\1\u010c"+
    "\1\u010b\1\0\26\u010c\17\0\1\u010c\1\u010b\1\u010c\5\0"+
    "\1\u010c\1\u010d\1\0\26\u010c\17\0\1\u010c\1\u010d\1\u010c"+
    "\5\0\1\u010e\1\u010d\1\0\26\u010e\17\0\1\u010e\1\u010d"+
    "\1\u010e\5\0\1\u010e\1\u010f\1\0\26\u010e\17\0\1\u010e"+
    "\1\u010f\1\u010e\5\0\1\u0110\1\u010f\1\0\26\u0110\17\0"+
    "\1\u0110\1\u010f\1\u0110\5\0\1\u0110\1\u0111\1\0\26\u0110"+
    "\17\0\1\u0110\1\u0111\1\u0110\5\0\1\u0112\1\u0111\1\0"+
    "\26\u0112\17\0\1\u0112\1\u0111\1\u0112\5\0\1\u0112\2\0"+
    "\26\u0112\17\0\1\u0112\1\0\1\u0112\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12528];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\31\1\1\11\16\1\1\11\1\0\50\1"+
    "\3\0\3\1\1\0\2\1\1\0\1\1\1\11\31\1"+
    "\1\0\1\1\1\0\226\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[274];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;
    public int GetLine() { return yyline + 1; }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 142) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { /*Ignore*/
          }
        case 9: break;
        case 8: 
          { lexeme=yytext(); return OperadorReservado;
          }
        case 10: break;
        case 7: 
          { lexeme=yytext(); return Reservada;
          }
        case 11: break;
        case 5: 
          { lexeme=yytext(); return Operador;
          }
        case 12: break;
        case 2: 
          { lexeme=yytext(); return Identificador;
          }
        case 13: break;
        case 1: 
          { return Error;
          }
        case 14: break;
        case 6: 
          { lexeme=yytext(); return Error;
          }
        case 15: break;
        case 3: 
          { lexeme=yytext(); return Literal;
          }
        case 16: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
