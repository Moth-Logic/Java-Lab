import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorUnidadesDatos {

    public static double convertir(double valor, String origen, String destino) {
        Map<String, Double> factores = new HashMap<>();
        factores.put("B", Math.pow(2, 0));
        factores.put("K", Math.pow(2, 10));
        factores.put("M", Math.pow(2, 20));
        factores.put("G", Math.pow(2, 30));
        factores.put("T", Math.pow(2, 40));
        factores.put("P", Math.pow(2, 50));
        factores.put("E", Math.pow(2, 60));
        factores.put("Z", Math.pow(2, 70));
        factores.put("Y", Math.pow(2, 80));

        origen = origen.toUpperCase();
        destino = destino.toUpperCase();

        return valor * factores.get(origen) / factores.get(destino);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Unidad origen (B,K,M,G,T,P,E,Z,Y): ");
        String o = sc.nextLine().trim();
        System.out.print("Unidad destino (B,K,M,G,T,P,E,Z,Y): ");
        String d = sc.nextLine().trim();

        System.out.println("Resultado: " + convertir(v, o, d));

        sc.close();
    }
}
