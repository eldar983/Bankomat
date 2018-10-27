package zadaca;

import java.util.ArrayList;
import java.util.Scanner;

public class PrebaciNovac {

	public static void prebaci(ArrayList<KreirajRacun> racuni, Scanner input) {

		//kreiramo source racun sa kojeg ce se prebacivati novac
		KreirajRacun sourceRacun = new KreirajRacun();
		boolean provjeraRacuna = false;

		//vrsimo provjeru unosa i racuna
		while (!provjeraRacuna) {
			System.out.println("Unesite broj source racuna sa kojeg zelite prebaciti novac: ");

			int broj = input.nextInt();

			int index = -1;
			provjeraRacuna = false;

			// prodji kroz listu racuna i uporedi da li se uneseni broj od korisnika poklapa sa vec kreiranim racunom
			for (KreirajRacun object : racuni) {
				index++;
				if (object.getBrojRacuna() == broj) {
					provjeraRacuna = true;
					sourceRacun = racuni.get(index);
					break;
				}
			}
		}
		//kreiramo target racun na koji ce se prebaciti novac
		KreirajRacun targetRacun = new KreirajRacun();
		boolean provjeraRacuna2 = false;

		//vrsimo provjeru unosa i racuna
		while (!provjeraRacuna2) {
			System.out.println("Unesite broj target racuna na koji zelite prenijeti sredstva:");

			int broj2 = input.nextInt();
			int index = -1;
			provjeraRacuna2 = false;

			// prodji kroz listu racuna i uporedi uneseni btoj od strane korisnika sa listom kreiranih racuna
			for (KreirajRacun object : racuni) {
				index++;
				if (object.getBrojRacuna() == broj2) {
					provjeraRacuna2 = true;
					targetRacun = racuni.get(index);
					break;
				}
			}
		}
		//nakon provjere racuna odredjujemo iznos novca koji ce se prebaciti
		System.out.println("Unesite iznos novca za transfer: ");
		double novac = input.nextDouble();
		
		//provjeravamo da li je iznos koji se zeli prebaciti veci od iznosa koji je na racunu
		while(novac > sourceRacun.getStanjeRacuna()) {
			System.out.println("Unijeli ste vise nego sto imate na racunu, unesite drugi iznos: ");
			novac = input.nextDouble();
		}
		//setujemo nova stanja racuna za source kao i za target racun gdje se od postojeceg stanja source racuna oduzima iznos koji se koristio 
		//za transfer te se tako postavlja novo stanje source racuna a na postojece stanje target racuna se dodaje iznos odredjen za transfer i postavlja se novo stanje target racuna
		targetRacun.setStanjeRacuna(novac + targetRacun.getStanjeRacuna());
		sourceRacun.setStanjeRacuna(sourceRacun.getStanjeRacuna() - novac);
	}
}
