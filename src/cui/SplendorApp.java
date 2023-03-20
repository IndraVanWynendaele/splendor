package cui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Speler;
import persistentie.SpelerMapper;

public class SplendorApp {

	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	//private boolean gebruikerGedaan
	
	private List<Speler> dbSpelers = new ArrayList<>();
	private int keuzeKeuzeMenu;
	private SpelerMapper sm;
	private String gebruikersnaam;
	private int geboortejaar;
	
	public SplendorApp(DomeinController dc) {
		this.dc = dc;
	}
	public void start() {		
		System.out.println("Maak je keuze (1-3): ");
		keuzeKeuzeMenu = toonKeuzeMenu();
	}
	
	private int toonKeuzeMenu() {
		do {
			try {
				System.out.println("1. Een speler aanmelden");
				System.out.println("2. Stoppen met aanmelden en het spel starten");
				System.out.println("3. De applicatie stoppen");
				keuzeKeuzeMenu = input.nextInt();
			}catch(InputMismatchException exc) {
				System.out.println("Keuze moet een nummer zijn!");
			}finally {
				input.nextLine();
			}
		}while(keuzeKeuzeMenu < 1 || keuzeKeuzeMenu > 3);
		return keuzeKeuzeMenu;
	}	
}