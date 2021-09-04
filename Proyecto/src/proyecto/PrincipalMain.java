package proyecto;
/**
 *
 * @author galva
 */
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.util.Date;
import java.util.Scanner;

public class PrincipalMain {
    
    private static int contapark1=0, contapark2=0, contapark3=0;
    private static int park1=0, park2=0, park3 = 0;
    
    public static void menu(){
        System.out.println("Eliga una Opcion");
        System.out.println("1. Ingresar un Vehiculo");
        System.out.println("2. Sacar un Vehiculo");
        System.out.println("3. Salir del Programa");
    }
    
    public static void subMenu1(){
        System.out.println("Escoja el numero de la opcion que quiere realizar:");
        System.out.println("1: Ingresar Carro");
        System.out.println("2: Ingresar Moto");
        System.out.println("3: Ingresar Camion");
        System.out.println("4: Salir");
    }
    
    public static void subMenu2(){
        System.out.println("Escoja el numero de la opcion que quiere realizar:");
        System.out.println("1: Sacar Carro");
        System.out.println("2: Sacar Moto");
        System.out.println("3: Sacar Camion");
        System.out.println("4: Salir");
    }
 
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        DatosVehiculo datveh = new DatosVehiculo() {};
        
        System.out.println("Numero de estacionamientos para un Carro");
        park1 = entrada.nextInt();
        System.out.println("Numero de estacionamientos para una Moto");
        park2 = entrada.nextInt();
        System.out.println("Numero de estacionamientos para un Camion");
        park3 = entrada.nextInt();
        
        Vehiculos vehi[] = new Vehiculos[park1];
        Moto moto[] = new Moto[park2];
        Camion camion[] = new Camion[park3];
        
        int option1=0, option2=0, option3=0 ;
        
        do {
            menu();
            option1 = entrada.nextInt();
            
            switch(option1){
                
                case 1:
                    subMenu1();
                    option2 = entrada.nextInt();
                    
                    
                    switch (option2){
                        
                        case 1:
                            entrada.nextLine();
                            if (contapark1 < park1) {

                                for (contapark1 = contapark1; contapark1 < park1; contapark1++) {
                                    System.out.println("Registre la Placa de su Carro");
                                    String placa = entrada.nextLine();
                       
                                    Date fecha = new Date();
                                    
                                    System.out.println("Ingrese el tiempo(segundos) que estara en el parqueo ");
                                    double time = entrada.nextInt();                                    

                                    System.out.println("Ingrese el precio por segundo");
                                    double precio = entrada.nextDouble();

                                    double total = time*precio;

                                    Vehiculos carro1 = new Vehiculos(contapark1 + 1, placa, fecha , total, ClaseVehiculos.CARROS);
                                    vehi[contapark1] = carro1;
                                    contapark1++;
                                    datveh.ADVehiculo(carro1);
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(contapark1);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.TIMES_ROMAN, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET DE INGRESO DE CARRO:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........00 " + carro1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........0 " + carro1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es .......... " + carro1.getNoEstacion());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es........ " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La Fecha y Hora De ingreso es.... " + fecha);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio total del estacionamiento es.... " + total);
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:/Users/galva/Desktop/Tiketsyfac/Ticketcar.pdf");
                          
                                    System.out.println("Se ha generando la factura en PDF");

                                    
                                    break;
                                }

                            } else {
                                System.out.println("El total del estacionamiento esta lleno");
                            }
                            break; 
                            
                        case 2:
                            
                            if (contapark2 < park2) {

                                for (contapark2 = contapark2; contapark2 < park2; contapark2++) {
                                    entrada.nextLine();
                                    System.out.println("Registre la Placa de su Moto");
                                    String placa = entrada.nextLine();

                                    Date fecha = new Date();

                                    System.out.println("Ingrese el tiempo(segundos) que estara en el parqueo");
                                    double time = entrada.nextInt();

                                    System.out.println("Ingrese el precio por segundo");
                                    double precio = entrada.nextDouble();

                                    double total = time*precio;

                                    Vehiculos moto1 = new Vehiculos(contapark2 + 1, placa, fecha, total, ClaseVehiculos.MOTOS);
                                    vehi[contapark2] = moto1;
                                    contapark2++;

                                    datveh.ADVehiculo(moto1);
                                    
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(contapark2);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.HELVETICA, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET DE INGRESO DE MOTO:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........00 " + moto1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........0 " + moto1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es .......... " + moto1.getNoEstacion());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es........ " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La Fecha y Hora De ingreso es.... " + fecha);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio total del estacionamiento es.... " + total);
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:/Users/galva/Desktop/Tiketsyfac/Ticketmot.pdf");
                                    
                                    System.out.println("Se ha generando la factura en PDF");


                                    break;
                                }

                            } else {
                                System.out.println("El total del estacionamiento esta lleno");
                            }

                            break;
                            
                        case 3:
                            entrada.nextLine();
                            System.out.println("Un periodo equivale a 20 segundos, costo por periodo: Q15.00");
                            System.out.println("Si excede un periodo, tedra un recargo de Q5.00 por cada periodo extra");

                            if (contapark3 < park3) {

                                for (contapark3 = contapark3; contapark3 < park3; contapark3++) {

                                    System.out.println("Registre la Placa de su Camion");
                                    String placa = entrada.nextLine();

                                    Date fecha = new Date();

                                    Vehiculos camion1 = new Vehiculos(contapark3 + 1, placa, fecha , 15, ClaseVehiculos.CAMIONES);
                                    vehi[contapark3] = camion1;
                                    contapark3++;
                                    datveh.ADVehiculo(camion1);
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(contapark3);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.HELVETICA, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET DE INGRESO DE CAMION:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........00 " + camion1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es ..........0 " + camion1.getNoEstacion());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El estacionamiento asignado es .......... " + camion1.getNoEstacion());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es........ " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La Fecha y Hora De ingreso es.... " + fecha);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio total del estacionamiento es.... Q15.00");
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:/Users/galva/Desktop/Tiketsyfac/Ticketcam.pdf");
                                    
                                    System.out.println("Se ha generando la factura en PDF");
                                    
                                    break;

                                }

                            }else{
                                System.out.println("El total del estacionamiento esta lleno");
                            }
                            break;
                            
                        case 4:
                            break;
                            
                    }
                    break;
                case 2:
                    
                    subMenu2();
                    option2 = entrada.nextInt();
                    entrada.nextLine();
                    switch(option2){
                        
                        case 1:
                            System.out.println("Ingrese su placa");
                            String placa = entrada.nextLine();

                            int cont =0;                            

                            Carro carro2 = new Carro();

                            for (int x = 0; x < park2; x++) {
                                if (placa.equals(vehi[x].getPlaca())) {
                                    double Total = carro2.total(vehi[x].getTarifaUso());

                                    try {
                                        System.out.println("Digite su NIT");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.TIMES_ROMAN, 11);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("FACTURA DEL ESTACIONAMIENTO DE CARRO");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("SU NIT ES...." + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Total a Pagar....." + vehi[x].getTarifaUso());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El descuento es de: ");
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El recargo adicional es de: ");
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El total final a pagar es: " + Total);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:/Users/galva/Desktop/Tiketsyfac/FACcar.pdf");
                                        
                                        System.out.println("Se ha generando la factura en PDF");

                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    cont++;
                                    break;
                                }
                            }

                            if (cont== 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }
                            break;
                            
                        case 2:
                            int cont1 = 0;
                            
                            Moto moto2 = new Moto();
                            System.out.println("Ingrese su numero de placa");
                            placa = entrada.nextLine();
                            for (int x = 0; x < park2; x++) {
                                if (placa.equals(vehi[x].getPlaca())) {
                                    double descuento = vehi[x].getTarifaUso() * 0.10;
                                    double montoTotal = moto2.total(vehi[x].getTarifaUso());

                                    try {
                                        System.out.println("Ingrese su nit");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText(":FACTURA DE MOTO:");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El NIT para su factura es------- " + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El precio por la tarifa es------- " + moto[x].getTarifaUso());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un descuento de------- " + descuento);
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un recargo de------- 0");
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El monto a pagar es de------- " + montoTotal);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:/Users/galva/Desktop/Tiketsyfac/FACmot.pdf");
                                        
                                        System.out.println("Se ha generando el PDF");


                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    cont1++;
                                    break;
                                }

                            }

                            if (cont1 == 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }

                            break;
                            
                        case 3:
                            
                            System.out.println("Ingrese su numero de placa");
                            placa = entrada.nextLine();
                            cont = 0;
                            

                            Camion camion2 = new Camion();

                            for (int x = 0; x < park3; x++) {
                                if (placa.equals(vehi[x].getPlaca())) {
                                    double tarifa = 0;
                                    System.out.println("Cuantos periodos estuvo en el estacionamiento?");
                                    tarifa = entrada.nextDouble();
                                    double recargo = (tarifa - 1) * 5;
                                    double total = camion2.total(tarifa);

                                    try {
                                        entrada.nextLine();
                                        System.out.println("Ingrese su nit");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText(":FACTURA:");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El NIT para su factura es------- " + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El precio por la tarifa es------- " + camion[x].getTarifaUso());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un descuento de------- 0");
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un recargo de------- " + recargo);
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El monto a pagar es de------- " + total);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:/Users/galva/Desktop/Tiketsyfac/FACcaM.pdf");
                                        
                                        System.out.println("Se ha generando el PDF");


                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    cont++;
                                    break;
                                }
                            }

                            if (cont == 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }
                            break;
                            
                        case 4:
                            break;
                        
                    }
                    
                case 3:
                    break;
                
            }
        } while (option1!= 3);
        
    }
    
}
