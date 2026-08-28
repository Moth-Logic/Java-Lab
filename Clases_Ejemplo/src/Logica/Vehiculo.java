package Logica;

import java.time.LocalDateTime; // Faltaba importar LocalDateTime

public class Vehiculo {
    private String placa;
    private String marca;
    private String color;
    private LocalDateTime ingreso;
    
    // El constructor ahora recibe 3 parámetros para que coincida con lo que envías desde main()
    public Vehiculo(String placa, String marca, String color) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

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
    
    public void ingresar() {
        this.ingreso = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Vehiculo(Placa=" + placa + ", Marca=" + marca + ", Color=" + color + ", Ingreso=" + ingreso + ")";
    }
}