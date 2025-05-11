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
                    default:
                        throw new IllegalArgumentException("Carattere non valido: " + romanNumber.charAt(k));
                }
            }
            risultato.append("\n");
        }

        return risultato.toString();
    }
}
