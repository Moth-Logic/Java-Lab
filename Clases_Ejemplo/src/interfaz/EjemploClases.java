package interfaz;

import Logica.Empleado;
import Logica.Vehiculo;
import java.time.LocalDate;

public class EjemploClases {
    
    public static void main(String[] args) {
        
        
        System.out.println("DATOS DEL VEHÍCULO");
        Vehiculo v = new Vehiculo("234567", "Toyota Yaris", "Rojo");
                
        v.ingresar();         
        
        System.out.println(v); 
        
        System.out.println("Placa extraída: " + v.getPlaca());
        System.out.println("Color del vehículo: " + v.getColor());
        
        System.out.println("\n DATOS DEL EMPLEADO");
        
        try {
            
            LocalDate nacimiento = LocalDate.of(1990, 5, 14);
            LocalDate ingreso = LocalDate.of(2018, 2, 10);
            
            Empleado emp = new Empleado("112340567", "Carlos Rodríguez", "San José", nacimiento, ingreso);
                        
            System.out.println(emp);
                       
            System.out.println("Edad actual: " + emp.calcularEdad() + " años.");
            System.out.println("Antigüedad en la empresa: " + emp.calcularAntiguedad() + " años.");
                        
            emp.setDomicilio("Heredia, Centro");
            System.out.println("Domicilio actualizado a: " + emp.getDomicilio());
            
        } catch (Exception e) {
            
            System.out.println("Ocurrió un error al registrar el empleado: " + e.getMessage());
        }
    }
}