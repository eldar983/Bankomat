package zadaca;

import java.util.ArrayList;
import java.util.Scanner;

public class DetaljiRacuna {

	public static void detalji(ArrayList<KreirajRacun> racuni, Scanner input) {

		KreirajRacun racun = new KreirajRacun();
		boolean provjeraRacuna = false;


		//vrsimo provjeru unesenog broja sa listom kreiranih racuna
		while (!provjeraRacuna) {
			System.out.println("Unesite vas broj racuna: ");
			int broj = input.nextInt();

			int index = -1;
			provjeraRacuna = false;

			// prodji kroz listu racuna i uporedi uneseni broj sa listom, ukoliko se podudara, tj uneseni broj odgovara nekom od kreiranih racuna iz liste
			//izdvoji onda taj racun iz liste i dodaj ga novo kreiranom objektu racun
			for (KreirajRacun object : racuni) {
				index++;
				if (object.getBrojRacuna() == broj) {
					provjeraRacuna = true;
					racun = racuni.get(index);
					break;
				}
			}
		}
		//poziv metode koja ce ispisati detalje racuna
		ispisDetaljaRacuna(racun);
	}
	//metoda kojim cemo dobiti informacije tj. detalje trazenog racuna
	public static void ispisDetaljaRacuna(KreirajRacun racun) {
		System.out.println("**************************");
		System.out.println("Racun je na ime: " + racun.getImeKorisnika());
		System.out.println("Trenutno stanje na vasem racunu je: " + racun.getStanjeRacuna() + " KM.");
		System.out.println("**************************");
	}
}
