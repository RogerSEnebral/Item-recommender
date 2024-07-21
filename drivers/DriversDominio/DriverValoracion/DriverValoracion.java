package FONTS.CapaDeDominio.DriversDominio.DriverValoracion;

import FONTS.CapaDeDominio.DomainModel.Valoracion;

import java.util.Scanner;

public class DriverValoracion {

    private static Valoracion valoracion;

    public static void testConstructora() {
        System.out.println("Escriba el ID de usuario, el ID del item y la puntuacion para crear la valoracion");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");

        try {
            valoracion = new Valoracion(Integer.parseInt(datosSeparados[0]), Integer.parseInt(datosSeparados[1]), Double.parseDouble(datosSeparados[2]));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testEquals() {
        System.out.println("Escriba el ID de usuario, el ID del item y la puntuacion para crear la valoracion que compararemos con la anterior");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");
        Valoracion val = new Valoracion(Integer.parseInt(datosSeparados[0]), Integer.parseInt(datosSeparados[1]), Double.parseDouble(datosSeparados[2]));

        try {
            if (val.equals(valoracion)) System.out.println("Las 2 valoraciones son iguales (tienen el mismo id de usuario y id de item)");
            else System.out.println("Las 2 valoraciones son diferentes (no tienen el mismo id de usuario y id de item)");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetPuntuacion() {
        System.out.println("Escriba la nueva puntuacion de la valoracion");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            valoracion.setPuntuacion(Double.parseDouble(datos));
            System.out.println("La nueva puntuacion es " + valoracion.getPuntuacion());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetPuntuacion() {
        try {
            System.out.println("Puntuacion: " + valoracion.getPuntuacion());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetUserID() { //la operacion delAtributo no funciona
        System.out.println("escriba el nuevo ID de usuario de la valoracion");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            valoracion.setUserID(Integer.parseInt(datos));
            System.out.println("El nuevo ID de usuario es " + valoracion.getUserID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetUserID() {
        try {
            System.out.println("ID de usuario: " + valoracion.getUserID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetItemID() {
        System.out.println("escriba el nuevo ID de item de la valoracion");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            valoracion.setItemID(Integer.parseInt(datos));
            System.out.println("El nuevo ID de item es " + valoracion.getItemID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetItemID() {
        try {
            System.out.println("ID de item: " + valoracion.getItemID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {
        try {
            System.out.println(valoracion.ToString());
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
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.equals, 3.setPuntuacion, 4.getPuntuacion, 5.setUserID, " +
                    "6.getUserID, 7.setItemID, 8.getItemID, 9.ValoracionToString) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {

                case "1" :
                    testConstructora();
                    System.out.println("Valoracion creada: " + valoracion.ToString());
                    break;

                case "2" :
                    testEquals();
                    break;

                case "3" :
                    testSetPuntuacion();
                    break;

                case "4"   :
                    testGetPuntuacion();
                    break;

                case "5" :
                    testSetUserID();
                    break;

                case "6" :
                    testGetUserID();
                    break;

                case "7" :
                    testSetItemID();
                    break;

                case "8" :
                    testGetItemID();
                    break;

                case "9" :
                    testToString();
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
