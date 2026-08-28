package Logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado {
    private String id;
    private String nombre;
    private String domicilio;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    public Empleado(String id, String nombre, String domicilio, LocalDate fechaNacimiento, LocalDate fechaIngreso) throws Exception {
        if (id == null || id.isEmpty())
            throw new Exception("Id can't be empty.");
        if (nombre == null || nombre.isEmpty())
            throw new Exception("Name can't be empty.");
        if (domicilio == null || domicilio.isEmpty())
            throw new Exception("Place can't be empty.");
        if (fechaNacimiento == null || fechaIngreso == null)
            throw new Exception("Dates can't be null.");
        if (fechaNacimiento.equals(fechaIngreso))
            throw new Exception("Both Dates can't be the same.");
        
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id == null || id.isEmpty())
            throw new Exception("Id can't be empty.");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    private Integer calcularAños(LocalDate fecha) {
        LocalDate hoy = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(fecha, hoy);
    }

    public Integer calcularEdad() {
        return calcularAños(fechaNacimiento);
    }

    public Integer calcularAntiguedad() {
        return calcularAños(fechaIngreso);
    }

    @Override
    public String toString() {
        return "Empleado(ID=" + id + ", Nombre=" + nombre + ", Domicilio=" + domicilio + ")";
    }
}