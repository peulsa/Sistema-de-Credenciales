/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.ConfigEvento;
import model.Credencial;

/**
 *
 * @author Erika
 */
public class DemoEvento {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Credencial> credenciales = new ArrayList<>();

        // Configuración del evento (Singleton)
        ConfigEvento config = ConfigEvento.getInstancia();
        System.out.println("Sistema de Credenciales para: " + config.getNombreEvento());

        // Plantilla base (Prototype)
        Credencial plantilla = new Credencial("Nombre", "Cargo", "RUT");

        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar nueva credencial");
            System.out.println("2. Ver credenciales generadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            limpiarConsola();
            
            switch (opcion) {
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.print("Nombre del asistente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cargo del asistente: ");
                    String cargo = scanner.nextLine();

                    String rut;
                    while (true) {
                        System.out.print("RUT del asistente (formato 12345678-9): ");
                        rut = scanner.nextLine();
                        if (validarRutChileno(rut)) {
                            break; // El RUT es válido, salimos del bucle
                        } else {
                            System.out.println("---------------------------------------");
                            System.out.println("RUT inválido. Intente nuevamente.");
                            System.out.println("---------------------------------------");

                        }
                    }

                    // Clonar desde plantilla
                    Credencial nueva = plantilla.clone();
                    nueva.setNombre(nombre);
                    nueva.setCargo(cargo);
                    nueva.setRut(rut);
                    credenciales.add(nueva);

                    System.out.println("---------------------------------------");
                    System.out.println(" Credencial generada correctamente.");
                    System.out.println("---------------------------------------");
                    Waiting();
                    limpiarConsola();
                    break;

                case 2:
                    if (credenciales.isEmpty()) {
                        System.out.println("---------------------------------------");
                        System.out.println("No hay credenciales generadas.");
                        Waiting();
                    } else {
                        System.out.println("---------------------------------------");
                        System.out.println("Lista de credenciales:");
                        for (Credencial c : credenciales) {
                            c.mostrar();
                        }
                        Waiting();
                        limpiarConsola();
                    }
                    break;

                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("---------------------------------------");
                    System.out.println("Opción inválida.");
                    Waiting();
                    limpiarConsola();
            }
        } while (opcion != 3);
    }

    private static void Waiting() {
        System.out.print("Ingrese enter para continuar");
        scanner.nextLine();
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean validarRutChileno(String rut) {
        if (!rut.matches("^\\d{7,8}-[0-9kK]$")) {
            return false; // Formato inválido
        }

        String[] partes = rut.split("-");
        String numero = partes[0];
        char dvIngresado = partes[1].toUpperCase().charAt(0);

        int suma = 0;
        int multiplicador = 2;

        // Recorrer el número de derecha a izquierda
        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i)) * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        char dvCalculado;

        if (resto == 1) {
            dvCalculado = 'K';
        } else if (resto == 0) {
            dvCalculado = '0';
        } else {
            dvCalculado = (char) ('0' + (11 - resto));
        }

        return dvCalculado == dvIngresado;
    }

}
