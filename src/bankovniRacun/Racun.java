package bankovniRacun;

import java.util.ArrayList;

public class Racun {

	private int brojRacuna;
	private String ime;
	private double iznos;

	private static ArrayList<Racun> listaRacuna = new ArrayList<>();

	public Racun() {
		listaRacuna.add(this);
	}

	public Racun(int brojRacuna, String ime, double iznos) {
		this.brojRacuna = brojRacuna;
		this.ime = ime;
		this.iznos = iznos;
		listaRacuna.add(this);
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) throws Exception {

		if (provjeraBrojaRacuna(brojRacuna)) {
			System.out.println("Broj racuna vec postoji.");
			listaRacuna.remove(this);
		}
		if (brojRacuna < 0) {
			System.out.println("Broj racuna ne smije biti negativan broj.");
			listaRacuna.remove(this);
		} else {
			this.brojRacuna = brojRacuna;
		}
	}

	public boolean provjeraBrojaRacuna(int brojRacuna) throws Exception {
		for (Racun korisnik : listaRacuna) {
			if (korisnik.getBrojRacuna() == brojRacuna)
				return true;
		}
		return false;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) throws Exception {
		if (provjeraImena(ime)) {
			System.out.println("Ime vec postoji.");
			listaRacuna.remove(this);
		} else {
			this.ime = ime;
		}
	}

	public boolean provjeraImena(String ime) throws Exception {
		for (Racun korisnik : listaRacuna) {
			if (korisnik.getIme() == ime)
				return true;
		}
		return false;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) throws Exception {
		if (iznos < 0) {
			System.out.println("Iznos ne smije biti manji od nule.");
			listaRacuna.remove(this);
		} else {
			this.iznos = iznos;
		}
	}

	public static ArrayList<Racun> getListaRacuna() {
		return listaRacuna;
	}
}
