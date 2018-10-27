package zadaca;

import java.util.ArrayList;
import java.util.Scanner;

public class KreirajRacun {

	private int brojRacuna;
	private String imeKorisnika;
	private double stanjeRacuna;

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public double getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(double stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	//metoda kojom cemo vrsiti kreiranje racuna
	public static void kreiraj(ArrayList<KreirajRacun> racuni, Scanner input) {
		KreirajRacun racun = new KreirajRacun();
		racuni.add(racun);
		int brojac = racuni.size();

		//Kod kreiranja racuna trazimo da korisnik unese ime na koji ce biti kreiran racun
		System.out.println("Unesite vase ime: ");
		String ime = input.nextLine();
		ime = input.nextLine();
		//kod kreiranja racuna postavlja se ime korisnika na zadnji racun u listi, ukolio je lista prazna bila znaci da ce ime biti dodano
		//na prvi racun koji se kreirao... i tako jedan za drugim kako se bude kreirao.
		racuni.get(brojac - 1).setImeKorisnika(ime);

		//kreiranje broja racuna za korisnika i provjera da li vec ima postojeci broj, ukoliko je lista racuna prazna tj kreira se prvi 
		//racun onda ce se dodijeliti jedan random broj korisniku
		boolean imaBroj = false;
		int broj = -1;
		while (!imaBroj) {
			if(racuni.size() == 0) {
				broj = (int) (Math.random() * 8999 + 1001);
				break;
			}
			broj = (int) (Math.random() * 8999 + 1001);
			imaBroj = true;
			for (KreirajRacun object : racuni) {
				if (object.getBrojRacuna() == broj) {
					imaBroj = false;
					break;
				}
			}
		}
		//nakon provjera, i dodijeljivanja imena korisnika racunu, setujemo i dodijeljeni broj racuna i postavljamo pocetno stanje na 0.00
		racuni.get(brojac - 1).setBrojRacuna(broj);
		racuni.get(brojac - 1).setStanjeRacuna(0.00);
		
		System.out.println("**************************");
		System.out.println("Vas broj racuna je: " + racun.getBrojRacuna() + 
				"\nTrenutno stanje vaseg racuna je : " + racun.getStanjeRacuna() + " KM.");
		System.out.println("**************************");
	}
}
