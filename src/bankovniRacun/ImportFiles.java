package bankovniRacun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImportFiles {

	Path path;
	File file;
	BufferedReader reader;
	BufferedWriter writer;
	FileWriter fw;
	Racun racun;

	String line;

	public void unosPodataka1(int brojRacuna) throws IOException {
		File file = new File("banka.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		fw = new FileWriter(file.getAbsolutePath(), true);
		writer = new BufferedWriter(fw);

		for (Racun korisnik : Racun.getListaRacuna()) {
			if (korisnik.getBrojRacuna() == brojRacuna) {
				System.out.println();
				writer.write(korisnik.getIme() + " ");
				writer.write(korisnik.getBrojRacuna() + " ");
				writer.write(korisnik.getIznos() + " ");
				writer.newLine();
			}
		}
		writer.close();
	}

	public void ucitajPodatkeIzFajla1() throws Exception {

		path = Paths.get("banka.txt");
		reader = Files.newBufferedReader(path);

		while ((line = reader.readLine()) != null) {
			racun = new Racun();
			String[] niz = line.split(" ");

			racun.setIme(niz[0]);
			racun.setBrojRacuna(Integer.parseInt(niz[1]));
			racun.setIznos(Double.parseDouble(niz[2]));
			Racun.getListaRacuna().add(racun);
		}
		reader.close();
	}

}
