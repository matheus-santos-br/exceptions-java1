package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int rn =  sc.nextInt();
			System.out.print("Check-in(dd/MM/yyyy): ");
			Date chi = sdf.parse(sc.next());
			System.out.print("Check-out(dd/MM/yyyy): ");
			Date cho = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(rn, chi, cho);
			
			System.out.println("Reservation: " + reservation);
	
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in(dd/MM/yyyy): ");
			chi = sdf.parse(sc.next());
			System.out.print("Check-out(dd/MM/yyyy): ");
			cho = sdf.parse(sc.next());
				
			reservation.updateDate(chi, cho);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException aux) {
			System.out.println("Invalid date format!");
		}
		catch (DomainExceptions aux) {
			System.out.println(aux.getMessage());
		}
		catch (RuntimeException aux) {
			System.out.println("Unexpected error!");
		}
		sc.close();
	}
}
