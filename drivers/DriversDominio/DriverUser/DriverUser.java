package FONTS.CapaDeDominio.DriversDominio.DriverUser;

import FONTS.CapaDeDominio.DomainModel.Item;
import FONTS.CapaDeDominio.DomainModel.User;
import FONTS.CapaDeDominio.DomainModel.Valoracion;

import java.util.*;

public class DriverUser {

    private static User user;

    public static void testConstructora() {
        System.out.println("Escriba el id, el nombre y el password del usuario a crear");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");

        try {
            user = new User(Integer.parseInt(datosSeparados[0]), datosSeparados[1], datosSeparados[2]);
            System.out.println("Usuario creado: " + user.getUserID() + " " + user.getUserName() + " " + user.getUserPassword());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void testSetUserID(){
        System.out.println("Escriba la nueva ID del usuario");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            user.setUserID(Integer.parseInt(datos));
            System.out.println("Nuevo ID: " + user.getUserID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetUserName(){
        System.out.println("Escriba el nuevo nombre del usuario");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            user.setUserName(datos);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetUserPassword(){
        System.out.println("Escriba la nueva password del usuario");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        try {
            user.setUserPassword(datos);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetUserID(){
        try {
            System.out.println("ID del usuario: " + user.getUserID());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetUserName(){
        try {
            if(user.getUserName() == null) System.out.println("El usuario no tiene nombre");
            else System.out.println("Nombre del usuario: " + user.getUserName());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetUserPassword(){
        try {
            if(user.getUserPassword() == null) System.out.println("El usuario no tiene password");
            else System.out.println("Password del usuario: " + user.getUserPassword());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testRateItem(){

        System.out.println("Escriba el id y la valoracion del item a valorar");
        Scanner lector = new Scanner(System.in);
        String datos = lector.nextLine();
        String[] datosSeparados = datos.split(" ");
        Item item = new Item(Integer.parseInt(datosSeparados[0]));
        try {
            user.rateItem(item, Double.parseDouble(datosSeparados[1]));
            System.out.println("Parametros: " + user.getListMetrics());
        }
        catch (Exception e) {
            System.out.println("Error al valorar");
        }
    }

    public static void testGetItemRating () {
        try {
            System.out.println("Escriba el id del item a buscar");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            Valoracion val = user.getItemRating(Integer.parseInt(datos));
            System.out.println("Valoracion: " + val.getUserID() + " " + val.getItemID() + " " + val.getPuntuacion());

        }
        catch (Exception e) {
            System.out.println("El id introducido no se reconoce");
        }
    }

    private static void testGetValSize() {
        try{
            System.out.println("Size Valoraciones: " + user.getValSize());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetKeySetVal() {
        try {
            Set<Integer> setItemIDs = user.getKeySetVal();
            System.out.println("Set de claves conseguido");
            setItemIDs.forEach(System.out::println);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetValColl() {
        try {
            HashSet<Valoracion> setItemIDs = new HashSet<>(user.getValColl());
            System.out.println("Set de Valoraciones conseguido");
            for(Valoracion v: setItemIDs) {
                System.out.println(v.ToString());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testExistsVal() {
        try {
            System.out.println("Escriba el id del item a buscar");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            if(user.existsVal(Integer.parseInt(datos))) System.out.println("La valoración del item con id: " + datos + " existe");
            else System.out.println("La valoración del item con id: " + datos + " no existe");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetListMetrics() {
        try {
            System.out.println(user.getListMetrics());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetRatingItemID() {
        try {
            System.out.println("Escriba el id del item a buscar su puntuacion");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            System.out.println(user.getRatingItemID(Integer.parseInt(datos)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetSizeMetrics() {
        try {
            System.out.println("Size Metrics: " + user.getSizeMetrics());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testToString(){
        try {
            String[] us =  user.ToString();
            for (String s : us) System.out.println(s);
        }
        catch (Exception e) {
            System.out.println("Error al valorar");
        }
    }


    public static void main (String[] args) {

        user = new User();

        boolean end = false;

        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la  funcion a probar: (1.constructora, 2.setID, 3.setName, 4.setPass, 5.getID, 6.getName, 7.getPass, 8.rateItem, 9.getItemRating, 10.getValSize, 11.getKeySetVal, \n" +
                    "12.getValColl, 13.existsVal, 14.getListMetrics, 15.getRatingItemID, 16.getSizeMetrics, 17.UserToString) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructora();
                    break;

                case "2" :
                    testSetUserID();
                    break;

                case "3" :
                    testSetUserName();
                    System.out.println("nuevo nombre: " + user.getUserName());
                    break;

                case "4" :
                    testSetUserPassword();
                    System.out.println("nueva password: " + user.getUserPassword());
                    break;

                case "5"   :
                    testGetUserID();
                    break;

                case "6" :
                    testGetUserName();
                    break;

                case "7" :
                    testGetUserPassword();
                    break;

                case "8" :
                    testRateItem();
                    break;

                case "9" :
                    testGetItemRating();
                    break;

                case "10" :
                    testGetValSize();
                    break;

                case "11" :
                    testGetKeySetVal();
                    break;

                case "12" :
                    testGetValColl();
                    break;

                case "13" :
                    testExistsVal();
                    break;

                case "14" :
                    testGetListMetrics();
                    break;

                case "15" :
                    testGetRatingItemID();
                    break;

                case "16" :
                    testGetSizeMetrics();
                    break;

                case "17" :
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
