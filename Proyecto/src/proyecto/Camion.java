package proyecto;
/**
 *
 * @author galva
 */
import java.util.Date;

public class Camion extends Vehiculos{
    
    public Camion(){
        
    }

    public Camion(int noEstacion, String placa, Date hrs_Date, double tarifaUso, ClaseVehiculos claseVehiculos) {
        super(noEstacion, placa, hrs_Date, tarifaUso, claseVehiculos);
    }
    
    public double total(double tarifaUso){
        
        double total=(10*tarifaUso)+(5*(tarifaUso-1));
        
        return total;
    }
    
}