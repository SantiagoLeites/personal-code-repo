package actividad;
import java.util.Scanner;
public class actividad {
	

		public static void main(String[] args) {
			
			int popular, lujo, dias, precio, tipoAuto, kms, kmsPopular, kmsLujo;
			
			Scanner entrada=new Scanner(System.in);
			System.out.println("Ingrese el tipo de coche que utilizo");
			System.out.println("************************************");
			System.out.println("          1 - Popular               ");
			System.out.println("          2 - Lujo                  ");
			tipoAuto=entrada.nextInt();
			System.out.println("¿Cuantos dias utilizo ese vehiculo?");
			dias=entrada.nextInt();
			
			System.out.println("¿Cuantos kilometros realizo?");
			kms=entrada.nextInt();
			if (tipoAuto==1){
				
				System.out.println("Usted eligio popular");
				precio=1000;
				
                   if (kms<=100){
					  kmsPopular=20;
					  System.out.println("Se le cobrara " + (precio*dias)*kmsPopular);
                   } if (kms>100){
                	     kmsPopular=15;
                	     System.out.println("Se le cobrara " + (precio*dias)*kmsPopular);
                	   }
                	   
                   }
    
			 if (tipoAuto==2){
					System.out.println("Usted eligio lujo");
					precio=1500;
							
					if(kms<=200){
					kmsLujo=30;
					System.out.println("Se le cobrara " + (precio*dias)*kmsLujo);
					} if (kms>200){
						   kmsLujo=25;
						   System.out.println("Se le cobrara " + (precio*dias)*kmsLujo);
								  }
								 
							  }
							
						}
			



	}
