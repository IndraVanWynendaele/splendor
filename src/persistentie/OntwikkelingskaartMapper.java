package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Ontwikkelingskaart;
import util.EdelsteenSoort;

public class OntwikkelingskaartMapper {
	public List<Ontwikkelingskaart> lijstKaarten() {
		List<Ontwikkelingskaart> lijstKaarten = new ArrayList<>();
	
		// Kaart parameters -> niveau, prestige, edelsteensoort bonus
		// kaart aanmaken, kost toevoegen, kaart in lijst steken
		
		// niveau 1 -> a
		Ontwikkelingskaart a1 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.ONYX);
		a1.voegKostToe(4, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(a1);
		
		Ontwikkelingskaart a2 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a2.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a2.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a2.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a2.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a2);
		
		Ontwikkelingskaart a3 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a3.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a3.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a3);
		
		Ontwikkelingskaart a4 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a4.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a4.voegKostToe(3, EdelsteenSoort.ROBIJN);
		a4.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a4);
		
		Ontwikkelingskaart a5 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a5.voegKostToe(3, EdelsteenSoort.DIAMANT);
		lijstKaarten.add(a5);
		
		Ontwikkelingskaart a6 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a6.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a6.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a6.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a6);
		
		Ontwikkelingskaart a7 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a7.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a7.voegKostToe(1, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(a7);
		
		Ontwikkelingskaart a8 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a8.voegKostToe(3, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(a8);
		
		Ontwikkelingskaart a9 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a9.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a9.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a9);
		
		Ontwikkelingskaart a10 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a10.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a10);
		
		Ontwikkelingskaart a11 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a11.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a11.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a11.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(a11);
		
		Ontwikkelingskaart a12 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a12.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a12.voegKostToe(1, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(a12);
		
		Ontwikkelingskaart a13 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a13.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a13.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(a13);
		
		Ontwikkelingskaart a14 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a14.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a14.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a14.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a14.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a14);
		
		Ontwikkelingskaart a15 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a15.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a15.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a15.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a15.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a15);
		
		Ontwikkelingskaart a16 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a16.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a16.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a16.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a16);
		
		Ontwikkelingskaart a17 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a17.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a17.voegKostToe(3, EdelsteenSoort.SAFFIER);
		a17.voegKostToe(1, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(a17);
		
		Ontwikkelingskaart a18 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a18.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a18.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a18.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a18.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a18);
		
		Ontwikkelingskaart a19 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a19.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a19.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a19.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a19);
		
		Ontwikkelingskaart a20 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a20.voegKostToe(3, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(a20);
		
		// niveau 2 -> b
		
		
		// niveau 3 -> c
		
		return lijstKaarten;
	}

}