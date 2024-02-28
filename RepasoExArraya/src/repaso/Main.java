package repaso;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static final String CONTRASENA = "Maquina2023";

	public static void main(String[] args) {

		// Se crea el objeto golosinas de la clase Golosinas
		Golosinas golosinas = new Golosinas();
		// opciones del menú
		int opc = 0;
		// posición de la fila de la matriz de la máquina
		int posFila;
		// posición de la col de la matriz de la máquina
		int posCol;
		// intento del usuario de introducir la contraseña
		String intentoContrasena;
		// cantidad a rellenar de golosinas
		int cantidad;

		// primero rellenamos la tabla de stock de golosinas para que se inicialice en 5
		// de stock por item
		golosinas.rellenarMatriz(5);

		// inicializamos las ventas en ""
		Arrays.fill(golosinas.ventas, "");

		// muestra menú
		menu();
		// pide una opción del menú
		System.out.print("Introduce una opción: ");
		opc = sc.nextInt();

		// Se entra en un bucle hasta que se apaga la máquina, es decir, cuando se
		// selecciona la opción 4
		while (opc != 4) {

			// switch que controla la ejecución de código según la opción introducida
			switch (opc) {
			// muestra las golosinas que hay
			case 1 -> {
				golosinas.mostrarGolosinas();
			}
			case 2 -> {
				// pide al usuario la posición de la golosina que quiere
				System.out.println("Introduzca posición :");
				posFila = sc.nextInt();
				posCol = sc.nextInt();

				// comprueba si hay existencias
				if (!golosinas.hayValorPosicion(posFila, posCol)) {
					System.out.println("No quedan existencias del item " + posFila + ", " + posCol);
				} else {
					// se añade una venta, por lo que se disminuye el stock
					golosinas.anadirVentas(posFila, posCol);
					golosinas.reducirPosicion(posFila, posCol, 1);
				}

			}
			case 3 -> {
				// le pide al usuario la contrasena para verificar que sea un técnico, en caso
				// de que lo sea le permite rellenar golosinas
				System.out.println("Introduce contraseña de técnico: ");
				intentoContrasena = sc.next();
				// si es correcta le pregunta la posición de que golosina va a rellenar
				if (intentoContrasena.equals(CONTRASENA)) {
					System.out.println("Introduzca posición :");
					posFila = sc.nextInt();
					posCol = sc.nextInt();
					// validación, si es true pregunta por la cantidad de golosinas a rellenar y
					// llama a la función que las rellena
					if (golosinas.hayValorPosicion(posFila, posCol)) {
						System.out.println("¿Cuantas quiere rellenar?");
						cantidad = sc.nextInt();

						golosinas.aumentarPosicion(posFila, posCol, cantidad);
						
					} else {
						// mensaje de error
						System.out.println("Error, fuera de rango de la máquina");
					}
				} else {
					// mensaje de error
					System.out.println("Error, contraseña incorrecta");
				}
			}
			default -> {
				// mensaje de error
				System.out.println("Opción incorrecta.");
			}
			}// fin bloque switch

			// muestra menú
			menu();
			// pide una opción del menú
			System.out.print("Introduce una opción: ");
			opc = sc.nextInt();
		}

		System.out.println("Golosinas vendidas: ");
		System.out.println(Arrays.toString(golosinas.ventas));
		System.out.println("Total de ganancias: ");
		System.out.println(golosinas.total);
	}

	/**
	 * Menú de la máquina de golosinas
	 */
	public static void menu() {
		System.out.println("1. Mostrar Golosinas");
		System.out.println("2. Pedir Golosinas");
		System.out.println("3. Rellenar Golosinas");
		System.out.println("4. Apagar máquina");
	}

}
