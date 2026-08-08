import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuiaListas {

    public static void main(String[] args) {
        List<String> correos = new ArrayList<>(List.of("outlook", "hotmail", "gmail")); // La posición de los elementos empieza respectivamente desde 0 en adelante
        System.out.println(String.join(" ", correos)); // "Desempaquetar" equivalente: unir los elementos

        // Agrega el elemento indicado al final de la lista
        correos.add("yahoo");
        System.out.println(correos);

        // Elimina elementos de la lista
        String eliminado = correos.remove(2);
        System.out.println(eliminado);
        System.out.println(correos);
        correos.remove(1); // Elimina la posición indicada
        System.out.println(correos);

        // Cantidad de elementos en la lista
        int cantidad = correos.size();
        System.out.println(cantidad);

        // Extiende la lista con otra lista
        List<String> correo2 = new ArrayList<>(List.of("yahoo", "hotmail", "gmail"));
        correos.addAll(correo2);
        System.out.println(correos);

        // Elimina la primera coincidencia de la lista
        correos.remove("yahoo");
        System.out.println(correos);

        // Inserta un elemento en la posición indicada
        correos.add(1, "CTPP");
        System.out.println(correos);

        // Indica la posición de un elemento de la lista
        int posicion = correos.indexOf("yahoo");
        System.out.println("El índice de elementos del operador de la lista es de: " + posicion);

        List<Integer> numeros = new ArrayList<>(List.of(3, 2, 1));
        System.out.println(numeros);

        // Ordena la lista
        Collections.sort(numeros);
        System.out.println(numeros);

        // Revierte la lista
        List<Integer> lista = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(lista);
        Collections.reverse(lista);
        System.out.println(lista);

        // Indica cuantas veces se repite un número
        List<Integer> otralista = new ArrayList<>(List.of(2, 5, 4, 6, 5, 7, 8, 1));
        long rep = otralista.stream().filter(x -> x == 5).count();
        System.out.println(rep);

        // Une las listas
        List<Integer> listax1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> listax2 = new ArrayList<>(List.of(4, 5, 6));
        List<Integer> listax3 = new ArrayList<>(listax1);
        listax3.addAll(listax2);

        // Quita lo que hay dentro de la lista, solo deja los corchetes
        listax3.clear();
        System.out.println(listax3);

        listax3 = new ArrayList<>(listax1);
        listax3.addAll(listax2);
        System.out.println(listax3);

        System.out.println(listax3.subList(1, Math.min(5, listax3.size()))); // Muestra solo los espacios indicados

        List<Integer> copia = new ArrayList<>(listax1); // copia real (equivalente a .copy())
        System.out.println(copia);

        List<Integer> copia2 = listax1; // misma referencia, no es una copia
        copia2.add(4);
        System.out.println(copia);
        System.out.println("Esto es una copia dos" + copia2);
        System.out.println("Esta es una copia de lista1" + listax1);
    }
}
