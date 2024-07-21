package FONTS.CapaDeDominio.DriversDominio.DriverCtrlDominio;

import FONTS.CapaDeDominio.Controladores.CtrlDominio;
import java.io.IOException;
import java.util.Scanner;

public class DriverCtrlDominio {
    private static CtrlDominio CD;

    public static void testConstructora() {
        try {
            CD = CtrlDominio.getInstance();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testInitializeBD() {
        try {
            CD.initializeBD("../../FONTS/CapaDeDominio/DriversDominio/DriverTestsFiles");
            System.out.println("Se ha inicializado la BD correctamente");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSimulateStart() {
        try {
            CD.initializeBD("../../FONTS/CapaDeDominio/DriversDominio/DriverTestsFiles");
            CD.initializeClusters();
            CD.getOutputQueriesTest("../../FONTS/CapaDeDominio/DriversDominio/DriverTestsFiles");

            System.out.println("Las outputqueries se han escrito en el fichero: /FONTS/CapaDeDominio/DriversDominio/DriverTestsFiles/outputqueries.txt");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) throws IOException {

        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.iniBD, 3.start) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    System.out.println("CtrlDominio creado");
                    break;

                case "2" :
                    testInitializeBD();
                    break;

                case "3" :
                    testSimulateStart();
                    break;

                case "exit" :
                    end = true;
                    break;

                default :
                    System.out.println("funcion desconocida, intentalo de nuevo");
                    break;
            }
        }
    }

}
