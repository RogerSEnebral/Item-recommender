package FONTS.CapaDeDatos.DriversDatos.DriverGestorIO;

import FONTS.CapaDeDatos.Gestores.GestorIO;

import java.util.Scanner;
import java.util.Vector;

public class DriverGestorIO {
    private static GestorIO GIO;

    public static void testConstructora() {
        GIO = new GestorIO();
    }

    public static void testReadFile() {
        try {
            Vector<String[]> array  = GIO.readFile("../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/ratings.db.csv");
            if (array != null) {
                for (String[] strings : array) {
                    for (String string : strings) System.out.print(string + " ");
                    System.out.println();
                }
            }
            else System.out.println("No se ha encontrado el archivo que debería estar en esta carpeta.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testWriteFile() {
        try {
            Vector<String[]> datos = GIO.readFile("../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/ratings.db.csv");
            if (datos != null) {
                String[] s = null;
                GIO.writeFile(s, "../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/testWrite.csv", datos);
                System.out.println("He escrito en la direccion: FONTS/CapaDeDatos/DriversDatos/FicherosDatos/testWrite.csv");
            }
            else {
                System.out.println("El archivo con path " + "../../FONTS/CapaDeDatos/DriversDatos/FicherosDatos/ratings.db.csv" + " no se ha podido escribir");
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
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.readFile, 3.writeFile) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    System.out.println("Gestor de Input Output creado");
                    break;

                case "2" :
                    testReadFile();
                    break;

                case "3" :
                    testWriteFile();
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