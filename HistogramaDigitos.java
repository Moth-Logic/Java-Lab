public class HistogramaDigitos {

    /*
     * Procedimiento que a partir de un valor entero mayor o igual que cero imprime un histograma en
     * donde la magnitud de cada barra está en función de cada uno de los dígitos.
     * Entrada: Numero Entero Positivo
     * Salida: *******
     */
    public static void histograma(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Numero debe ser entero positivo.");
        }
        System.out.println(num);
        while (num > 0) {
            int numpri = num % 10;
            int numsec = numpri;
            num /= 10;
            System.out.println(numpri + ":" + "*".repeat(numsec));
        }
    }

    public static void main(String[] args) {
        histograma(123456789);
    }
}
