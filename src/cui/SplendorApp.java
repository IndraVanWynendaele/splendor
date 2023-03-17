package cui;

import java.util.Scanner;

import domein.DomeinController;
import persistentie.SpelerMapper;

public class SplendorApp {

	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	//private boolean gebruikerGedaan;
	
	public SplendorApp(DomeinController dc) {
		this.dc= dc;
	}
	public void start() {
		System.out.print("test");
		SpelerMapper mp = new SpelerMapper();
		System.out.print(mp.geefSpeler("gebruiker1",2004 ));
		/* test
		 * String naam;
		int jaar;
		
		System.out.print("Geef de gebruikersnaam: ");
		naam= input.nextLine();
		System.out.print("Geef je geboortjejaar (formaat: jjjj): ");
		jaar=input.nextInt();
		
		meldAan(naam,jaar);
		
		//List<Spelers>
		//spelers=sRepo.getSpelers();
		//Speler startSpeler=spelers.get(0);
		//spelers.remove(0);
		
		int i=1;
		do {
			i++;
			System.out.printf("Geef de gebruikersnaam van speler %d: ",i+1);
			naam= input.nextLine();
			System.out.printf("Geef je geboortjejaar van speler %d (formaat: jjjj): ",i+1);
			jaar=input.nextInt();
				
			meldAan(naam,jaar);
				
			System.out.printf("Wil je nog een %d de speler toevoegen? (1=ja, 2=nee)");
			int keuze = input.nextInt();
			switch(keuze) {
			case 1 -> gebruikerGedaan=false;
			case 2 -> gebruikerGedaan=true;
			default -> throw new IllegalArgumentException("Je moet 1 of 2 ingeven");
			}
			if (i==4) {
				 gebruikerGedaan=true;
			}
		}while(!gebruikerGedaan);
		 * */
	}
	
}
