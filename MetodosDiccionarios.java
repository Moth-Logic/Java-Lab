import java.util.LinkedHashMap;
import java.util.Map;

public class MetodosDiccionarios {

    public static void main(String[] args) {
        Map<String, Object> persona = new LinkedHashMap<>();
        persona.put("nombre", "Lorenzo");
        persona.put("edad", 30);
        persona.put("profesión", "psicólogo");

        System.out.println(persona);
        System.out.println(persona.get("nombre"));
        System.out.println(persona.get("edad"));
        System.out.println(persona.get("profesión"));

        for (String elemento : persona.keySet()) {
            System.out.println(elemento);
        }

        for (Map.Entry<String, Object> entry : persona.entrySet()) {
            System.out.println("clave:" + entry.getKey() + " valor:" + entry.getValue());
        }

        System.out.println(persona.get("edad"));

        persona.put("altura", 1.65);
        System.out.println(persona);

        persona.remove("profesión");
        System.out.println(persona);

        System.out.println(persona.containsKey("nombre"));
        System.out.println(persona.containsKey("profesión"));

        // Mañana: escribir en un archivo
    }
}
