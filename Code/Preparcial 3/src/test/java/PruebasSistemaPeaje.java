import co.edu.uniquindio.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class PruebasSistemaPeaje {

    @Test
    public void testCalculoPeajeCarroElectricoPublico() {
        Carro carro = new Carro("ABC123", true, true); // 10000 * 0.8 * 1.15
        double esperado = 10000 * 0.8 * 1.15;
        assertEquals(esperado, carro.calcularPeaje(), 0.01);
    }

    @Test
    public void testCalculoPeajeMotoAltoCilindraje() {
        Moto moto = new Moto("MOTO99", 300); // 5000 + 2000
        assertEquals(7000, moto.calcularPeaje(), 0.01);
    }

    @Test
    public void testCalculoPeajeCamionAltaCarga() {
        Camion camion = new Camion("CAM999", 5, 12.0); // 7000 * 5 * 1.10
        double esperado = 7000 * 5 * 1.10;
        assertEquals(esperado, camion.calcularPeaje(), 0.01);
    }

    @Test
    public void testAsignarVehiculoConductor() {
        Conductor c = new Conductor("Laura","Martinez","99919",LocalDate.of(1990, 8, 20));
        c.setNombre("Laura");
        c.setApellidos("Martinez");
        Vehiculo v = new Carro("LMA123", false, false);
        c.asignarVehiculo(v);
        assertEquals(1, c.getVehiculos().size());
        assertEquals(c, v.getConductorAsignado());
    }

    @Test
    public void testBuscarVehiculosPorTipo() {
        Conductor c = new Conductor("Ana","Gómez","654321",LocalDate.of(1990, 8, 20));
        c.asignarVehiculo(new Carro("C1", false, false));
        c.asignarVehiculo(new Moto("M1", 125));
        List<Vehiculo> carros = c.obtenerVehiculosPorTipo("Carro");
        assertEquals(1, carros.size());
        assertEquals("C1", carros.get(0).getPlaca());
    }

    @Test
    public void testBuscarRecaudadorPorNombre() {
        EstacionPeaje peaje = new EstacionPeaje();
        Recaudador r = new Recaudador("mario","lopez","999999",LocalDate.of(1975, 2, 10),2000000);

        peaje.getRecaudadores().add(r);

        Recaudador resultado = peaje.buscarRecaudador("  mario lopez ");
        assertNotNull(resultado);
        assertEquals("mario lopez", resultado.getNombreCompleto());
    }

    @Test
    public void testConductoresConCamionesAltaCarga() {
        Camion camion1 = new Camion("CAM1", 6, 15);
        Camion camion2 = new Camion("CAM2", 4, 8);

        Conductor c1 = new Conductor("Carlos","Diaz","999979",LocalDate.of(1990, 8, 20));
        c1.setNombre("Carlos");
        c1.setApellidos("Díaz");
        c1.asignarVehiculo(camion1);

        Conductor c2 = new Conductor("Jose","Ramirez","998999",LocalDate.of(1990, 8, 20));
        c2.setNombre("Jose");
        c2.setApellidos("Ramirez");
        c2.asignarVehiculo(camion2);

        EstacionPeaje peaje = new EstacionPeaje();
        List<Conductor> resultado = peaje.conductoresConCamionesDeAltaCarga(List.of(c1, c2));
        assertEquals(1, resultado.size());
        assertEquals("Carlos", resultado.get(0).getNombre());
    }

    @Test
    public void testCobroYRegistroVehiculo() {
        EstacionPeaje peaje = new EstacionPeaje();
        Carro carro = new Carro("ZZZ123", false, false);

        double valor = peaje.cobrarPeaje(carro);
        assertEquals(10000, valor, 0.01);
        assertEquals(1, carro.getNumeroPeajesPagados());
        assertEquals(10000, peaje.getValorTotalRecaudado(), 0.01);
        assertTrue(peaje.getVehiculosAtendidos().contains(carro));
    }
}
