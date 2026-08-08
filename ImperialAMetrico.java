import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImperialAMetrico {

    public static double[] convertirImperial(String unidad, double valor) {
        // Factores de conversión a centímetros
        Map<String, Double> conversiones = new HashMap<>();
        conversiones.put("in", 2.54);
        conversiones.put("ft", 30.48);
        conversiones.put("yd", 91.44);
        conversiones.put("mi", 160934.0);
        conversiones.put("nm", 185200.0);

        if (!conversiones.containsKey(unidad)) {
            return null; // Equivalente a "Error: unidad no válida"
        }

        // Convertir a centímetros
        double cm = valor * conversiones.get(unidad);

        // Convertir a metros y kilómetros
        double m = cm / 100;
        double km = cm / 100000;

        return new double[] { cm, m, km };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la unidad (in, ft, yd, mi, nm): ");
        String unidad = sc.nextLine().trim().toLowerCase();
        System.out.print("Ingrese el valor a convertir: ");
        double valor = Double.parseDouble(sc.nextLine().trim());

        double[] resultado = convertirImperial(unidad, valor);

        if (resultado == null) {
            System.out.println("Error: unidad no válida");
        } else {
            System.out.println("Centímetros: " + resultado[0]);
            System.out.println("Metros: " + resultado[1]);
            System.out.println("Kilómetros: " + resultado[2]);
        }

        sc.close();
    }
}
