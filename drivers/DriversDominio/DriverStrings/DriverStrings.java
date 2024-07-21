package FONTS.CapaDeDominio.DriversDominio.DriverStrings;

import FONTS.CapaDeDominio.DomainModel.AtrType;
import FONTS.CapaDeDominio.DomainModel.Strings;

import java.util.Scanner;

public class DriverStrings {
    private static Strings s;
    public static void testConstructora() {
        System.out.println("Escriba el nombre del atributo de tipo String y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        try {
            s = new Strings(datos);
            if (s.getTipo().equals(AtrType.Strings)) {
                System.out.println("String construido:");
                System.out.println("Nombre: " + s.getName());
                System.out.println("Tipo: " + s.getTipo());
                System.out.println("Dato: " + s.getValue());
            }
            else {
                System.out.println("El valor del string no es correcto (no se aceptan numeros, ni booleanos)");
                s = new Strings();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testsetValue() {
        System.out.println("Escriba el nuevo valor del String");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            s.setValue(datos);
            System.out.println("String modificado:");
            System.out.println("Nombre: " + s.getName());
            System.out.println("Tipo: " + s.getTipo());
            System.out.println("Dato: " + s.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetValue() {
        try {
            System.out.println("Valor del String: " + s.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testequal() {
        System.out.println("Escriba el nombre del atributo a comparar de tipo String y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        Strings comparador = new Strings(datos);
        try {
            if(s.equals(comparador)) System.out.println("Son iguales");
            else System.out.println("No son iguales");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {
        try {
            System.out.println(s.ToString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        s = new Strings();
        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setValue, 3.getValue, 4.equals, 5.StringsToString) o bien escriba exit para finalizar");
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
