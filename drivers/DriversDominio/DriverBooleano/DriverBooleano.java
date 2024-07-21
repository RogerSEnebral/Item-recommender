package FONTS.CapaDeDominio.DriversDominio.DriverBooleano;

import FONTS.CapaDeDominio.DomainModel.Booleano;

import java.util.Scanner;

public class DriverBooleano {
    private static Booleano booleano;
    public static void testConstructora() {
        System.out.println("Escriba el nombre del atributo de tipo Booleano y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        try {
            if (datos[1].equals("True") || datos[1].equals("False")) {
                booleano = new Booleano(datos);
                System.out.println("Booleano construido:");
                System.out.println("Nombre: " + booleano.getName());
                System.out.println("Tipo: " + booleano.getTipo());
                System.out.println("Dato: " + booleano.getValue());
            }
            else System.out.println("El tipo introducido no es correcto (solo aceptamos valores True o False)");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testsetValue() {
        System.out.println("escriba el nuevo valor del Booleano");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            if (datos.equals("True") || datos.equals("False")) {
                booleano.setValue(Boolean.parseBoolean(datos));
                System.out.println("Booleano modificado:");
                System.out.println("Nombre: " + booleano.getName());
                System.out.println("Tipo: " + booleano.getTipo());
                System.out.println("Dato: " + booleano.getValue());
            }
            else System.out.println("El tipo introducido no es correcto (solo aceptamos valores True o False)");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetBooleanValue() {
        try {
            System.out.println("Valor del booleano: " + booleano.getValue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testequal() {
        System.out.println("Escriba el nombre del atributo a comparar de tipo Booleano y su valor");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String datos[] = nom.split(" ");
        Booleano comparador = new Booleano(datos);
        try {
            if(booleano.equals(comparador)) System.out.println("Son iguales");
            else System.out.println("No son iguales");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {
        try {
            System.out.println(booleano.ToString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        booleano = new Booleano();
        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setValue, 3.getValue, 4.equals, 5.BooleanToString) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    break;
                case "2" :
                    testsetValue();
                    break;
                case "3" :
                    testgetBooleanValue();
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
                    System.out.println("Numero de funcion desconocido, intentalo de nuevo");
                    break;
            }
        }
    }
}
