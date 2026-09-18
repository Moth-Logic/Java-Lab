package logica;

import java.util.List;
import java.util.ArrayList;

public class Grupo {
    private Integer numero;
    private String sede;
    private String horario;
    private String nombreMateria;
    private List<Estudiante> estudiantes;

    public Grupo(Integer numero, String sede, String horario, String nombreMateria) throws GrupoException {
        setNumero(numero);
        setSede(sede);
        setHorario(horario);
        setNombreMateria(nombreMateria);
        this.estudiantes = new ArrayList<>();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) throws GrupoException {
        if (numero == null || numero <= 0) {
            throw new GrupoException("El número de grupo debe ser un entero positivo.");
        }
        this.numero = numero;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) throws GrupoException {
        if (sede == null || sede.trim().isEmpty()) {
            throw new GrupoException("La sede no puede estar vacía.");
        }
        this.sede = sede;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) throws GrupoException {
        if (horario == null || horario.trim().isEmpty()) {
            throw new GrupoException("El horario no puede estar vacío.");
        }
        this.horario = horario;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) throws GrupoException {
        if (nombreMateria == null || nombreMateria.trim().isEmpty()) {
            throw new GrupoException("El nombre de la materia no puede estar vacío.");
        }
        this.nombreMateria = nombreMateria;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) throws GrupoException {
        if (estudiantes == null) {
            throw new GrupoException("La lista de estudiantes no puede ser nula.");
        }
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) throws GrupoException {
        if (estudiante == null) {
            throw new GrupoException("No se puede agregar un estudiante nulo.");
        }
        this.estudiantes.add(estudiante);
    }
}