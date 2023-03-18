package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Speler;

public class SplendorApp {

	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	//private boolean gebruikerGedaan;
	
	private List<Speler> dbSpelers = new ArrayList<>();
	private int keuze;
	private int keuzeKeuzeMenu;
	
	public SplendorApp(DomeinController dc) {
		this.dc= dc;
	}
	public void start() {
		toonKeuzeMenu();
		do {
			toonKeuzeMenu();
			toonSpelers();
			maakKeuze();
			// switch voor keuze speler
		}while(keuzeKeuzeMenu == 1);
		
		
	}
	
	private int toonKeuzeMenu() {
		do {
			System.out.println("1. Een speler aanmelden");
			System.out.println("2. Stoppen met aanmelden en het spel starten");
			System.out.println("3. De applicatie stoppen");
			keuzeKeuzeMenu = input.nextInt();
		}while(keuzeKeuzeMenu < 1 || keuzeKeuzeMenu > 3);
		return keuzeKeuzeMenu;
	}
	
	public String toonSpelers() {
		dbSpelers = dc.geefSpelers();
		String spelerLijst = "";
		int index = 1;
		System.out.printf("%15s %15s%15s", "Speler", "Gebruikersnaam", "Geboortejaar");
		for(Speler s: dbSpelers) 
			spelerLijst += String.format("%15d:%15s%15d",index++, s.getGebruikersnaam(), s.getGeboortejaar());
		return spelerLijst;		
	}
	
	public int maakKeuze() {
		dbSpelers = dc.geefSpelers();
		do {
			System.out.println("Geef het nummer van de speler waarmee je wil spelen: ");
			keuze = input.nextInt();
		}while(keuze > dbSpelers.size() + 1);
		return keuze;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
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
