package proyecto;
/**
 *
 * @author galva
 */
import java.util.Date;

public class Moto extends Vehiculos {    

    public Moto() {
    }

    public Moto(int noEstacion, String placa, Date hrs_Date, double tarifaUso, ClaseVehiculos claseVehiculos) {
        super(noEstacion, placa, hrs_Date, tarifaUso, claseVehiculos);
    }
 
    public double total (double tarifaUso){
        
        double total = tarifaUso-(tarifaUso*0.10);
                
        return total;
    }   
    
}
