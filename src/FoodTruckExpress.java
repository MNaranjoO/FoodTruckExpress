import java.util.Scanner;

public class FoodTruckExpress {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        String[] productos = new String[3];
        String[] turnos = new String[4];
        double[][] ventas = new double[3][4];

        productos[0] = "Hamburguesas";
        productos[1] = "Perros Calientes";
        productos[2] = "Papas Fritas";

        turnos[0] = "Almuerzo";
        turnos[1] = "Tarde";
        turnos[2] = "Noche";
        turnos[3] = "Madrugada";

        registrarVentas(productos, turnos, ventas);
        calcularReportes(productos, turnos, ventas);
    }

    static void registrarVentas(String[] productos, String[] turnos, double[][] ventas) {
        int i = 0;
        int j = 0;
        double valor = 0;

        System.out.println("=== REGISTRO DE VENTAS ===");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print("Ingrese ventas de " + productos[i] + " en el turno " + turnos[j] + " ($): ");
                valor = entrada.nextDouble();

                while (valor < 0) {
                    System.out.print("Error: El valor no puede ser negativo. Intente de nuevo: ");
                    valor = entrada.nextDouble();
                }

                ventas[i][j] = valor;
            }
        }
    }

    static void calcularReportes(String[] productos, String[] turnos, double[][] ventas) {
        double[] totalProducto = new double[3];
        double[] totalTurno = new double[4];
        double totalGeneral = 0;
        int i = 0;
        int j = 0;
        int posMayorProd = 0;
        int posMenorProd = 0;
        int posMayorTurno = 0;
        int posMenorTurno = 0;

        for (i = 0; i < 3; i++) {
            totalProducto[i] = 0;
        }
        for (j = 0; j < 4; j++) {
            totalTurno[j] = 0;
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                totalProducto[i] = totalProducto[i] + ventas[i][j];
                totalTurno[j] = totalTurno[j] + ventas[i][j];
                totalGeneral = totalGeneral + ventas[i][j];
            }
        }

        System.out.println("\n=== TOTAL POR PRODUCTO ===");
        for (i = 0; i < 3; i++) {
            System.out.println(productos[i] + ": $" + totalProducto[i]);
        }

        System.out.println("\n=== TOTAL POR TURNO ===");
        for (j = 0; j < 4; j++) {
            System.out.println(turnos[j] + ": $" + totalTurno[j]);
        }

        for (i = 1; i < 3; i++) {
            if (totalProducto[i] > totalProducto[posMayorProd]) {
                posMayorProd = i;
            }
            if (totalProducto[i] < totalProducto[posMenorProd]) {
                posMenorProd = i;
            }
        }

        for (j = 1; j < 4; j++) {
            if (totalTurno[j] > totalTurno[posMayorTurno]) {
                posMayorTurno = j;
            }
            if (totalTurno[j] < totalTurno[posMenorTurno]) {
                posMenorTurno = j;
            }
        }

        System.out.println("\n=== PRODUCTOS ===");
        System.out.println("Mayor recaudo: " + productos[posMayorProd] + " ($" + totalProducto[posMayorProd] + ")");
        System.out.println("Menor recaudo: " + productos[posMenorProd] + " ($" + totalProducto[posMenorProd] + ")");

        System.out.println("\n=== TURNOS ===");
        System.out.println("Mayor recaudo: " + turnos[posMayorTurno] + " ($" + totalTurno[posMayorTurno] + ")");
        System.out.println("Menor recaudo: " + turnos[posMenorTurno] + " ($" + totalTurno[posMenorTurno] + ")");

        System.out.println("\nTOTAL GENERAL RECAUDADO: $" + totalGeneral);

        if (totalGeneral > 500000) {
            System.out.println("Meta de Ventas Alcanzada");
        } else {
            System.out.println("Meta No Alcanzada");
        }
    }
}