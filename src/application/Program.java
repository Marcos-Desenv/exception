package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number:");
		int number = sc.nextInt();

		System.out.println("Check-in:");
		Date checkIn = sdf.parse(sc.next());

		System.out.println("Check-out:");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("NOT AFTER");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);

			System.out.println("");
			System.out.println("UPDATE Dates:");

			System.out.println("Check-in:");
			checkIn = sdf.parse(sc.next());

			System.out.println("Check-out:");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("ERRO BEFORE");
			} else {
				if (!checkOut.after(checkIn)) {
					System.out.println("NOT AFTER");
				} else {
					reservation.updateDates(checkIn, checkOut);
					System.out.println("Reservation:" + reservation);
				}
			}
		}
		;

		sc.close();
	}

}
