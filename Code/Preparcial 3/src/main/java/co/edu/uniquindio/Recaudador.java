package co.edu.uniquindio;

import java.time.LocalDate;

public class Recaudador {
    String nombre;
    String apellidos;
    String documento;
    LocalDate fechaNacimiento;
    double sueldoMensual;

    public Recaudador(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoMensual = sueldoMensual;

    }

    public String getNombreCompleto() {
        return (nombre + " " + apellidos).trim().replaceAll("\\s+", " ").toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Recaudador{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldoMensual=" + sueldoMensual +
                '}';
    }
}
