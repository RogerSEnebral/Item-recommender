package FONTS.CapaDeDominio.DriversDominio.DriverAtributo;

import FONTS.CapaDeDominio.DomainModel.AtrType;
import FONTS.CapaDeDominio.DomainModel.Atributo;
import FONTS.CapaDeDominio.DomainModel.Booleano;
import FONTS.CapaDeDominio.DomainModel.Doble;
import FONTS.CapaDeDominio.DomainModel.Entero;
import FONTS.CapaDeDominio.DomainModel.Strings;

import java.sql.SQLOutput;
import java.util.Scanner;


public class DriverAtributo {
    private static Atributo atributo;

    public static void testConstructora() {
        System.out.println("Escriba el nombre del atributo y su valor:");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String[] aux = nom.split(" ");
        atributo = new Atributo(aux);
        String a = (atributo.getTipo()).toString();
        try {
            switch (a) {
                case "Doble":
                    atributo = new Doble(aux);
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Doble)atributo).getName());
                    System.out.println("Tipo: " + ((Doble)atributo).getTipo());
                    System.out.println("Dato: " + ((Doble)atributo).getValue());
                    break;

                case "Entero":
                    atributo = new Entero(aux);
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Entero)atributo).getName());
                    System.out.println("Tipo: " + ((Entero)atributo).getTipo());
                    System.out.println("Dato: " + ((Entero)atributo).getValue());
                    break;

                case "Booleano":
                    atributo = new Booleano(aux);
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Booleano)atributo).getName());
                    System.out.println("Tipo: " + ((Booleano)atributo).getTipo());
                    System.out.println("Dato: " + ((Booleano)atributo).getValue());
                    break;

                case "Strings":
                    atributo = new Strings(aux);
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Strings)atributo).getName());
                    System.out.println("Tipo: " + ((Strings)atributo).getTipo());
                    System.out.println("Dato: " + ((Strings)atributo).getValue());
                    break;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testsetName() {
        System.out.println("Escriba el nuevo nombre del atributo");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            atributo.setName(datos);
            String a = (atributo.getTipo()).toString();
            switch (a) {
                case "Doble":
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Doble) atributo).getName());
                    System.out.println("Tipo: " + ((Doble) atributo).getTipo());
                    System.out.println("Dato: " + ((Doble) atributo).getValue());
                    break;

                case "Entero":
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Entero) atributo).getName());
                    System.out.println("Tipo: " + ((Entero) atributo).getTipo());
                    System.out.println("Dato: " + ((Entero) atributo).getValue());
                    break;

                case "Booleano":
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Booleano) atributo).getName());
                    System.out.println("Tipo: " + ((Booleano) atributo).getTipo());
                    System.out.println("Dato: " + ((Booleano) atributo).getValue());
                    break;

                case "Strings":
                    System.out.println("Atributo construido:");
                    System.out.println("Nombre: " + ((Strings) atributo).getName());
                    System.out.println("Tipo: " + ((Strings) atributo).getTipo());
                    System.out.println("Dato: " + ((Strings) atributo).getValue());
                    break;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetName() {
        try {
            System.out.println("Nombre actualizado del atributo: " + atributo.getName());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testgetTipo() {
        try {
            System.out.println("Tipo actualizado del atributo: " + atributo.getTipo());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testequals() {
        System.out.println("Escriba el nombre del atributo a comparar y su valor:");
        Scanner lector = new Scanner(System.in);
        String nom = lector.nextLine();
        String[] aux = nom.split(" ");
        Atributo comparador = new Atributo(aux);
        String a = (atributo.getTipo()).toString();
        switch (a) {
            case "Doble":
                comparador = new Doble(aux);
                break;

            case "Entero":
                comparador = new Entero(aux);
                break;

            case "Booleano":
                comparador = new Booleano(aux);
                break;

            case "Strings":
                comparador = new Strings(aux);
                break;
        }
        try {
            if(atributo.equals(comparador)) System.out.println("Son iguales");
            else System.out.println("No son iguales");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main (String[] args) {
        atributo = new Atributo();
        boolean end = false;
        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setName, 3.getName, 4.getTipo, 5.equals) o escriba exit para finalizar");
            String datos = lector.nextLine();
            switch (datos) {
                case "1" :
                    testConstructora();
                    break;
                case "2" :
                    testsetName();
                    break;
                case "3" :
                    testgetName();
                    break;
                case "4" :
                    testgetTipo();
                    break;
                case "5" :
                    testequals();
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
