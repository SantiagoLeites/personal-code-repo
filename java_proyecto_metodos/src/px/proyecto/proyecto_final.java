package px.proyecto;
import px.metodos.metodos;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class proyecto_final {

	
	public static void main(String[] args) {
		
		metodos metodos = new metodos();
		
		
		int tA, tB, opc = -1, opcayuda = -1;
		boolean fin = false;
		Scanner entrada = new Scanner(System.in);

		tA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de elementos de A "));
		tB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de elementos de B "));

		int[] A = new int[tA];
		int[] B = new int[tB];

		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los elementos de A "));
		}

		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los elementos de B "));

		}

		while (fin == false) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null,

					"Menu de Conjuntos\n" + "------------------------------\n" + "1. Union\n" + "2. Interseccion\n"
							+ "3. Producto Cartesiano\n" + "4. Buscar elem. conjunto\n"
							+ "5. Ordenar elementos de - a +\n" + "6. Mostrar conjuntos\n" + "7. Ayuda \n"
							+ "------------------------------\n" + "0. Salir\n" + "==============================\n"
							+ "Elige una opcion: \n",
					"MENU PRINCIPAL..", JOptionPane.QUESTION_MESSAGE

			));

			switch (opc) {
			case 1:
				// llamar a la UNION
				int[] U = metodos.Union(A, B);
				JOptionPane.showMessageDialog(null,
						"Los elementos de la Union son: \n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
				for (int i = 0; i < U.length; i++) {
					JOptionPane.showMessageDialog(null,
							"-------------------\n" + "--------" + "[" + U[i] + "]" + "-------\n"
									+ "-------------------\n",
							"Mostrando resultados..", JOptionPane.INFORMATION_MESSAGE);
				}
				break;

			case 2:
				// lamar a la Interseccion
				int[] I = metodos.Interseccion(A, B);
				JOptionPane.showMessageDialog(null,
						"Los elementos de la Interseccion son: \n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
				for (int i = 0; i < I.length; i++) {
					JOptionPane.showMessageDialog(null,
							"-------------------\n" + "--------" + "[" + I[i] + "]" + "-------\n"
									+ "-------------------\n",
							"Mostrando resultados..", JOptionPane.INFORMATION_MESSAGE);

				}

				break;

			case 3:
				
				int[] result = metodos.productoCartesiano(A, B);
				for (int i = 0; i < result.length; i++) {
					System.out.println("El resultado es: " + result[i]);
					JOptionPane.showMessageDialog(null,
							"-------------------\n" + "El resultado es: " + result[i] + "\n" + "-------------------\n",
							"Mostrando resultados..", JOptionPane.INFORMATION_MESSAGE);

				}
				break;

			case 4:
				int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero a buscar: "));

				metodos.buscarNumeroA(n, A);
				metodos.buscarNumeroB(n, B);
				break;

			case 5:
				Arrays.sort(A);
				// Ordenar los array de menor a mayor
				Arrays.sort(B);

				int a = Integer
						.parseInt(JOptionPane.showInputDialog("Conjunto que desea ordenar: \n" + "1. A \n" + "2. B "));
				if (a == 1) {
					JOptionPane.showMessageDialog(null, Arrays.toString(A));
				}
				if (a == 2) {
					JOptionPane.showMessageDialog(null, Arrays.toString(B));
				}

				break;

			case 6:
				for (int i = 0; i < A.length; i++) {
					JOptionPane.showMessageDialog(null,
							"-------------------\n" + "Conjunto A: " + A[i] + "\n" + "-------------------\n",
							"Mostrando resultados..", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("--------------");
					System.out.println("Conjunto A: " + A[i]);
					System.out.println("--------------");
				}
				for (int i = 0; i < B.length; i++) {
					JOptionPane.showMessageDialog(null,
							"-------------------\n" + "Conjunto B: " + B[i] + "\n" + "-------------------\n",
							"Mostrando resultados..", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("--------------");
					System.out.println("Conjunto B: " + B[i]);
					System.out.println("--------------");

				}
				break;

			case 7:
				int ayuda = 1;
				while (ayuda == 1) {

					opcayuda = Integer.parseInt(JOptionPane.showInputDialog(null,

							"Menu de AYUDA \n" + "------------------------------\n" + "1. Union\n" + "2. Interseccion\n"
									+ "3. Producto Cartesiano\n" + "4. Buscar elem. conjunto\n"
									+ "5. Ordenar elementos de - a +\n" + "6. Mostrar conjuntos\n"
									+ "------------------------------\n" + "0. Volver\n"
									+ "==============================\n" + "Elige una opcion: \n",
							"AYUDA..", JOptionPane.QUESTION_MESSAGE));

					switch (opcayuda) {
					case 1:
						JOptionPane.showMessageDialog(null,
								"La unión de dos conjuntos A y B \n" + " es el conjunto A ∪ B que contiene \n"
										+ " cada elemento que está por lo menos en uno de ellos. ",
								"AYUDA..", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(null,
								"La intersección de dos conjuntos A y B \n" + "es el conjunto A ∩ B que contiene \n"
										+ " todos los elementos comunes de A y B.",
								"AYUDA..", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						JOptionPane.showMessageDialog(null,
								"El producto cartesiano de dos conjuntos A y B \n"
										+ " es el conjunto A × B que contiene todos \n"
										+ " los pares ordenados (a, b) cuyo primer elemento \n"
										+ " a pertenece a A y su segundo elemento b pertenece a B.",
								"AYUDA..", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Busca un elemento en el conjunto deseado.", "AYUDA..",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Ordena los conjuntos de menor a mayor", "AYUDA..",
								JOptionPane.INFORMATION_MESSAGE);

						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Muestra los conjuntos de uno en uno", "AYUDA..",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "Volviendo..", "MENU PRINCIPAL..",
								JOptionPane.WARNING_MESSAGE);
						ayuda = 0;
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"!!!!\n" + "Error, vuelva a selecionar\n" + "--------------------------\n", "Error..",
								JOptionPane.ERROR_MESSAGE);
						break;

					}
				}

				break;

			case 0:

				if (JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir..", JOptionPane.ERROR_MESSAGE,
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				} else {
					fin = false;
				}

				break;

			default:
				JOptionPane.showMessageDialog(null,
						"!!!!\n" + "Error, vuelva a selecionar\n" + "--------------------------\n", "Error..",
						JOptionPane.ERROR_MESSAGE);
				break;

			}

		}

	}
}