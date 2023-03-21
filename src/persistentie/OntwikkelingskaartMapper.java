package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Ontwikkelingskaart;
import util.EdelsteenSoort;

public class OntwikkelingskaartMapper {

	public List<Ontwikkelingskaart> lijstKaartenNiveau1() {
		List<Ontwikkelingskaart> lijstKaartenNiveau1 = new ArrayList<>();
	
		// Kaart parameters -> niveau, prestige, edelsteensoort bonus
		// kaart aanmaken, kost toevoegen, kaart in lijst steken
		
		// niveau 1 -> a
		Ontwikkelingskaart a1 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.ONYX);
		a1.voegKostToe(4, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau1.add(a1);
		
		Ontwikkelingskaart a2 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a2.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a2.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a2.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a2.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a2);
		
		Ontwikkelingskaart a3 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a3.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a3.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a3);
		
		Ontwikkelingskaart a4 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a4.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a4.voegKostToe(3, EdelsteenSoort.ROBIJN);
		a4.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a4);
		
		Ontwikkelingskaart a5 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a5.voegKostToe(3, EdelsteenSoort.DIAMANT);
		lijstKaartenNiveau1.add(a5);
		
		Ontwikkelingskaart a6 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a6.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a6.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a6.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a6);
		
		Ontwikkelingskaart a7 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a7.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a7.voegKostToe(1, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau1.add(a7);
		
		Ontwikkelingskaart a8 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a8.voegKostToe(3, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau1.add(a8);
		
		Ontwikkelingskaart a9 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a9.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a9.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a9);
		
		Ontwikkelingskaart a10 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a10.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a10);
		
		Ontwikkelingskaart a11 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a11.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a11.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a11.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a11);
		
		Ontwikkelingskaart a12 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a12.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a12.voegKostToe(1, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau1.add(a12);
		
		Ontwikkelingskaart a13 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a13.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a13.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau1.add(a13);
		
		Ontwikkelingskaart a14 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a14.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a14.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a14.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a14.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a14);
		
		Ontwikkelingskaart a15 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a15.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a15.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a15.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a15.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a15);
		
		Ontwikkelingskaart a16 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a16.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a16.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a16.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a16);
		
		Ontwikkelingskaart a17 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a17.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a17.voegKostToe(3, EdelsteenSoort.SAFFIER);
		a17.voegKostToe(1, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau1.add(a17);
		
		Ontwikkelingskaart a18 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a18.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a18.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a18.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a18.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a18);
		
		Ontwikkelingskaart a19 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a19.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a19.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a19.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a19);
		
		Ontwikkelingskaart a20 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a20.voegKostToe(3, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau1.add(a20);
		
		Ontwikkelingskaart a21 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a21.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a21.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a21.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a21.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a21);
		
		Ontwikkelingskaart a22 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a22.voegKostToe(3, EdelsteenSoort.DIAMANT);
		a22.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a22.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a22);
		
		Ontwikkelingskaart a23 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a23.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a23.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a23);
		
		Ontwikkelingskaart a24 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a24.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a24.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a24.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a24);
		
		Ontwikkelingskaart a25 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a25.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a25);
		
		Ontwikkelingskaart a26 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a26.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a26.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a26.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a26.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a26);
		
		Ontwikkelingskaart a27 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a27.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a27.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a27.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a27.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a27);
		
		Ontwikkelingskaart a28 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a28.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a28.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a28);
		
		Ontwikkelingskaart a29 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a29.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a29.voegKostToe(3, EdelsteenSoort.SMARAGD);
		a29.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a29);
		
		Ontwikkelingskaart a30 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a30.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a30.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a30.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a30);
		
		Ontwikkelingskaart a31 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.DIAMANT);
		a31.voegKostToe(4,  EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau1.add(a31);
		
		Ontwikkelingskaart a32 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.SMARAGD);
		a32.voegKostToe(4, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a32);
		
		Ontwikkelingskaart a33 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a33.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a33.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a33);
		
		Ontwikkelingskaart a34 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a34.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a34.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a34);
		
		Ontwikkelingskaart a35 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.ROBIJN);
		a35.voegKostToe(4, EdelsteenSoort.DIAMANT);
		lijstKaartenNiveau1.add(a35);
		
		Ontwikkelingskaart a36 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a36.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a36.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a36);
		
		Ontwikkelingskaart a37 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a37.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a37.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a37.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a37.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a37);
		
		Ontwikkelingskaart a38 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.SAFFIER);
		a38.voegKostToe(4, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a38);
		
		Ontwikkelingskaart a39 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a39.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a39.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a39.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a39.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaartenNiveau1.add(a39);
		
		Ontwikkelingskaart a40 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a40.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a40.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a40.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a40.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau1.add(a40);

		
		return lijstKaartenNiveau1;		
	}

	
	
	public List<Ontwikkelingskaart> lijstKaartenNiveau2(){
		List<Ontwikkelingskaart> lijstKaartenNiveau2 = new ArrayList<>();
		
		// niveau 2 -> b
		
		Ontwikkelingskaart b1 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b1.voegKostToe(5, EdelsteenSoort.DIAMANT);
		lijstKaartenNiveau2.add(b1);
		
		Ontwikkelingskaart b2 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ONYX);
		b2.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b2.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b2.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau2.add(b2);
		
		Ontwikkelingskaart b3 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ROBIJN);
		b3.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b3.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b3.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b3);
		
		Ontwikkelingskaart b4 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SMARAGD);
		b4.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b4.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b4.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b4);
		
		Ontwikkelingskaart b5 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b5.voegKostToe(1, EdelsteenSoort.SMARAGD);
		b5.voegKostToe(4, EdelsteenSoort.ROBIJN);
		b5.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b5);
		
		Ontwikkelingskaart b6 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b6.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b6.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b6.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b6);
		
		Ontwikkelingskaart b7 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SMARAGD);
		b7.voegKostToe(3,  EdelsteenSoort.DIAMANT);
		b7.voegKostToe(2,  EdelsteenSoort.SMARAGD);
		b7.voegKostToe(3,  EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b7);
		
		Ontwikkelingskaart b8 = new Ontwikkelingskaart(2,  2, EdelsteenSoort.SAFFIER);
		b8.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b8.voegKostToe(1, EdelsteenSoort.ROBIJN);
		b8.voegKostToe(4, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b8);
		
		Ontwikkelingskaart b9 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b9.voegKostToe(5, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b9);
		
		Ontwikkelingskaart b10 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b10.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b10.voegKostToe(5, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b10);
		
		Ontwikkelingskaart b11 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SAFFIER);
		b11.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b11.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b11.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b11);
		
		Ontwikkelingskaart b12 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ROBIJN);
		b12.voegKostToe(2,  EdelsteenSoort.DIAMANT);
		b12.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b12.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b12);
		
		Ontwikkelingskaart b13 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.SMARAGD);
		b13.voegKostToe(6, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau2.add(b13);
		
		Ontwikkelingskaart b14 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b14.voegKostToe(1, EdelsteenSoort.DIAMANT);
		b14.voegKostToe(4, EdelsteenSoort.SAFFIER);
		b14.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau2.add(b14);
		
		Ontwikkelingskaart b15 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SAFFIER);
		b15.voegKostToe(5, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau2.add(b15);
		
		Ontwikkelingskaart b16 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b16.voegKostToe(5, EdelsteenSoort.SAFFIER);
		b16.voegKostToe(3, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau2.add(b16);
		
		Ontwikkelingskaart b17 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b17.voegKostToe(4,  EdelsteenSoort.DIAMANT);
		b17.voegKostToe(2,  EdelsteenSoort.SAFFIER);
		b17.voegKostToe(1,  EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b17);
		
		Ontwikkelingskaart b18 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.DIAMANT);
		b18.voegKostToe(5, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b18);
		
		Ontwikkelingskaart b19 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.DIAMANT);
		b19.voegKostToe(6,  EdelsteenSoort.DIAMANT);
		lijstKaartenNiveau2.add(b19);
		
		Ontwikkelingskaart b20 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b20.voegKostToe(1, EdelsteenSoort.SAFFIER);
		b20.voegKostToe(4, EdelsteenSoort.SMARAGD);
		b20.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b20);
		
		Ontwikkelingskaart b21 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.SAFFIER);
		b21.voegKostToe(6, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau2.add(b21);
		
		Ontwikkelingskaart b22 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b22.voegKostToe(5,  EdelsteenSoort.SMARAGD);
		b22.voegKostToe(3,  EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b22);
		
		Ontwikkelingskaart b23 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b23.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b23.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b23.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b23);
		
		Ontwikkelingskaart b24 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SAFFIER);
		b24.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b24.voegKostToe(2, EdelsteenSoort.SMARAGD);
		b24.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b24);
		
		Ontwikkelingskaart b25 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ONYX);
		b25.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b25.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b25.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b25);
		
		Ontwikkelingskaart b26 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b26.voegKostToe(5, EdelsteenSoort.SMARAGD);
		lijstKaartenNiveau2.add(b26);
		
		Ontwikkelingskaart b27 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.DIAMANT);
		b27.voegKostToe(5, EdelsteenSoort.ROBIJN);
		b27.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b27);
		
		Ontwikkelingskaart b28 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.ONYX);
		b28.voegKostToe(6, EdelsteenSoort.ONYX);
		lijstKaartenNiveau2.add(b28);
		
		Ontwikkelingskaart b29 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SAFFIER);
		b29.voegKostToe(5, EdelsteenSoort.DIAMANT);
		b29.voegKostToe(5, EdelsteenSoort.SAFFIER);
		lijstKaartenNiveau2.add(b29);
		
		Ontwikkelingskaart b30 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.ROBIJN);
		b30.voegKostToe(6, EdelsteenSoort.ROBIJN);
		lijstKaartenNiveau2.add(b30);
		
		
		return lijstKaartenNiveau2;
	}
	
	public List<Ontwikkelingskaart> lijstKaartenNiveau3(){
		List<Ontwikkelingskaart> lijstKaartenNiveau3 = new ArrayList<>();
		
		// niveau 3 -> c
		
				Ontwikkelingskaart c1 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.ROBIJN);
				c1.voegKostToe(3, EdelsteenSoort.SAFFIER);
				c1.voegKostToe(6,  EdelsteenSoort.SMARAGD);
				c1.voegKostToe(3,  EdelsteenSoort.ROBIJN);
				lijstKaartenNiveau3.add(c1);
				
				Ontwikkelingskaart c2 = new Ontwikkelingskaart(3, 5, EdelsteenSoort.ONYX);
				c2.voegKostToe(7,  EdelsteenSoort.ROBIJN);
				c2.voegKostToe(3,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c2);

				
				Ontwikkelingskaart c3 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.ONYX);
				c3.voegKostToe(3, EdelsteenSoort.SMARAGD);
				c3.voegKostToe(6, EdelsteenSoort.ROBIJN);
				c3.voegKostToe(3, EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c3);
				
				
				Ontwikkelingskaart c4 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.SMARAGD);
				c4.voegKostToe(3, EdelsteenSoort.DIAMANT);
				c4.voegKostToe(6, EdelsteenSoort.SAFFIER);
				c4.voegKostToe(3, EdelsteenSoort.SMARAGD);
				lijstKaartenNiveau3.add(c4);
				
				
				Ontwikkelingskaart c5 = new Ontwikkelingskaart(3, 5, EdelsteenSoort.DIAMANT);
				c5.voegKostToe(3,  EdelsteenSoort.DIAMANT);
				c5.voegKostToe(7, EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c5);
				
				Ontwikkelingskaart c6 = new Ontwikkelingskaart(3, 3, EdelsteenSoort.DIAMANT);
				c6.voegKostToe(3, EdelsteenSoort.SAFFIER);
				c6.voegKostToe(3, EdelsteenSoort.SMARAGD);
				c6.voegKostToe(5, EdelsteenSoort.ROBIJN);
				c6.voegKostToe(3, EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c6);
				
				Ontwikkelingskaart c7 = new Ontwikkelingskaart(3, 5, EdelsteenSoort.ROBIJN);
				c7.voegKostToe(7,  EdelsteenSoort.SMARAGD);
				c7.voegKostToe(3,  EdelsteenSoort.ROBIJN);
				lijstKaartenNiveau3.add(c7);
				
				Ontwikkelingskaart c8 = new Ontwikkelingskaart(3, 3, EdelsteenSoort.SAFFIER);
				c8.voegKostToe(3,  EdelsteenSoort.DIAMANT);
				c8.voegKostToe(3,  EdelsteenSoort.SMARAGD);
				c8.voegKostToe(3,  EdelsteenSoort.ROBIJN);
				c8.voegKostToe(5,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c8);
				
				Ontwikkelingskaart c9 = new Ontwikkelingskaart(3, 3, EdelsteenSoort.SMARAGD);
				c9.voegKostToe(5,  EdelsteenSoort.DIAMANT);
				c9.voegKostToe(3,  EdelsteenSoort.SAFFIER);
				c9.voegKostToe(3,  EdelsteenSoort.ROBIJN);
				c9.voegKostToe(3,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c9);
				
				Ontwikkelingskaart c10 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.ROBIJN);
				c10.voegKostToe(7, EdelsteenSoort.SMARAGD);
				lijstKaartenNiveau3.add(c10);
				
				Ontwikkelingskaart c11 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.SAFFIER);
				c11.voegKostToe(7, EdelsteenSoort.DIAMANT);
				lijstKaartenNiveau3.add(c11);
				
				Ontwikkelingskaart c12 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.ONYX);
				c12.voegKostToe(7, EdelsteenSoort.ROBIJN);
				lijstKaartenNiveau3.add(c12);
				
				Ontwikkelingskaart c13 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.DIAMANT);
				c13.voegKostToe(7,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c13);
				
				Ontwikkelingskaart c14 = new Ontwikkelingskaart(3, 5, EdelsteenSoort.SMARAGD);
				c14.voegKostToe(7,  EdelsteenSoort.SAFFIER);
				c14.voegKostToe(3,  EdelsteenSoort.SMARAGD);
				lijstKaartenNiveau3.add(c14);
				
				Ontwikkelingskaart c15 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.DIAMANT);
				c15.voegKostToe(3,  EdelsteenSoort.DIAMANT);
				c15.voegKostToe(3,  EdelsteenSoort.ROBIJN);
				c15.voegKostToe(6,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c15);
				
				Ontwikkelingskaart c16 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.SAFFIER);
				c16.voegKostToe(6,  EdelsteenSoort.DIAMANT);
				c16.voegKostToe(3,  EdelsteenSoort.SAFFIER);
				c16.voegKostToe(3,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c16);
				
				Ontwikkelingskaart c17 = new Ontwikkelingskaart(3, 4, EdelsteenSoort.SMARAGD);
				c17.voegKostToe(7,  EdelsteenSoort.SAFFIER);
				lijstKaartenNiveau3.add(c17);
				
				Ontwikkelingskaart c18 = new Ontwikkelingskaart(3, 3, EdelsteenSoort.ONYX);
				c18.voegKostToe(3, EdelsteenSoort.DIAMANT);
				c18.voegKostToe(3, EdelsteenSoort.SAFFIER);
				c18.voegKostToe(5, EdelsteenSoort.SMARAGD);
				c18.voegKostToe(3, EdelsteenSoort.ROBIJN);
				lijstKaartenNiveau3.add(c18);
				
				Ontwikkelingskaart c19 = new Ontwikkelingskaart(1, 3, EdelsteenSoort.ROBIJN);
				c19.voegKostToe(3,  EdelsteenSoort.DIAMANT);
				c19.voegKostToe(5,  EdelsteenSoort.SAFFIER);
				c19.voegKostToe(3,  EdelsteenSoort.SMARAGD);
				c19.voegKostToe(3,  EdelsteenSoort.ONYX);
				lijstKaartenNiveau3.add(c19);
				
				Ontwikkelingskaart c20 = new Ontwikkelingskaart(1, 5, EdelsteenSoort.SAFFIER);
				c20.voegKostToe(7, EdelsteenSoort.DIAMANT);
				c20.voegKostToe(3, EdelsteenSoort.SAFFIER);
				lijstKaartenNiveau3.add(c20);
		
		return lijstKaartenNiveau3;
	}
}