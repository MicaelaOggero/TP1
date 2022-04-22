import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.*;

public class Donacion {

	private LocalDate fechaDonacion = LocalDate.of(2022, 1, 20);
	private Scanner teclado;
	private boolean dono;

	
	public void actDonacion() {
		
		
		teclado = new Scanner (System.in);
		int i, j, k;
		System.out.print("Ingrese la fecha de la ultima donanción: ");
		System.out.print("Día: ");
		k=teclado.nextInt();
		System.out.print("Mes: ");
		j=teclado.nextInt();
		System.out.print("Año: ");
		i=teclado.nextInt();
		fechaDonacion = LocalDate.of(i, j, k);
		
		
	}
		
	public void donoSiNo() {
		
		if (fechaDonacion != null) {
			dono = true;
		}
		
		else {
			dono = false;
		}
		
	}

}