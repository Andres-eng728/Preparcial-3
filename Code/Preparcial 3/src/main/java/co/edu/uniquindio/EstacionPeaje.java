package co.edu.uniquindio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje  {
    String nombre;
    String departamento;
    double valorTotalRecaudado = 0;
    List<Vehiculo> vehiculosAtendidos = new ArrayList<>();
    List<Recaudador> recaudadores = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }

    public void setVehiculosAtendidos(List<Vehiculo> vehiculosAtendidos) {
        this.vehiculosAtendidos = vehiculosAtendidos;
    }

    public List<Recaudador> getRecaudadores() {
        return recaudadores;
    }

    public void setRecaudadores(List<Recaudador> recaudadores) {
        this.recaudadores = recaudadores;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getValorTotalRecaudado() {
        return valorTotalRecaudado;
    }

    public void setValorTotalRecaudado(double valorTotalRecaudado) {
        this.valorTotalRecaudado = valorTotalRecaudado;
    }

    public double cobrarPeaje(Vehiculo vehiculo) {
        double valor = vehiculo.calcularPeaje();
        valorTotalRecaudado += valor;
        vehiculo.numeroPeajesPagados++;
        registrarVehiculo(vehiculo);
        return valor;
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculosAtendidos.add(vehiculo);
    }

    public void imprimirReporte() {
        for (Vehiculo v : vehiculosAtendidos) {
            System.out.println(v.descripcion());
            System.out.println("Peaje pagado: $" + v.calcularPeaje());
            System.out.println("---");
        }
        System.out.println("Total Recaudado: $" + valorTotalRecaudado);
    }

    public Recaudador buscarRecaudador(String nombreCompleto) {
        String limpio = nombreCompleto.trim().replaceAll("\\s+", " ").toLowerCase();
        for (Recaudador r : recaudadores) {
            if (r.getNombreCompleto().equals(limpio)) return r;
        }
        return null;
    }

    public List<Conductor> conductoresConCamionesDeAltaCarga(List<Conductor> conductores) {
        List<Conductor> resultado = new ArrayList<>();
        for (Conductor c : conductores) {
            for (Vehiculo v : c.vehiculos) {
                if (v instanceof Camion && ((Camion) v).capacidadCargaToneladas > 10) {
                    resultado.add(c);
                    break;
                }
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "EstacionPeaje{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", valorTotalRecaudado=" + valorTotalRecaudado +
                ", vehiculosAtendidos=" + vehiculosAtendidos +
                ", recaudadores=" + recaudadores +
                '}';
    }
}
