package proyecto;
/**
 *
 * @author galva
 */
import java.util.Date;

public class Carro extends Vehiculos {    

    public Carro() {
    }

    public Carro(int noEstacion, String placa, Date hrs_Date, double tarifaUso, ClaseVehiculos claseVehiculos) {
        super(noEstacion, placa, hrs_Date, tarifaUso, claseVehiculos);
    }

    public double total(double tarifaUso){
        double total = tarifaUso;
                
        return total;
        
    }
}
