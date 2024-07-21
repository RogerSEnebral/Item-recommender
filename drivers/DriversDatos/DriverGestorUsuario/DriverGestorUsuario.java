package FONTS.CapaDeDatos.DriversDatos.DriverGestorUsuario;

import FONTS.CapaDeDatos.Gestores.GestorIO;
import FONTS.CapaDeDatos.Gestores.GestorItem;
import FONTS.CapaDeDatos.Gestores.GestorUsuario;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class DriverGestorUsuario {
    private static GestorUsuario GU;
    private static GestorIO GIO;

    public static void testConstructora() {
        GU = new GestorUsuario(new GestorItem());
        GIO = new GestorIO();
    }

    public static void testFillUsers() throws IOException {
        String datos = "../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/ratings.db.csv";

        try {
        Vector<String[]> array  = GIO.readFile(datos);
        GU.fillUsersRatings(array);
        GU.printUsersBD();

        System.out.println("Los nulls observados son del username y el password, que de momento no estan definidos.");
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
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.fillUsers, exit)");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    System.out.println("Gestor de Usuario creado");
                    break;

                case "2" :
                    testFillUsers();
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



