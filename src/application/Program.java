package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int rn =  sc.nextInt();
		System.out.print("Check-in(dd/MM/yyyy): ");
		Date chi = sdf.parse(sc.next());
		System.out.print("Check-out(dd/MM/yyyy): ");
		Date cho = sdf.parse(sc.next());
		
		if (!cho.after(chi)) {
			System.out.println("Error in reservation: Check-out date shall be after check-in date!");
		}
		else {
			Reservation reservation = new Reservation(rn, chi, cho);
			System.out.println("Reservation: " + reservation);

			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in(dd/MM/yyyy): ");
			chi = sdf.parse(sc.next());
			System.out.print("Check-out(dd/MM/yyyy): ");
			cho = sdf.parse(sc.next());
			
			Date now = new Date();
			if (chi.before(now) || cho.before(now)) {
				System.out.println("Error: date must be in the future!");
				
			}
			else if (!cho.after(chi)) {
				System.out.println("Error in reservation: Check-out date shall be after check-in date!");
			}
			else {
				reservation.updateDate(chi, cho);
				System.out.println("Reservation: " + reservation);	
			}
		}
		sc.close();
	}
}
