////////////////////////////////////////////////////////////////////
// Alexandru Mitu 2101083
// Edoardo Marino 2112593
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;



public class IntegerToRoman
{
    public static String convert(int number)
    {
        //Controllo e validazione input.
        if(number<=0 || number>1000)
        {
            throw new IllegalArgumentException();
        }
        //Mappatura valore-simbolo
        int[] valori = {1000, 900, 500, 400, 100, 90,
                        50, 40, 10, 9, 5, 4, 1};
        String[] simboli = {"M", "CM", "D", "CD", "C","XC",
                            "L","XL","X","IX","V","IV","I"};

        StringBuilder risultato = new StringBuilder();
        //Logica di conversione
        for (int i = 0; i < valori.length; i++)
        {
            while (number >= valori[i])
            {
                number -= valori[i];
                risultato.append(simboli[i]);
            }
        }

        return risultato.toString();
    }
}
