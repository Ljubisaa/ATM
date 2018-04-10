package bankovniRacun;

import java.util.Scanner;

public class Main  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		ImportFiles importFile = new ImportFiles();
		importFile.ucitajPodatkeIzFajla1();
		
		while (true) {
		try{
			System.out.println("Dobrodosli u nasu banku, izaberite jednu od opcija: \n" 
		+ "1. Kreirajte racun\n"
		+ "2. Izvrsi transfer novca\n" 
		+ "3. Ispisi detalje racuna\n" 
		+ "4. Izadji");
			int broj = input.nextInt();
			input.nextLine();
			switch (broj) {

			case 1:
				Racun racun = new Racun();
				System.out.println("Unesite vase ime: ");
				racun.setIme(input.nextLine());
				System.out.println("Unesite broj racuna: ");
				racun.setBrojRacuna(input.nextInt());
				System.out.println("Unesite iznos koji polazete: ");
				racun.setIznos(input.nextDouble());
				System.out.println("Uspjesto ste kreirali racun.");
				
				importFile.unosPodataka1(racun.getBrojRacuna());
				break;
				
			case 2:
				Transfer transfer = new Transfer();
				transfer.izvrsenjeTransfera();
				break;
				
			case 3: 
				System.out.println("Izaberite broj racuna o kome zelite informacije: ");
				int unosBroja = input.nextInt();
				boolean postoji = true;
				for(Racun korisnik: Racun.getListaRacuna()){
					if(korisnik.getBrojRacuna() == unosBroja){
						System.out.println("Korisnik: " + korisnik.getIme() + ", broj racuna: " + korisnik.getBrojRacuna()
						+ ", iznos na racunu: " + korisnik.getIznos());
						break;
					}
					else{
						postoji = false;
					}
				}
				if(!postoji){
					System.out.println("Unijeli ste pogresan broj racuna.\n");
				}
				if(Racun.getListaRacuna().isEmpty()){
					System.out.println("Nema otvorenih racuna.");
				}
				break;
				case 4: 
					System.out.println("Hvala vam na koristenju nasih usluga.");
					input.close();
			System.exit(1);
			}
          
	
			}
		catch(Exception ex){
			System.out.println("Pogresan unos, pokusajte ponovo.");
			input.nextLine();
		}
		
	}


}
	}
