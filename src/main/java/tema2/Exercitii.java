package tema2;

public class Exercitii {
    
    public static void sumaPrimelor100Cifre() {
        int suma = 0;

        for (int i = 1; i <= 100; i++) {
            suma += i;
        }

        System.out.println("Suma primelor 100 numere este: " + suma);
    }
}
