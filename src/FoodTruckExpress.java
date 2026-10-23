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
                ventas[i][j] = valor;
            }
        }
    }
}