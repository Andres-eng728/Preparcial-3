package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conductor {
    String nombre;
    String apellidos;
    String documento;
    LocalDate fechaNacimiento;
    List<Vehiculo> vehiculos = new ArrayList<>();

    public Conductor(String nombre, String apellidos, String documento,LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = LocalDate.now();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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

    public void asignarVehiculo(Vehiculo v) {
        v.conductorAsignado = this;
        vehiculos.add(v);
    }

    public List<Vehiculo> obtenerVehiculosPorTipo(String tipo) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.tipo().equalsIgnoreCase(tipo)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public double calcularTotalPeajes() {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.calcularPeaje() * v.numeroPeajesPagados;
        }
        return total;
    }

    public String getNombreCompleto() {
        return (nombre + " " + apellidos).trim().replaceAll("\\s+", " ").toLowerCase();
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
