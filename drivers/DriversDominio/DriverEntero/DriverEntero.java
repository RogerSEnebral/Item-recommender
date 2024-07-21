package FONTS.CapaDeDominio.DriversDominio.DriverEntero;
import FONTS.CapaDeDominio.DomainModel.Entero;

import java.util.Scanner;

public class DriverEntero {
    private static Entero entero;
    public static void testConstructora() {
        System.out.println("Escriba el nombre del atributo de tipo Entero y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        try {
            entero = new Entero(datos);
            System.out.println("Entero construido:");
            System.out.println("Nombre: " + entero.getName());
            System.out.println("Tipo: " + entero.getTipo());
            System.out.println("Dato: " + entero.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testsetValue() {
        System.out.println("Escriba el nuevo valor del Entero");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            entero.setValue(Integer.parseInt(datos));
            System.out.println("Entero modificado:");
            System.out.println("Nombre: " + entero.getName());
            System.out.println("Tipo: " + entero.getTipo());
            System.out.println("Dato: " + entero.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetValue() {
        try {
            System.out.println("Valor del Entero: " + entero.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testequal() {
        System.out.println("Escriba el nombre del atributo a comparar de tipo Entero y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        Entero comparador = new Entero(datos);
        try {
            if(entero.equals(comparador)) System.out.println("Son iguales");
            else System.out.println("No son iguales");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {
        try {
            System.out.println(entero.ToString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        entero = new Entero();
        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setValue, 3.getValue, 4.equals, 5.EnteroToString) o bien escriba exit para finalizar");
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
