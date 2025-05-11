////////////////////////////////////////////////////////////////////
// Alexandru Mitu 2101083
// Edoardo Marino 2112593
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerToRomanTest
{
    @Test
    public void test()
    {
        String[][] test = {
            {"1", "I"},
            {"2", "II"},
            {"3", "III"},
            {"4", "IV"},
            {"5", "V"},
            {"6", "VI"},
            {"10", "X"},
	    {"14", "XIV"},
            {"15", "XV"},
            {"49", "XLIX"},
            {"50", "L"},
            {"100", "C"},
            {"500", "D"},
            {"1000", "M"},
            {"9", "IX"},
            {"39", "XXXIX"},
            {"99", "XCIX"},
        };
        for (String[] s : test) {
            int numero = Integer.parseInt(s[0]);
            String valoreRomanoAtteso = s[1];

            // Output effettivo del programma
            String outputEffettivo = RomanPrinter.print(numero);

            // Output atteso, costruito mappando il valore romano atteso
            String outputAtteso = convertiAsciiArt(valoreRomanoAtteso);

            // Verifica di uguaglianza tra output effettivo e atteso
            if (!outputEffettivo.equals(outputAtteso)) {
                fail("Test fallito per il valore " + numero + " (" + valoreRomanoAtteso + ")");
            }
        }
   }
    private String convertiAsciiArt(String romanNumber) {
        String[] cifra_I = {
            " _____  ", "|_   _| ", "  | |   ", "  | |   ", " _| |_  ", "|_____| "
        };
        String[] cifra_V = {
            "__      __ ", "\\ \\    / / ", " \\ \\  / /  ", "  \\ \\/ /   ", "   \\  /    ", "    \\/     "
        };
        String[] cifra_X = {
            " __   __ ", "\\ \\ / / ", " \\ V /  ", "  > <   ", " / . \\  ", "/_/ \\_\\ "
        };
        String[] cifra_L = {
            " _       ", "| |      ", "| |      ", "| |      ", "| |____  ", "|______| "
        };
        String[] cifra_C = {
            "  _____  ", " / ____| ", "| |      ", "| |      ", "| |____  ", " \\_____| "
        };
        String[] cifra_D = {
            " _____   ", "|  __ \\  ", "| |  | | ", "| |  | | ", "| |__| | ", "|_____/  "
        };
        String[] cifra_M = {
            " __  __  ", "|  \\/  | ", "| \\  / | ", "| |\\/| | ", "| |  | | ", "|_|  |_| "
        };

        StringBuilder risultato = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < romanNumber.length(); k++) {
                switch (romanNumber.charAt(k)) {
                    case 'I':
                        risultato.append(cifra_I[i]);
                        break;
                    case 'V':
                        risultato.append(cifra_V[i]);
                        break;
                    case 'X':
                        risultato.append(cifra_X[i]);
                        break;
                    case 'L':
                        risultato.append(cifra_L[i]);
                        break;
                    case 'C':
                        risultato.append(cifra_C[i]);
                        break;
                    case 'D':
                        risultato.append(cifra_D[i]);
                        break;
                    case 'M':
                        risultato.append(cifra_M[i]);
                        break;
                    default:
                        throw new IllegalArgumentException("Carattere non valido: " + romanNumber.charAt(k));
                }
            }
            risultato.append("\n");
        }

        return risultato.toString();
    }
}
