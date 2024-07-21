package FONTS.CapaDeDominio.DriversDominio.DriverAlgoritmos;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AlgoritmosTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
    }

        if (result.wasSuccessful()) System.out.println("Todos los tests pasados");
    }
}
