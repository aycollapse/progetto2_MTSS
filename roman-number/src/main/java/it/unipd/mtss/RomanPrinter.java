////////////////////////////////////////////////////////////////////
// Alexandru Mitu 2101083
// Edoardo Marino 2112593
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

public class RomanPrinter
{
    public static String print(int num)
    {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber)
    {
        // Definizione asciiArt per ogni lettera
        String[] cifra_I = {
            " _____  ",
            "|_   _| ",
            "  | |   ",
            "  | |   ",
            " _| |_  ",
            "|_____| "
        };
        String[] cifra_V = {
            "__      __ ",
            "\\ \\    / / ",
            " \\ \\  / /  ",
            "  \\ \\/ /   ",
            "   \\  /    ",
            "    \\/     "
        };
        String[] cifra_X = {
            " __   __ ",
            "\\ \\ / / ",
            " \\ V /  ",
            "  > <   ",
            " / . \\  ",
            "/_/ \\_\\ "
        };
        String[] cifra_L = {
            " _       ",
            "| |      ",
            "| |      ",
            "| |      ",
            "| |____  ",
            "|______| "
        };
        String[] cifra_C = {
            "  _____  ",
            " / ____| ",
            "| |      ",
            "| |      ",
            "| |____  ",
            " \\_____| "
        };
        String[] cifra_D = {
            " _____   ",
            "|  __ \\  ",
            "| |  | | ",
            "| |  | | ",
            "| |__| | ",
            "|_____/  "
        };
        String[] cifra_M = {
            " __  __  ",
            "|  \\/  | ",
            "| \\  / | ",
            "| |\\/| | ",
            "| |  | | ",
            "|_|  |_| "
        };

        StringBuilder risultato = new StringBuilder();

        // Per ogni riga delle asciiArt (6 righe per simbolo)
        for(int i = 0; i < 6; i++)
        {
            for(int k = 0; k < romanNumber.length(); k++)
            {
                switch(romanNumber.charAt(k))
                {
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

