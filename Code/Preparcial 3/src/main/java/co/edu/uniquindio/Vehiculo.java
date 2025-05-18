package co.edu.uniquindio;

public abstract class Vehiculo implements  Icalcularpeaje {
    String placa;
    int numeroPeajesPagados;
    Conductor conductorAsignado;

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public int getNumeroPeajesPagados() {
        return numeroPeajesPagados;
    }

    public void setNumeroPeajesPagados(int numeroPeajesPagados) {
        this.numeroPeajesPagados = numeroPeajesPagados;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", conductorAsignado=" + conductorAsignado +
                '}';
    }

    public abstract String descripcion();
    public abstract String tipo();




}
