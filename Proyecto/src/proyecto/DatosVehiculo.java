package proyecto;
import java.util.ArrayList;
/**
 *
 * @author galva
 */
public abstract class DatosVehiculo {
    private ArrayList<Vehiculos> vehiculos;

    public DatosVehiculo() {
        this.vehiculos = new ArrayList<>();
    }

    public void ADVehiculo(Vehiculos p) {
        this.vehiculos.add(p);
    }
}