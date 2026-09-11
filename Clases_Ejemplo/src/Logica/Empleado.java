package Logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;  // For calculating years between dates

// Empleado (Employee) class — demonstrates OOP with validation and computed properties.
// Key concepts shown:
// - Constructor validation: throws Exception if any field is invalid (defensive programming)
// - Private fields + getters/setters (encapsulation)
// - Computed properties: edad (age) and antiguedad (tenure) are calculated, not stored
// - Private helper method: calcularAños() is reused by both calcularEdad() and calcularAntiguedad()
public class Empleado {
    private String id;                  // Employee ID
    private String nombre;              // Full name
    private String domicilio;           // Address/home
    private LocalDate fechaNacimiento;  // Date of birth
    private LocalDate fechaIngreso;     // Date they started working here

    // Constructor with full validation — every field is checked before accepting.
    // This is "defensive programming": reject bad data early rather than debug later.
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

    // Setter with validation: even after creation, you can't set an empty ID.
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

    // Private helper: calculates how many full years have passed since 'fecha'.
    // Used by both calcularEdad() and calcularAntiguedad() to avoid code duplication.
    private Integer calcularAños(LocalDate fecha) {
        LocalDate hoy = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(fecha, hoy);  // Count full years between dates
    }

    // Computed property: the employee's current age (not stored, calculated on demand).
    public Integer calcularEdad() {
        return calcularAños(fechaNacimiento);
    }

    // Computed property: how many years the employee has worked here.
    public Integer calcularAntiguedad() {
        return calcularAños(fechaIngreso);
    }

    @Override
    public String toString() {
        return "Empleado(ID=" + id + ", Nombre=" + nombre + ", Domicilio=" + domicilio + ")";
    }
}