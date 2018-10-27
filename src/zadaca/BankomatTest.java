package zadaca;

import java.util.ArrayList;
import java.util.Scanner;

public class BankomatTest {

	public static void main(String[] args) {

		System.out.println("Dobrodosli u bankomat");
		System.out.println("**************************");

		Scanner input = new Scanner(System.in);
		
		ArrayList<KreirajRacun> racuni = new ArrayList<KreirajRacun>();
		
		int korisnikovUnos = -1;

		while (korisnikovUnos != 0) {
			System.out.println("Izaberite zeljenu opciju: " + 
		"\n**************************" +
		"\n 1.Kreiraj novi racun" + 
		"\n 2.Transfer novca sa jednog racuna na drugi" + 
		"\n 3.Uplata na vlastiti racun" + 
		"\n 4.Detalji racuna" +
		"\n 0.Izlaz iz izbornika");
			System.out.println("**************************");
			
			korisnikovUnos = input.nextInt();
			
			switch(korisnikovUnos) {
			case 0: break;
			case 1: KreirajRacun.kreiraj(racuni, input); break;
			case 2: PrebaciNovac.prebaci(racuni, input); break;
			case 3: UplataNaVlastitiRacun.uplata(racuni, input); break;
			case 4: DetaljiRacuna.detalji(racuni, input); break;
			
			default: System.out.println("Pogresno ste unijeli opciju, unesite ponovo!");
			
			korisnikovUnos = input.nextInt();
			}
		}		
		System.out.println("Izabrali ste izlaz iz aplikacije.\nHvala na povjerenju!\nDodjite nam ponovo.");		
		input.close();
	}
}
