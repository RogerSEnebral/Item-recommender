package FONTS.CapaDeDominio.DriversDominio.DriverDoble;

import FONTS.CapaDeDominio.DomainModel.Doble;

import java.util.Scanner;

public class DriverDoble {
    private static Doble doble;
    public static void testConstructora() {
        System.out.println("Escriba el nombre del atributo de tipo Doble y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        try {
            doble = new Doble(datos);
            System.out.println("Doble construido:");
            System.out.println("Nombre: " + doble.getName());
            System.out.println("Tipo: " + doble.getTipo());
            System.out.println("Dato: " + doble.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testsetValue() {
        System.out.println("Escriba el nuevo valor del Doble");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            doble.setValue(Double.parseDouble(datos));
            System.out.println("Doble modificado:");
            System.out.println("Nombre: " + doble.getName());
            System.out.println("Tipo: " + doble.getTipo());
            System.out.println("Dato: " + doble.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetValue() {
        try {
            System.out.println("Valor del Doble: " + doble.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testequal() {
        System.out.println("Escriba el nombre del atributo a comparar de tipo Doble y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        Doble comparador = new Doble(datos);
        try {
            if(doble.equals(comparador)) System.out.println("Son iguales");
            else System.out.println("No son iguales");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {
        try {
            System.out.println(doble.ToString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        doble = new Doble();
        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setValue, 3.getValue, 4.equals, 5.DobleToString) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    break;
                case "2" :
                    testsetValue();
                    break;
                case "3" :
                    testgetValue();
                    break;
                case "4" :
                    testequal();
                    break;
                case "5" :
                    testToString();
                    break;
                case "exit" :
                    end = true;
                    break;
                default :
                    System.out.println("Numero de funcion desconocido, inténtalo de nuevo");
                    break;
            }
        }
    }
}
