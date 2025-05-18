package co.edu.uniquindio;

public class Carro extends Vehiculo {

    boolean esElectrico;
    boolean esServicioPublico;

    public Carro(String placa, boolean esElectrico, boolean esServicioPublico) {
        super(placa);
        this.esElectrico = esElectrico;
        this.esServicioPublico = esServicioPublico;
    }

    public boolean isEsElectrico() {
        return esElectrico;
    }

    public void setEsElectrico(boolean esElectrico) {
        this.esElectrico = esElectrico;
    }

    public boolean isEsServicioPublico() {
        return esServicioPublico;
    }

    public void setEsServicioPublico(boolean esServicioPublico) {
        this.esServicioPublico = esServicioPublico;
    }

    @Override
    public double calcularPeaje() {
        double base = 10000;
        if (esElectrico) base *= 0.8;
        if (esServicioPublico) base *= 1.15;
        return base;
    }

    @Override
    public String descripcion() {
        return "Carro - Placa: " + placa + ", Eléctrico: " + esElectrico + ", Servicio Público: " + esServicioPublico;
    }

    @Override
    public String tipo() {
        return "Carro";
    }

    @Override
    public String toString() {
        return "Carro{" +
                "esElectrico=" + esElectrico +
                ", esServicioPublico=" + esServicioPublico +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", placa='" + placa + '\'' +
                ", conductorAsignado=" + conductorAsignado +
                '}';
    }
}
