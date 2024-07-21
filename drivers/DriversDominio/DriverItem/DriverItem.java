package FONTS.CapaDeDominio.DriversDominio.DriverItem;

import FONTS.CapaDeDominio.DomainModel.Atributo;
import FONTS.CapaDeDominio.DomainModel.Booleano;
import FONTS.CapaDeDominio.DomainModel.Doble;
import FONTS.CapaDeDominio.DomainModel.Entero;
import FONTS.CapaDeDominio.DomainModel.Item;
import FONTS.CapaDeDominio.DomainModel.Strings;
import FONTS.CapaDeDominio.DomainModel.Valoracion;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DriverItem {

    private static Item item;

    public static void testConstructora() {
        System.out.println("Escriba el id del item a crear");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            item = new Item(Integer.parseInt(datos));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetIdItem() {
        System.out.println("Escriba el nuevo id del item");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            item.setItemID(Integer.parseInt(datos));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetItemID() {
        try {
            System.out.println("ID del item: " + item.getItemID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testAddAtributo() {
        try {
            System.out.println("Escriba el nombre del atributo y su valor");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            String[] datosSeparados = datos.split(" ");
            Atributo atr = new Atributo(datosSeparados);

            System.out.println("Atributo insertado: ");
            String a = (atr.getTipo()).toString();
                switch (a) {
                    case "Booleano":
                        atr = new Booleano(datosSeparados);
                        item.addAtributo(atr);
                        System.out.println(atr.ToString());
                        break;

                    case "Doble":
                        atr = new Doble(datosSeparados);
                        item.addAtributo(atr);
                        System.out.println(atr.ToString());
                        break;

                    case "Entero":
                        atr = new Entero(datosSeparados);
                        item.addAtributo(atr);
                        System.out.println(atr.ToString());
                        break;

                    case "Strings":
                        atr = new Strings(datosSeparados);
                        item.addAtributo(atr);
                        System.out.println(atr.ToString());
                        break;

                    default:
                        break;
                }
            System.out.println();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetAtributos() {
        System.out.println("Escriba el nombre de los atributos a buscar:");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");
        try {
            List<Atributo> s = item.getAtributo(datosSeparados[0]);
            if (s.size() == 0) System.out.println("Este item no tiene atributos con este nombre.");
            else {
                for (Atributo atr : s) {
                    System.out.println(atr.ToString());
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testAddValoracion() {
        System.out.println("Escriba la puntuacion y el id del usuario");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");
        Valoracion val = new Valoracion(Integer.parseInt(datosSeparados[1]), item.getItemID(), Double.parseDouble(datosSeparados[0]));
        try {
            item.addValoracion(val);
            System.out.println("Valoracion insertada: " + item.getValoracion(val.getUserID()).getPuntuacion() + " " +
                    item.getValoracion(val.getUserID()).getUserID() + " " + item.getValoracion(val.getUserID()).getItemID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testDelValoracion() {
        System.out.println("Escriba el id del usuario que ha valorado el item");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        Valoracion val = item.getValoracion(Integer.parseInt(datos));
        try {
            item.delValoracion(val.getUserID(), 5.);
            String s = " Aun existe";
            if (!item.existsValoracion(val.getUserID())) s = " Ya no existe";
            System.out.println("La valoracion del usuario con id " + val.getUserID() + " y puntuacion " + val.getPuntuacion() + s);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testExistsValoracionUserID() {
        System.out.println("Escriba el id del usuario que ha valorado el item");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            String aux;
            int idU = Integer.parseInt(datos);
            if (item.existsValoracion(idU)) aux = " Existe";
            else aux = " No existe";
            System.out.println("La valoracion " + idU + aux);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetValoracionUserID() {
        System.out.println("Escriba el id del usuario que ha valorado el item");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();

        try {
            if(item.existsValoracion(Integer.parseInt(datos))) {
                Valoracion val = item.getValoracion(Integer.parseInt(datos));
                System.out.println("La valoracion con id de usuario " + val.getUserID() + " y id de item " + val.getItemID() +
                        " tiene una puntuacion de " + val.getPuntuacion());
            }
            else System.out.println("La valoración que buscas no existe en este usuario");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetAvgRating() {

        try {
            System.out.println("La valoracion media del item es: " + item.getAvgRating());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString() {

        try {
            String[] itemString = item.ToString();
            String[] nombres = {"ID:", "Suma Valoraciones:", "Lista atributos:", "Lista Valoraciones:"};
            int i = 0;
            int cont = 0;
            for (String s : itemString) {
                if (i < nombres.length && (cont < 3 || cont == 2 + item.getSizeAtr())) {
                    System.out.println();
                    System.out.println(nombres[i]);
                    i++;
                }
                System.out.println(s + " ");
                cont++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {

        item = new Item();
        boolean end = false;

        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructora, 2.setID, 3.getID, 4.addAtributo, 5.getAtributos, " +
                    "6.addValoracion, 7.delValoracion, 8.existsValoracion, 9.getValoracion, 10.getAvgRating, 11.itemToString) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {

                case "1" :
                    testConstructora();
                    System.out.println("Item creado: " + item.getItemID());
                    break;

                case "2" :
                    testSetIdItem();
                    System.out.println("nuevo id: " + item.getItemID());
                    break;

                case "3"   :
                    testGetItemID();
                    break;

                case "4" :
                    testAddAtributo();
                    break;

                case "5" :
                    testGetAtributos();
                    break;

                case "6" :
                    testAddValoracion();
                    break;

                case "7" :
                    testDelValoracion();
                    break;

                case "8" :
                    testExistsValoracionUserID();
                    break;

                case "9" :
                    testGetValoracionUserID();
                    break;

                case "10" :
                    testGetAvgRating();
                    break;

                case "11" :
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
