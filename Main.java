import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> historial = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\nSeleccione una figura geométrica:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Ver Historial");
                System.out.println("7. Salir");
                System.out.print("Opción: ");
                int figura = entrada.nextInt();

                if (figura == 7) {
                    continuar = false;
                    break;
                }

                if (figura == 6) {
                    System.out.println("\nHistorial de operaciones:");
                    if (historial.isEmpty()) {
                        System.out.println("No hay operaciones registradas.");
                    } else {
                        for (String operacion : historial) {
                            System.out.println(operacion);
                        }
                    }
                    continue;
                }

                System.out.println("\nSeleccione la operación:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Opción: ");
                int operacion = entrada.nextInt();

                double resultado = 0;
                String descripcion = "";
                switch (figura) {
                    case 1: // Círculo
                        System.out.print("Ingrese el radio: ");
                        double radio = entrada.nextDouble();
                        resultado = (operacion == 1) ? Math.PI * radio * radio : 2 * Math.PI * radio;
                        descripcion = "Círculo - " + ((operacion == 1) ? "Área" : "Perímetro") + ": " + resultado;
                        break;
                    case 2: // Cuadrado
                        System.out.print("Ingrese el lado: ");
                        double lado = entrada.nextDouble();
                        resultado = (operacion == 1) ? lado * lado : 4 * lado;
                        descripcion = "Cuadrado - " + ((operacion == 1) ? "Área" : "Perímetro") + ": " + resultado;
                        break;
                    case 3: // Triángulo (equilátero para perímetro)
                        if (operacion == 1) {
                            System.out.print("Ingrese la base: ");
                            double base = entrada.nextDouble();
                            System.out.print("Ingrese la altura: ");
                            double altura = entrada.nextDouble();
                            resultado = (base * altura) / 2;
                        } else {
                            System.out.print("Ingrese la longitud de un lado: ");
                            double ladoTriangulo = entrada.nextDouble();
                            resultado = 3 * ladoTriangulo;
                        }
                        descripcion = "Triángulo - " + ((operacion == 1) ? "Área" : "Perímetro") + ": " + resultado;
                        break;
                    case 4: // Rectángulo
                        System.out.print("Ingrese la base: ");
                        double baseR = entrada.nextDouble();
                        System.out.print("Ingrese la altura: ");
                        double alturaR = entrada.nextDouble();
                        resultado = (operacion == 1) ? baseR * alturaR : 2 * (baseR + alturaR);
                        descripcion = "Rectángulo - " + ((operacion == 1) ? "Área" : "Perímetro") + ": " + resultado;
                        break;
                    case 5: // Pentágono (regular)
                        System.out.print("Ingrese la longitud de un lado: ");
                        double ladoPentagono = entrada.nextDouble();
                        if (operacion == 1) {
                            System.out.print("Ingrese la apotema: ");
                            double apotema = entrada.nextDouble();
                            resultado = (5 * ladoPentagono * apotema) / 2;
                        } else {
                            resultado = 5 * ladoPentagono;
                        }
                        descripcion = "Pentágono - " + ((operacion == 1) ? "Área" : "Perímetro") + ": " + resultado;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        continue;
                }

                historial.add(descripcion);
                System.out.println(descripcion);
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Intente de nuevo.");
                entrada.next();
            }
        }

        System.out.println("¡Hasta luego!");
        entrada.close();
    }
}
