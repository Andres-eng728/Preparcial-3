package co.edu.uniquindio;

public class Camion extends Vehiculo {
    int numeroEjes;
    double capacidadCargaToneladas;

    public Camion(String placa, int numeroEjes, double capacidadCargaToneladas) {
        super(placa);
        this.numeroEjes = numeroEjes;
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }

    public void setCapacidadCargaToneladas(double capacidadCargaToneladas) {
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    @Override
    public double calcularPeaje() {
        double total = 7000 * numeroEjes;
        if (capacidadCargaToneladas > 10) {
            total *= 1.10;
        }
        return total;
    }

    @Override
    public String descripcion() {
        return "Camion - Placa: " + placa + ", Ejes: " + numeroEjes + ", Carga: " + capacidadCargaToneladas + " tons";
    }

    @Override
    public String tipo() {
        return "Camion";
    }

    @Override
    public String toString() {
        return "Camion{" +
                "numeroEjes=" + numeroEjes +
                ", capacidadCargaToneladas=" + capacidadCargaToneladas +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", placa='" + placa + '\'' +
                ", conductorAsignado=" + conductorAsignado +
                '}';
    }
}
