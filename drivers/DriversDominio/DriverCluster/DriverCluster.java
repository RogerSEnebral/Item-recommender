package FONTS.CapaDeDominio.DriversDominio.DriverCluster;

import FONTS.CapaDeDominio.DomainModel.Cluster;
import FONTS.CapaDeDominio.DomainModel.User;
import FONTS.CapaDeDominio.DomainModel.Valoracion;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;

public class DriverCluster {

    private static Cluster cluster;

    public static void testConstructoraVacia() {
        try {
            cluster = new Cluster();
            System.out.println("Cluster inicializado");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testConstructoraCentroide() {
        try {
            System.out.println("Escriba las 6 coordenadas del centroide a crear");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            String[] datosSeparados = datos.split(" ");

            ArrayList<Double> coordenadas = new ArrayList<>();
            int counter = 0;
            for (String coord : datosSeparados) {
                ++counter;
                if(counter < 6) coordenadas.add(Double.parseDouble(coord));
            }
            if(counter >= 6) System.out.println("Has introducido un numero de coordenadas mas alto del permitido, solo se han añadido las 6 primeras.");
            cluster = new Cluster(coordenadas);
            System.out.println("Nuevo cluster con centroide: " + cluster.getCentroide());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetFinished() {
        try {
            System.out.println("finished = " + cluster.getFinished());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetCentroide () {
        try {
            System.out.println("Centroide: " + cluster.getCentroide());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testInsertUser() {
        try {
            System.out.println("escriba el id del usuario, seguido de sus metrics");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            String[] datosSeparados = datos.split(" ");

            int userID = Integer.parseInt(datosSeparados[0]);

            ArrayList<Double> coordenadas = new ArrayList<>();
            for (int i = 1; i < datosSeparados.length; ++i) {
                coordenadas.add(Double.parseDouble(datosSeparados[i]));
            }
            User user = new User (userID, coordenadas, new Valoracion[0]);
            cluster.insertUser(user);
            System.out.println("User insertado");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSetCentroide() {
        try {
            System.out.println("Escriba las 6 coordenadas del nuevo centroide a crear");
            Scanner lector = new Scanner(System.in);
            String datos = lector.nextLine();
            String[] datosSeparados = datos.split(" ");

            ArrayList<Double> coordenadas = new ArrayList<>();
            for (String coord : datosSeparados) {
                coordenadas.add(Double.parseDouble(coord));
            }
            cluster.setCentroide(coordenadas);
            System.out.println("Nuevo centroide: " + cluster.getCentroide());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testEraseUsers() {
        try {
            cluster.eraseUsers();
            System.out.println("Nuevo size de cluster: " + cluster.getClusterSize());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetClusterSize() {
        try {
            System.out.println("Size de cluster: " + cluster.getClusterSize());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testFinished() {
        try {
            cluster.finished();
            System.out.println("Nuevo valor finished: " + cluster.getFinished());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetParamSize() {
        try {
            System.out.println("Centroide coords size: " + cluster.getParamSize());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetUsers() {
        try {
            int i = 1;
            for(User user : cluster.getUsers()) {
                System.out.println("User " + i + ": " + user.getUserID() + " " + user.getListMetrics());
                ++i;
            }
            if (i == 1) System.out.println("No hay usuarios");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testGetUsersMetrics() {
        try {
            Collection<ArrayList<Double>> userMetrics = cluster.getUsersMetrics();
            for(ArrayList<Double> metrics : userMetrics) {
                System.out.println(metrics);
            }
            if(cluster.getClusterSize() == 0) System.out.println("No hay usuarios");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main (String[] args) throws IOException {

        cluster = new Cluster();

        boolean end = false;

        Scanner lector = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("Escriba el numero de la funcion a probar: (1.constructoraVacia, 2.constructoraCentroide, 3.getFinished, 4.getCentroide, 5.insertUser, 6.setCentroide, \n" +
                    "7.eraseUsers, 8.getClusterSize, 9.finished, 10.getParamSize, 11.getUsers, 12.getUsersMetrics) o bien escriba exit para finalizar");
            String datos = lector.nextLine();

            switch (datos) {
                case "1" :
                    testConstructoraVacia();
                    break;

                case "2" :
                    testConstructoraCentroide();
                    break;

                case "3" :
                    testGetFinished();
                    break;

                case "4" :
                    testGetCentroide();
                    break;

                case "5"   :
                    testInsertUser();
                    break;

                case "6" :
                    testSetCentroide();
                    break;

                case "7" :
                    testEraseUsers();
                    break;

                case "8" :
                    testGetClusterSize();
                    break;

                case "9" :
                    testFinished();
                    break;

                //como se supone que todas las metrics tienen siempre el mismo size se coge el del centroide actual
                case "10" :
                    testGetParamSize();
                    break;

                case "11" :
                    testGetUsers();
                    break;

                case "12" :
                    testGetUsersMetrics();
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
