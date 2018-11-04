package zadaca;

import java.util.ArrayList;
import java.util.Scanner;

public class UplataNaVlastitiRacun {
	
	public static void uplata(ArrayList<KreirajRacun> racuni, Scanner input) {
		
		KreirajRacun racun = new KreirajRacun();
		int broj = -1;
	
		while(broj < 1000 || broj >= 10000) {
			System.out.println("Unesite vas broj racuna: ");
			broj = BankomatTest.reTry(input);
		}
		
		int index = -1; 
		boolean provjeraRacuna = false;
		//prodji kroz listu racuna i uporedi uneseni broj sa brojevima racuna
		for(KreirajRacun object: racuni) {
			index++;
			if(object.getBrojRacuna() == broj) {
				provjeraRacuna = true;
				racun = racuni.get(index);
				break;
			}
		}
		//ukoliko je provjera racuna true tj imamo podudaranje unesenog broja sa racunom iz liste ispisi sljedece izjave
		if(provjeraRacuna) {
			System.out.println("Zdravo " + racun.getImeKorisnika());
			System.out.println("Unesite iznos novca koji zelite uplatiti na vas racun: ");
			double iznosUplate = BankomatTest.reTryDouble(input);
			//ukoliko je uneseni iznos uplate za transfer manji ili jednako od nule ispisi poruku korisniku da unese iznos veci od nule
			while(iznosUplate <= 0.0) {
				System.out.println("Unesite iznos veci od nule!");
				iznosUplate = BankomatTest.reTryDouble(input);
			}
			//kada je uneseni broj jednak kreiranom racunu setuj novo stanje racuna dodavajuci iznos za transfer na postojece stanje racuna
			racun.setStanjeRacuna(racun.getStanjeRacuna() + iznosUplate);
			System.out.println("**************************");
			System.out.println("Postovanje, " + racun.getImeKorisnika() + "\nVase trenutno stanje na racunu je: " + racun.getStanjeRacuna() + " KM.");
			System.out.println("**************************");
			
			//ukoliko provjera racuna je false, ispisati poruku korisniku da nije unesen tacan broj racuna
		}else {
			System.out.println("Niste unijeli tacan broj racuna.");
		}	
	}
}
