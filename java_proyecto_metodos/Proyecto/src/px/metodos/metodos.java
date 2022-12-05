package px.metodos;

import javax.swing.JOptionPane;

public class metodos {
	
	// Crear método existe
			public Boolean existe(int[] Conjunto, int Elemento) {

				Boolean existe = false;
				// Recorrer los elementos del arreglo y verificar el existe
				for (int i = 0; i < Conjunto.length; i++) {
					if (Conjunto[i] == Elemento) {
						existe = true;
					}
				}
				// Retornar
				return existe;
			}
				
			public int[] Union(int[] A, int[] B) {
				// UNION
				int U[] = new int[A.length + B.length];
				// Pasar los elementos del conjunto A a la UNION
				for (int i = 0; i < A.length; i++) {
					U[i] = A[i];
				}
				// Pasar los elementos del conjunto B que no se repitan con el A
				int x = 0; // Comprobar posicion correcta
				int r = 0; // Contar repetidos
				for (int i = 0; i < B.length; i++) {
					if (existe(U, B[i]) == false) {
						U[A.length + x] = B[i];
						x++;
					} else {
						r++;
					}

				}
				// Declarar variable auxiliar
				int[] Aux = U;
				// Redefinir el arreglo U
				U = new int[Aux.length - r];
				// Devolver elementos
				for (int i = 0; i < U.length; i++) {
					U[i] = Aux[i];

				}
				// Retornar el arreglo U
				return U;
			}

			public int[] Interseccion(int[] A, int[] B) {
				int c = 0;
				for (int i = 0; i < A.length; i++) {
					if (existe(B, A[i]) == true) {
						c++;
					}
				}
				//
				int[] I = new int[c];
				int x = 0;
				//
				for (int i = 0; i < A.length; i++) {
					if (existe(B, A[i]) == true) {
						I[x] = A[i];
						x++;
					}

				}
				return I;
			}

			public int[] productoCartesiano(int[] A, int[] B) {
				int[] result = new int[A.length * B.length];
				int x = 0;

				for (int v1 : A) {
					for (int v2 : B) {
						result[x] = v1 * v2;
						x++;
					}

				}
				return result;
			}

			public boolean buscarNumeroA(int n, int A[]) {
				int cont = 0;

				boolean encontradoA = false;

				for (int i = 0; i < A.length; i++) {
					if (n == A[i]) {
						cont++; // Contador se incrementa a 1
					}

					if (cont > 0) {
						encontradoA = true;
						JOptionPane.showMessageDialog(null, "Pertenece al conjunto A");
						break;
					}
				}
				return encontradoA;
			}

			public boolean buscarNumeroB(int n, int B[]) {
				int cont2 = 0;
				boolean encontradoB = false;

				for (int i = 0; i < B.length; i++) {
					if (n == B[i]) {
						cont2++;
					}
					if (cont2 > 0) {
						encontradoB = true;
						JOptionPane.showMessageDialog(null, "Pertenece al conjunto B");
						break;
					}
				}
				return encontradoB;

			}
}

