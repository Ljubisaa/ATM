package bankovniRacun;

import java.util.Scanner;

public class Transfer {

	private int source;
	private int target;
	private double iznosTransfera;

	Scanner input = new Scanner(System.in);

	public void izvrsenjeTransfera() throws Exception {

		System.out.println("Unesite broj racuna sa koga izvrsavate transfer: ");
		source = input.nextInt();
		System.out.println("Unesite broj racuna na koji izvrsavate transfer: ");
		target = input.nextInt();
		if (!provjeraRacuna(source) || !provjeraRacuna(target)) {
			System.out.println("Jedan ili oba racuna su nepostojeci, pokusajte ponovo.\n");
			izvrsenjeTransfera();
		} else {
			prebacivanjeNovca(prviRacun(source), drugiRacun(target));

		}
	}

	private boolean provjeraRacuna(int brRacuna) {
		for (Racun lista : Racun.getListaRacuna()) {
			if (lista.getBrojRacuna() == brRacuna) {
				return true;
			}
		}
		return false;
	}

	private Racun prviRacun(int source) {
		for (Racun korisnik : Racun.getListaRacuna()) {
			if (korisnik.getBrojRacuna() == source) {
				return korisnik;
			}
		}
		return Racun.getListaRacuna().get(0);
	}

	private Racun drugiRacun(int target) {
		for (Racun korisnik : Racun.getListaRacuna()) {
			if (korisnik.getBrojRacuna() == target) {
				return korisnik;
			}
		}
		return Racun.getListaRacuna().get(0);
	}

	private void prebacivanjeNovca(Racun posiljalac, Racun primalac) throws Exception {
		System.out.println("Unesite iznos transfera: ");
		iznosTransfera = input.nextDouble();

		if (posiljalac.getIznos() >= iznosTransfera && iznosTransfera > 0) {
			posiljalac.setIznos(posiljalac.getIznos() - iznosTransfera);
			primalac.setIznos(primalac.getIznos() + iznosTransfera);
			System.out.println("Uspjesno ste obavili transfer.");
		} else {
			System.out.println(
					"Iznos koji ste unijeli je ili veci od stanja na racunu sa kojeg prebacujete ili je jednak nuli."
							+ " Molimo pokusajte ponovo.");
			izvrsenjeTransfera();
		}
		input.close();
	}

}
