package Logica;

import java.time.LocalDateTime;

// Vehiculo (Vehicle) class — demonstrates basic OOP concepts:
// - Private fields (encapsulation): placa, marca, color, ingreso
// - Getters and setters: controlled access to private data
// - Constructor: initializes the object when created with 'new'
// - toString(): overrides the default to print useful info
public class Vehiculo {
    private String placa;            // License plate (unique identifier)
    private String marca;            // Brand/manufacturer (e.g., "Toyota")
    private String color;            // Vehicle color
    private LocalDateTime ingreso;   // Entry timestamp (set when the vehicle enters)

    // Constructor: creates a vehicle with plate, brand, and color.
    // The 'ingreso' field is NOT set here — call ingresar() to record entry time.
    public Vehiculo(String placa, String marca, String color) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    // Getter: returns the license plate. 'private' field + public getter = encapsulation.
    public String getPlaca() {
        return placa;
    }

    // Setter: allows changing the license plate. You could add validation here.
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }

    // Record the current moment as the vehicle's entry time.
    public void ingresar() {
        this.ingreso = LocalDateTime.now();  // Capture the exact moment of entry
    }

    // toString() lets us print the vehicle with System.out.println(v).
    // Without this override, we'd get something like Vehiculo@1a2b3c4 (useless).
    @Override
    public String toString() {
        return "Vehiculo(Placa=" + placa + ", Marca=" + marca + ", Color=" + color + ", Ingreso=" + ingreso + ")";
    }
}