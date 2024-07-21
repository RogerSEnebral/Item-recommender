package FONTS.CapaDeDominio.DriversDominio.DriverAlgoritmos;

import FONTS.CapaDeDominio.DomainModel.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class AlgoritmosTest {

    private static ArrayList<User> users;
    private static User activeUser;
    private static int k;
    private static ArrayList<Valoracion> predicciones;

    @BeforeClass
    public static void beforeClass() throws IOException {
        //lectura del fichero de pruebas
        users = new ArrayList<>();
        //ponemos el readFile fuera del try para que si hay un problema al leer el fichero se pare la ejecucion del junit completamente, ya que si no ejecutaba
        //todos los tests igualmente con todos los datos a 0
        Vector<String[]> datos = readFile("../../FONTS/CapaDeDominio/DriversDominio/DriverTestsFiles/InputAlgoritmosTest.txt");
        try {
            if(datos.size() > 1) {
                System.out.println("Inicializando estructuras de datos:");
                //valor de k
                int puntero = 0;

                k = Integer.parseInt(datos.get(puntero)[0]);
                System.out.println("Valor de k: " + k);
                ++puntero;

                //usuario Activo
                String[] datosSeparados = datos.get(puntero)[0].split(" ");
                activeUser = readUser(datos, puntero);
                puntero += Integer.parseInt(datosSeparados[6])+1;

                //metrics
                datosSeparados = datos.get(puntero)[0].split(" ");
                int numUsers = Integer.parseInt(datosSeparados[1]);
                System.out.println("insertando " + numUsers + " Users");
                ++puntero;
                for(int i = 0; i < numUsers; ++i) {
                    datosSeparados = datos.get(puntero)[0].split(" ");
                    users.add(readUser(datos, puntero));
                    puntero += Integer.parseInt(datosSeparados[6])+1;
                }
                ++puntero;
                //valoraciones
                datosSeparados = datos.get(puntero)[0].split(" ");
                predicciones = new ArrayList<>();
                int numValoraciones = Integer.parseInt(datosSeparados[1]);
                System.out.println("insertando " + numValoraciones + " Valoraciones\n");
                ++puntero;
                for (int i = 0; i < numValoraciones; ++i) {
                    datosSeparados = datos.get(puntero)[0].split(" ");
                    Valoracion val = new Valoracion(Integer.parseInt(datosSeparados[0]), Integer.parseInt(datosSeparados[1]), Double.parseDouble(datosSeparados[2]));
                    predicciones.add(val);
                    ++puntero;
                }
                System.out.println("**Resultados de los tests**\n");
            }
            else throw new Exception ("FICHERO DE TEXTO VACIO");
        }
        catch (Exception e) {
            System.out.println("FORMATO DE FICHERO INCORRECTO");
        }
    }


    @Test
    public void DistanciaUsuariosTest () {
        try {
            CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
            //Te dice las distancias entre los 6 primeros usuarios, 2 a 2
            int contadorCalculosDistancias = 0;
            double d = collaborativeFiltering.DistanciaUsuarios(users.get(0).getListMetrics(), users.get(1).getListMetrics());
            System.out.println("Distancia entre user " + (1) + " y user " + (2) + " = " + d);
            ++contadorCalculosDistancias;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    @Test
    public void kmeansTest () {
        try {
            CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
            HashSet<User> usersSet = new HashSet<>(users);
            collaborativeFiltering.kmeans(usersSet, k);
            System.out.println("Kmeans completo para k = " + k + ".");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    @Test
    public void getClosestNotEmptyClusterTest () {
        try {
            CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
            HashSet<User> usersSet = new HashSet<>(users);
            //debemos ejecutar previamente kmeans con una k decente pues si no hay cjtClusters no hay ningun cluster al que asignar
            collaborativeFiltering.kmeans(usersSet, k);
            //lo probamos con booleano false ya que con booleano true ya se prueba al ejecutar kmeans
            Cluster clusterUser = collaborativeFiltering.getClosestCluster(activeUser);
            System.out.println("Centroide asignado para k = " + k + ": " + clusterUser.getCentroide() + "\n");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    /*@Test
    public void SlopeOneTest() {
        Algoritmos algoritmos = new Algoritmos();
        HashSet<User> usersSet = new HashSet<>(users);
        double prediccion = algoritmos.SlopeOne(usersSet, activeUser, itemIDSlopeOne);
        System.out.println("Prediccion SlopeOne: " + prediccion);
    }*/



    @Test
    public void calidadRecomendacionesTest () {
        Algoritmos algoritmos = new Algoritmos();
        System.out.println("Calidad: " + algoritmos.calidadRecomendaciones(predicciones));
        System.out.println();
    }

    @Test
    public void calidadRecomendacionesOptimasTest () {
        Algoritmos algoritmos = new Algoritmos();
        System.out.println("Calidad Optima: " + algoritmos.calidadRecomendacionesOptimas(predicciones));
        System.out.println();
    }


    private static Vector<String[]> readFile(String path) throws IOException {
        boolean first = true;
        Vector<String[]> res = new Vector<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(path));
            String[] nextRow;
            while ((nextRow = csvReader.readNext()) != null) {
                if (first) {
                    first = false;
                }
                res.add(nextRow);
            }
        }
        catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static User readUser (Vector<String[]> datos, int puntero) {
        String[] datosSeparados = datos.get(puntero)[0].split(" ");
        int userID = Integer.parseInt(datosSeparados[0]);
        ArrayList<Double> metrics = new ArrayList<>();
        for (int j = 1; j < 6; ++j) {
            metrics.add(Double.parseDouble(datosSeparados[j]));
        }
        int numValoraciones = Integer.parseInt(datosSeparados[6]);
        ++puntero;
        Valoracion[] valoraciones = new Valoracion[numValoraciones];
        for(int j = 0; j < numValoraciones; ++j) {
            datosSeparados = datos.get(puntero)[0].split(" ");
            Valoracion val = new Valoracion(Integer.parseInt(datosSeparados[1]), userID, Integer.parseInt(datosSeparados[0]));
            valoraciones[j] = val;
            ++puntero;
        }
        return new User(userID, metrics, valoraciones);
    }
}
