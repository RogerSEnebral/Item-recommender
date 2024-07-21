package FONTS.CapaDeDatos.DriversDatos.DriverGestorItem;

import FONTS.CapaDeDatos.Gestores.GestorIO;
import FONTS.CapaDeDatos.Gestores.GestorItem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class DriverGestorItem {
    private static GestorItem GI;
    private static GestorIO GIO;

    public static void testConstructora() {
        GI = new GestorItem();
        GIO = new GestorIO();
    }

    public static void testFillItems(){
        String[] datos = new String[2];
        datos[0] = "../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/ratings.db.csv";
        datos[1] = "../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/items.csv";
        try {
            if (datos != null) {
                Vector<String[]> array1  = GIO.readFile(datos[0]);
                Vector<String[]> array2  = GIO.readFile(datos[1]);

                GI.fillItemsRatings(array1);
                GI.fillItemsAtributos(array2);
                GI.printItemsBD();
            }
            else {
                System.out.println("El archivo con path " + Arrays.toString(datos) + " no se ha podido leer");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main (String[] args) {

        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.fillItems) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    System.out.println("Gestor de Items creado");
                    break;

                case "2" :
                    testFillItems();
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



