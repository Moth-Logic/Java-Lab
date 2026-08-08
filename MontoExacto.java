import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MontoExacto {

    public static class Denominacion {
        int valor;
        int cantidad;

        Denominacion(int valor, int cantidad) {
            this.valor = valor;
            this.cantidad = cantidad;
        }
    }

    public static List<Denominacion> montoExacto(int monto, int[] sobranteOut) {
        int[] denominaciones = { 50000, 20000, 10000, 5000, 2000, 1000, 500, 100, 50, 25, 10, 5 };

        List<Denominacion> resultado = new ArrayList<>();

        for (int d : denominaciones) {
            int cantidad = monto / d;
            monto = monto % d;
            resultado.add(new Denominacion(d, cantidad));
        }

        sobranteOut[0] = monto;
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el monto: ");
        int monto = Integer.parseInt(sc.nextLine().trim());

        int[] sobranteOut = new int[1];
        List<Denominacion> resultado = montoExacto(monto, sobranteOut);

        for (Denominacion den : resultado) {
            System.out.println(den.cantidad + " x " + den.valor);
        }

        System.out.println("Sobran " + sobranteOut[0] + " colones");

        sc.close();
    }
}
