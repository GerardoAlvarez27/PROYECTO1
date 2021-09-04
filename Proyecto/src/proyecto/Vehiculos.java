package proyecto;
/**
 *
 * @author galva
 */
import java.util.Date;

public class Vehiculos extends DatosVehiculo {
    
    private int noEstacion;
    private String placa;
    private ClaseVehiculos claseVehiculos;
    private Date hrs_Date;
    private double tarifaUso;

    public Vehiculos() {
    }

    public Vehiculos(int noEstacion, String placa, Date hrs_Date, double tarifaUso, ClaseVehiculos claseVehiculos) {
        this.noEstacion = noEstacion;
        this.placa = placa;
        this.hrs_Date = hrs_Date;
        this.tarifaUso = tarifaUso;
        this.claseVehiculos = claseVehiculos;
    }

    public int getNoEstacion() {
        return noEstacion;
    }

    public String getPlaca() {
        return placa;
    }

    public Date gethrs_Date() {
        return hrs_Date;
    }

    public double getTarifaUso() {
        return tarifaUso;
    }

    public ClaseVehiculos getClaseVehiculos() {
        return claseVehiculos;
    }

    public String toString() {
        return "Vehiculo{" + "Numero de Estacionamiento= " + noEstacion + ", "
                + "Placa= " + placa + ", Hora y Fecha= " + hrs_Date + ","
                + " Tarifa de Uso= " + tarifaUso + ", Tipo del Vehiculo= " + claseVehiculos + '}';
    }
}