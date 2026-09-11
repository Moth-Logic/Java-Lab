package interfaz;

import Logica.Empleado;
import Logica.Vehiculo;
import java.time.LocalDate;

// Main class that demonstrates how to use the Vehiculo and Empleado classes.
// This is the "client" code — it creates objects, calls their methods,
// and shows how OOP works in practice (encapsulation, constructors, getters/setters).
public class EjemploClases {
    
    public static void main(String[] args) {
        
        // --- Part 1: Create and use a Vehiculo (Vehicle) ---
        System.out.println("DATOS DEL VEHÍCULO");
        // Create a vehicle with plate, brand, and color using the constructor.
        Vehiculo v = new Vehiculo("234567", "Toyota Yaris", "Rojo");
                
        v.ingresar();  // Record the current time as the vehicle's entry time
        
        System.out.println(v);  // Calls v.toString() automatically
        
        // Use getters to access private fields (encapsulation in action).
        System.out.println("Placa extraída: " + v.getPlaca());
        System.out.println("Color del vehículo: " + v.getColor());
        
        System.out.println("\n DATOS DEL EMPLEADO");
        
        // --- Part 2: Create and use an Empleado (Employee) ---
        try {
            // Create dates for the employee's birth and hire date.
            LocalDate nacimiento = LocalDate.of(1990, 5, 14);
            LocalDate ingreso = LocalDate.of(2018, 2, 10);
            
            // Create the employee — the constructor validates all fields.
            // If any field is invalid, it throws an Exception (caught below).
            Empleado emp = new Empleado("112340567", "Carlos Rodríguez", "San José", nacimiento, ingreso);
                        
            System.out.println(emp);  // Calls emp.toString()
                       
            // Calculate computed properties (age and tenure are calculated on demand).
            System.out.println("Edad actual: " + emp.calcularEdad() + " años.");
            System.out.println("Antigüedad en la empresa: " + emp.calcularAntiguedad() + " años.");
                        
            // Use a setter to update the address.
            emp.setDomicilio("Heredia, Centro");
            System.out.println("Domicilio actualizado a: " + emp.getDomicilio());
            
        } catch (Exception e) {
            // If the constructor threw an exception (invalid data), we catch it here.
            System.out.println("Ocurrió un error al registrar el empleado: " + e.getMessage());
        }
    }
}