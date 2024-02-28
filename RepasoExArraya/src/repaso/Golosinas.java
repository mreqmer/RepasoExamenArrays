package repaso;

import java.util.Arrays;

/**
 * Se contiene las utilidades para el uso de la máquina de golosinas
 */
public class Golosinas {

	/**
	 * Tamaño de fila de la máquina de golosinas
	 */
	static final int TAMANO_FILA = 4;
	/**
	 * Tamaño de columna de la máquina de golosinas
	 */
	static final int TAMANO_COL = 4;

	/**
	 * Nombre de las golosinas
	 */
	String[][] nombresGolosinas = { { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
			{ "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
			{ "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
			{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };

	/**
	 * Precio de cada golosina, corresponde con la tabla nombresGolosinas
	 */
	double[][] precio = { { 1.1, 0.8, 1.5, 0.9 }, { 1.8, 1, 1.2, 1 }, { 1.8, 1.3, 1.2, 0.8 }, { 1.5, 1.1, 1.1, 1.1 } };

	/**
	 * Cantidad de golosinas de las que disponemos
	 */
	int stock[][] = new int[TAMANO_FILA][TAMANO_COL];
	/**
	 * Golosinas vendidas
	 */
	String ventas[] = new String[16];

	/**
	 * Precio total de la venta
	 */
	double total;

	/**
	 * Se rellena la matriz stock con un número introducido por parámetro
	 * 
	 * @param num Número con el cual se rellena la matriz
	 */
	public void rellenarMatriz(int num) {

		for (int i = 0; i < stock.length; i++) {
			for (int j = 0; j < stock[0].length; j++) {

				stock[i][j] = num;

			}
		}
	}

	/**
	 * Muestra el nombre de las golosinas, cada una junto a su posición y su precio
	 */
	public void mostrarGolosinas() {

		for (int i = 0; i < nombresGolosinas.length; i++) {
			for (int j = 0; j < nombresGolosinas[0].length; j++) {

				System.out.println(nombresGolosinas[i][j] + "; " + i + ", " + j + "; " + precio[i][j] + "€");

			}
		}

	}

	/**
	 * Comprueba si la posición introducida para la máquina de golosinas es válida o
	 * no
	 * 
	 * @param fila    Fila de la máquina de golosinas
	 * @param columna Columna de la máquina de golosinas
	 * @return Booleano true si la posición es válida, false si no lo fuera
	 */
	public boolean validarPos(int fila, int columna) {
		boolean esValida = false;

		if ((fila >= 0 || fila < TAMANO_FILA) && (columna <= 0 || columna < TAMANO_COL)) {
			esValida = true;
		}

		return esValida;
	}

	/**
	 * Compueba si hay estock o no de un producto
	 * 
	 * @param fila    Fila de la máquina de golosinas
	 * @param columna Columna de la máquina de golosinas
	 * @return Booleano true si hay stock de un producto, false si no lo hay
	 */
	public boolean hayValorPosicion(int fila, int columna) {
		boolean hayStock = false;

		if (stock[fila][columna] > 0) {
			hayStock = true;
		}

		return hayStock;
	}

	/**
	 * Aumenta la cantidad de golosinas de una posición
	 * 
	 * @param fila     Fila en donde se aumenta la cantidad
	 * @param columna  Columna en donde se aumenta la cantidad
	 * @param cantidad Cantidad a aumentar
	 */
	public void aumentarPosicion(int fila, int columna, int cantidad) {

		stock[fila][columna] += cantidad;

	}

	/**
	 * Disminuye la cantidad de golosinas de una posición
	 * 
	 * @param fila     Fila en donde se disminuye la cantidad
	 * @param columna  Columna en donde se disminuye la cantidad
	 * @param cantidad Cantidad a disminuir
	 */
	public void reducirPosicion(int fila, int columna, int cantidad) {

		stock[fila][columna] -= cantidad;

	}

	/**
	 * Añade el nombre de la golosina vendida a la tabla ventas
	 * 
	 * @param fila    Fila en donde se encuenta la golosina
	 * @param columna Columna donde se encuentra la golosina
	 */
	public void anadirVentas(int fila, int columna) {

		for (int i = 0; i < stock.length; i++) {
			if (ventas[i].equals("")) {
				ventas[i] = nombresGolosinas[fila][columna];
				// break para que salga del bucle y deje de añadir elementos a la tabla
				break;
			}
		}
		//añade el precio de la venta al total de ventas
		total += precio[fila][columna];
	}

	/**
	 * Muestra las golosinas vendidas y el total de las ventas
	 */
	public void imprimirVentasTotales() {

		System.out.println(Arrays.toString(ventas) + "\n Total: " + total + "€");

	}

}
