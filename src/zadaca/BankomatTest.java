package zadaca;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankomatTest {

	public static void main(String[] args) throws Exception {

		System.out.println("Dobrodosli u bankomat");
		System.out.println("**************************");

		Scanner input = new Scanner(System.in);
		
		ArrayList<KreirajRacun> racuni = new ArrayList<KreirajRacun>();
		ArrayList<String> dataString = new ArrayList<String>();
		
Scanner log = new Scanner(new File("data.txt"));
		
		// prolazi kroz log, ako je prazan necemo i pokupiti sve linije u arraylistu stringova
		while(log.hasNextLine()) {
			dataString.add(log.nextLine());
		}
		log.close();
	
		//napravit objekte od tih stringova, razdijeliti stringove i dodijet poljima CreateAccounts objekta
		for(int i=0;i<dataString.size();i++) {
		KreirajRacun racun = new KreirajRacun();
		racuni.add(racun);
		//pokupio broj s poèetka stringa
		racuni.get(i).setBrojRacuna(Integer.parseInt(dataString.get(i).substring(0, 4)));
		//na kojem mjestu u stringu se nalazi space da bi do tada odredili duzinu novca (tj broj cifara)
	
		int indexOfSpaceAfterDouble =5+ dataString.get(i).substring(5,dataString.get(i).length()).indexOf(" ");
		racuni.get(i).setStanjeRacuna(Double.parseDouble(dataString.get(i).substring(5, indexOfSpaceAfterDouble)));
		racuni.get(i).setImeKorisnika(dataString.get(i).substring(indexOfSpaceAfterDouble+1, dataString.get(i).length()));
		//pokupili smo sva polja za objekat CreateAccount i dodijelili mu.
		}
		
		
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
			
			korisnikovUnos = reTry(input);
			
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
	
	public static int reTry(Scanner input) {

		 try {
		     return input.nextInt();
		 } catch (InputMismatchException ex) {
		     input.nextLine(); //Ova linija prebacuje kursor na sljedecu liniju
		     System.out.println("Unos treba biti tipa integer, pokusajte ponovo:");
		     return reTry(input);
		 }

		 }
	
	public static double reTryDouble(Scanner input) {

		 try {
		     return input.nextDouble();
		 } catch (InputMismatchException ex) {
		     input.nextLine(); //Ova linija koda prebacuje kursor na sljedecu liniju
		     System.out.println("Unos treba biti tipa double, pokusajte ponovo:");
		     return reTry(input);
		 }
	}
}
