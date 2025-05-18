package co.edu.uniquindio;

public class Moto extends Vehiculo {
    int cilindraje;

    public Moto(String placa, int cilindraje) {
        super(placa);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularPeaje() {
        double base = 5000;
        if (cilindraje > 200) base += 2000;
        return base;
    }

    @Override
    public String descripcion() {
        return "Moto - Placa: " + placa + ", Cilindraje: " + cilindraje;
    }

    @Override
    public String tipo() {
        return "Moto";
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindraje=" + cilindraje +
                ", conductorAsignado=" + conductorAsignado +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", placa='" + placa + '\'' +
                '}';
    }
}
