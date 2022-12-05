import java.util.Scanner;

public class CajeroAutomatico {

	public static void main(String[] args) {

		int amount = 1000, opcion, result = 0, f, g;
		boolean fin = false;
		String nombre;

		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese su nombre: ");
		nombre = entrada.next();
		while (fin == false) {
			System.out.println("****** TIC BANKING CARD " + nombre + " *****");
			System.out.println("      1. Ingresar dinero a la cuenta.       ");
			System.out.println("      2. Retirar dinero de la cuenta.       ");
			System.out.println("      3. Consultar Saldo.                   ");
			System.out.println("      0. Salir.                             ");
			opcion = entrada.nextInt();

			switch (opcion) {

			case 1:
				System.out.println("Ingrese el monto que desea depositar: ");
				f = entrada.nextInt();

				result = amount + f;
				System.out.println("Usted ha ingresado correctamente " + f + " dolares");
				break;
			case 2:
				System.out.println("Ingrese el monto que desea retirar: ");
				g = entrada.nextInt();
				if (g < 1000) {
					System.out.println("No puedes retirar menos de 1000USD");
				} else {
					System.out.println("Has retirado correctamente " + g + " dolares");
					result = result - g;
				}
				break;
			case 3:
				if (result != 0) {
					System.out.println("Su saldo es de " + result + " dolares.");
				} else {
					System.out.println("Su saldo es de " + amount + " dolares");
				}
				break;

			case 0:
				System.out.println("Hasta la proxima!");
				System.exit(0);
				break;

			default:
				System.out.println("Error \nInvalid number");
				break;

			}

		}

	}
}
