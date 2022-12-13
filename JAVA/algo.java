
package proyecto1

import java.util.Scanner;

public class proyecto1 {
    public static void main(String[] args) {

        Scanner nazi = new Scanner(System.in);

        int capacidadArray = 0;

        // Este es un array que va a tener la longitud que le des en "capacidadArray"

        int opc;
        int entero;

        System.out.println("Ingrese la cantidad de su array: ");
        capacidadArray = nazi.nextInt();

        int[] A = new int[capacidadArray];

        for (int i = 0; i < A.length; i++) {
            System.out.println("Porfavor ingrese sus numeros");
            A[i] = nazi.nextInt();
        }
        // Acá te conviene hacer un switch
        System.out.println("1- Mostrar todos los numeros del array");
        System.out.println("2- Pedir una posicion y mostrar su valor");
        System.out.println("3- Mostrar cuantos negativos hay");
        System.out.println("4- Mostrar si existen ceros en el arreglo");
        System.out.println("5- Mostrar si son TODOS positivos o no");
        System.out.println("6- Salir");
        opc = nazi.nextInt();

        switch (opc) {

            case 1:
                for (int i = 0; i < A.length; i++) {
                    System.out.println("Estos son los numeros de su array: " + A[i]);
                }
            case 2:
                for (int i = 0; i < A.length; i++) {
                    System.out.println("Por favor ingrese una posicion");
                    entero = nazi.nextInt();
                    System.out.println("la posicion " + entero + " contiene el valor " + A[i]);
                }
        }
    }
}
