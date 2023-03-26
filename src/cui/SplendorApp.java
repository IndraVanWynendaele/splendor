package cui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Edele;
import domein.Ontwikkelingskaart;
import domein.Speler;
import dtos.SpelerDTO;

public class SplendorApp {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private int keuzeKeuzeMenu;
	private List<SpelerDTO> spelersDTO;
	
	public SplendorApp(DomeinController dc) {
		this.dc = dc;
		spelersDTO = new ArrayList<>();
	}
	
	public void start() {
		keuzeKeuzeMenu = toonKeuzeMenu();
		while(keuzeKeuzeMenu != 3) {
			switch(keuzeKeuzeMenu) {
				case 1 -> {
					valideerGegevensInput();
					keuzeKeuzeMenu = 0;
				}
				case 2 -> {
					if(dc.controleerAantalSpelers()) {
						dc.startSpel();
						System.out.println("\n-- Spel gestart --");
						System.out.println("\n-- Overzicht spelers --");
						toonOverzichtSpelers();
						System.out.println("\n-- Overzicht spel --");
						toonOverzichtSpel();
					}	
				}
				default	-> {
					System.out.println();
					keuzeKeuzeMenu = toonKeuzeMenu();
				}
			}
			if(keuzeKeuzeMenu==2)
				break;			
			keuzeKeuzeMenu = toonKeuzeMenu();
		}
	}	
	
	
	private void toonOverzichtSpelers() {
		dc.isStartSpeler();
		spelersDTO = dc.geefSpelerDTOs();
		String uitvoerGeg = "";
		uitvoerGeg+=String.format("%30s", "");
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.gebruikersnaam());
		uitvoerGeg += String.format("\nTotaal aantal prestigepunten: ");
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.totaalAantalPrestigepunten());
		uitvoerGeg += String.format("\nIs aan de beurt:%14s","");
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.isAanDeBeurt()==true?"ja":"nee");
		uitvoerGeg += String.format("\nIs startspeler:%15s","");	
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.isStartspeler()==true?"ja":"nee");
		uitvoerGeg += String.format("\nOntwikkelingskaarten in bezit:");
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.ontwikkelingskaartenInBezit());
		uitvoerGeg += String.format("\nEdesteenfiche in bezit:%7s","");
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.edelsteenfichesInBezit());
		uitvoerGeg += String.format("\nEdelen in bezit:%14s","");
		
		for(SpelerDTO speler: spelersDTO)
			uitvoerGeg += String.format("%15s", speler.edelenInBezit());
		uitvoerGeg += String.format("\n");
		
		System.out.printf("%s%n", uitvoerGeg);
		
	}

	private void toonOverzichtSpel() {
		String uitvoerSpel="";
		uitvoerSpel+= String.format("De Beschikbare edele:%9s", "");
		Edele[] beschikbareEdelen = dc.getEdeleSpelers();
		uitvoerSpel += String.format("%15s", beschikbareEdelen.length);
		/*for(Edele e : beschikbareEdelen) {
			uitvoerSpel += String.format("%15s", e);
		}*/
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Ontwikkelingskaarten niveau1:", "");
		List<Ontwikkelingskaart> niveau1 = dc.getNiveau1();
		for(Ontwikkelingskaart ok1 : niveau1) {
			uitvoerSpel += String.format("");
		}
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Ontwikkelingskaarten niveau2:", "");
		List<Ontwikkelingskaart> niveau2 = dc.getNiveau2();
		for(Ontwikkelingskaart ok2 : niveau2) {
			uitvoerSpel += String.format("");
		}
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Ontwikkelingskaarten niveau3:", "");
		List<Ontwikkelingskaart> niveau3 = dc.getNiveau3();
		for(Ontwikkelingskaart ok3 : niveau3) {
			uitvoerSpel += String.format("");
		}
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Voorraad Smaragden:%11s", "");
		uitvoerSpel += String.format("%15d",dc.getSmaragdAantal().getAantal());
		
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Voorraad Saffieren:%11s", "");
		uitvoerSpel += String.format("%15d",dc.getSaffierAantal().getAantal());
		
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Voorraad Robijnen:%12s", "");
		uitvoerSpel += String.format("%15d",dc.getRobijnAantal().getAantal());
		
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Voorraad Onyxen:%14s", "");
		uitvoerSpel += String.format("%15d",dc.getOnyxAantal().getAantal());
		
		uitvoerSpel += String.format("\n");
		uitvoerSpel+= String.format("Voorraad Diamanten:%11s", "");
		uitvoerSpel += String.format("%15d",dc.getDiamantAantal().getAantal());
		
		
		System.out.printf("%s%n", uitvoerSpel);
	}
	
	private int toonKeuzeMenu() {
		do {
			try {
				System.out.println("-- Keuzemenu --");
				System.out.println("1. Een speler aanmelden");
				System.out.println("2. Stoppen met aanmelden en het spel starten");
				System.out.println("3. De applicatie stoppen");
				System.out.print("Maak je keuze (1-3): ");
				keuzeKeuzeMenu = input.nextInt();
			}catch(InputMismatchException exc) {
				System.out.println("Keuze moet een nummer zijn!\n");
			}finally {
				input.nextLine();
			}
		}while(keuzeKeuzeMenu < 1 || keuzeKeuzeMenu > 3);
		return keuzeKeuzeMenu;
	}
	
	private void valideerGegevensInput() {
		String gebruikersnaam = "";
		int geboortejaar = 0;
		boolean finished = false;
		
		do {
			
			try {
				System.out.print("Geef je gebruikersnaam in: ");
				gebruikersnaam = input.nextLine();
				
				
				System.out.print("Geef je geboortejaar in: ");
				geboortejaar = input.nextInt();
				
				Speler sp = new Speler(gebruikersnaam, geboortejaar);
				if(dc.spelerAlAangemeld(sp)) {
					if(dc.meldAan(sp)) {
						System.out.printf("Je bent aangemeld als %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());
					}
					else{
						String antwoord;
						do {
						System.out.print("De speler is nog niet geregistreerd, wil je dit doen?");
						input.nextLine();
						antwoord = input.nextLine().toLowerCase();
						}while(!(antwoord.equals("ja")||antwoord.equals("nee"))); // testen of dit werkt
						if(antwoord.equals("ja")) {
							dc.voegToe(sp);
							dc.meldAan(sp);
							System.out.printf("Je hebt een nieuwe speler geregistreerd met gebruikersnaam %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());	
						}else {
							valideerGegevensInput();
						}
					}
				}else {
					input.nextLine();
					throw new IllegalArgumentException("Deze speler is al aangemeld!\n");
				}
				
				finished = true;
			}catch(InputMismatchException e) {
				System.out.println("Verkeerde invoer, geboortejaar moet een getal zijn");
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}/*finally {
				input.nextLine();
			} */
		}while(!finished);
	} 

}