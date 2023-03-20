package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Ontwikkelingskaart;
import util.EdelsteenSoort;

public class KaartMapper {

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
		
		Ontwikkelingskaart a21 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a21.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a21.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a21.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a21.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a21);
		
		Ontwikkelingskaart a22 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a22.voegKostToe(3, EdelsteenSoort.DIAMANT);
		a22.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a22.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a22);
		
		Ontwikkelingskaart a23 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a23.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a23.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a23);
		
		Ontwikkelingskaart a24 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a24.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a24.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a24.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a24);
		
		Ontwikkelingskaart a25 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a25.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(a25);
		
		Ontwikkelingskaart a26 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a26.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a26.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a26.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a26.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a26);
		
		Ontwikkelingskaart a27 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a27.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a27.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a27.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a27.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a27);
		
		Ontwikkelingskaart a28 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.DIAMANT);
		a28.voegKostToe(2, EdelsteenSoort.ROBIJN);
		a28.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a28);
		
		Ontwikkelingskaart a29 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a29.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a29.voegKostToe(3, EdelsteenSoort.SMARAGD);
		a29.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a29);
		
		Ontwikkelingskaart a30 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a30.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a30.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a30.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a30);
		
		Ontwikkelingskaart a31 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.DIAMANT);
		a31.voegKostToe(4,  EdelsteenSoort.SMARAGD);
		lijstKaarten.add(a31);
		
		Ontwikkelingskaart a32 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.SMARAGD);
		a32.voegKostToe(4, EdelsteenSoort.ONYX);
		lijstKaarten.add(a32);
		
		Ontwikkelingskaart a33 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SMARAGD);
		a33.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a33.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a33);
		
		Ontwikkelingskaart a34 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a34.voegKostToe(2, EdelsteenSoort.DIAMANT);
		a34.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a34);
		
		Ontwikkelingskaart a35 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.ROBIJN);
		a35.voegKostToe(4, EdelsteenSoort.DIAMANT);
		lijstKaarten.add(a35);
		
		Ontwikkelingskaart a36 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a36.voegKostToe(2, EdelsteenSoort.SMARAGD);
		a36.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(a36);
		
		Ontwikkelingskaart a37 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.SAFFIER);
		a37.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a37.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a37.voegKostToe(1, EdelsteenSoort.ROBIJN);
		a37.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a37);
		
		Ontwikkelingskaart a38 = new Ontwikkelingskaart(1, 1, EdelsteenSoort.SAFFIER);
		a38.voegKostToe(4, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a38);
		
		Ontwikkelingskaart a39 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ROBIJN);
		a39.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a39.voegKostToe(1, EdelsteenSoort.SAFFIER);
		a39.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a39.voegKostToe(1, EdelsteenSoort.ONYX);
		lijstKaarten.add(a39);
		
		Ontwikkelingskaart a40 = new Ontwikkelingskaart(1, 0, EdelsteenSoort.ONYX);
		a40.voegKostToe(1, EdelsteenSoort.DIAMANT);
		a40.voegKostToe(2, EdelsteenSoort.SAFFIER);
		a40.voegKostToe(1, EdelsteenSoort.SMARAGD);
		a40.voegKostToe(1, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(a40);
		
		
		
		// niveau 2 -> b
		
		Ontwikkelingskaart b1 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b1.voegKostToe(5, EdelsteenSoort.DIAMANT);
		lijstKaarten.add(b1);
		
		Ontwikkelingskaart b2 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ONYX);
		b2.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b2.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b2.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(b2);
		
		Ontwikkelingskaart b3 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ROBIJN);
		b3.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b3.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b3.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(b3);
		
		Ontwikkelingskaart b4 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SMARAGD);
		b4.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b4.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b4.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(b4);
		
		Ontwikkelingskaart b5 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b5.voegKostToe(1, EdelsteenSoort.SMARAGD);
		b5.voegKostToe(4, EdelsteenSoort.ROBIJN);
		b5.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(b5);
		
		Ontwikkelingskaart b6 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b6.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b6.voegKostToe(3, EdelsteenSoort.SAFFIER);
		b6.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b6);
		
		Ontwikkelingskaart b7 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SMARAGD);
		b7.voegKostToe(3,  EdelsteenSoort.DIAMANT);
		b7.voegKostToe(2,  EdelsteenSoort.SMARAGD);
		b7.voegKostToe(3,  EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b7);
		
		Ontwikkelingskaart b8 = new Ontwikkelingskaart(2,  2, EdelsteenSoort.SAFFIER);
		b8.voegKostToe(2, EdelsteenSoort.DIAMANT);
		b8.voegKostToe(1, EdelsteenSoort.ROBIJN);
		b8.voegKostToe(4, EdelsteenSoort.ONYX);
		lijstKaarten.add(b8);
		
		Ontwikkelingskaart b9 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b9.voegKostToe(5, EdelsteenSoort.ONYX);
		lijstKaarten.add(b9);
		
		Ontwikkelingskaart b10 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b10.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b10.voegKostToe(5, EdelsteenSoort.ONYX);
		lijstKaarten.add(b10);
		
		Ontwikkelingskaart b11 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SAFFIER);
		b11.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b11.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b11.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(b11);
		
		Ontwikkelingskaart b12 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ROBIJN);
		b12.voegKostToe(2,  EdelsteenSoort.DIAMANT);
		b12.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b12.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(b12);
		
		Ontwikkelingskaart b13 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.SMARAGD);
		b13.voegKostToe(6, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(b13);
		
		Ontwikkelingskaart b14 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ROBIJN);
		b14.voegKostToe(1, EdelsteenSoort.DIAMANT);
		b14.voegKostToe(4, EdelsteenSoort.SAFFIER);
		b14.voegKostToe(2, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(b14);
		
		Ontwikkelingskaart b15 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SAFFIER);
		b15.voegKostToe(5, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(b15);
		
		Ontwikkelingskaart b16 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b16.voegKostToe(5, EdelsteenSoort.SAFFIER);
		b16.voegKostToe(3, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(b16);
		
		Ontwikkelingskaart b17 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b17.voegKostToe(4,  EdelsteenSoort.DIAMANT);
		b17.voegKostToe(2,  EdelsteenSoort.SAFFIER);
		b17.voegKostToe(1,  EdelsteenSoort.ONYX);
		lijstKaarten.add(b17);
		
		Ontwikkelingskaart b18 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.DIAMANT);
		b18.voegKostToe(5, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b18);
		
		Ontwikkelingskaart b19 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.DIAMANT);
		b19.voegKostToe(6,  EdelsteenSoort.DIAMANT);
		lijstKaarten.add(b19);
		
		Ontwikkelingskaart b20 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b20.voegKostToe(1, EdelsteenSoort.SAFFIER);
		b20.voegKostToe(4, EdelsteenSoort.SMARAGD);
		b20.voegKostToe(2, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b20);
		
		Ontwikkelingskaart b21 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.SAFFIER);
		b21.voegKostToe(6, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(b21);
		
		Ontwikkelingskaart b22 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.ONYX);
		b22.voegKostToe(5,  EdelsteenSoort.SMARAGD);
		b22.voegKostToe(3,  EdelsteenSoort.ONYX);
		lijstKaarten.add(b22);
		
		Ontwikkelingskaart b23 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.DIAMANT);
		b23.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b23.voegKostToe(2, EdelsteenSoort.ROBIJN);
		b23.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(b23);
		
		Ontwikkelingskaart b24 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.SAFFIER);
		b24.voegKostToe(2, EdelsteenSoort.SAFFIER);
		b24.voegKostToe(2, EdelsteenSoort.SMARAGD);
		b24.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b24);
		
		Ontwikkelingskaart b25 = new Ontwikkelingskaart(2, 1, EdelsteenSoort.ONYX);
		b25.voegKostToe(3, EdelsteenSoort.DIAMANT);
		b25.voegKostToe(3, EdelsteenSoort.SMARAGD);
		b25.voegKostToe(2, EdelsteenSoort.ONYX);
		lijstKaarten.add(b25);
		
		Ontwikkelingskaart b26 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SMARAGD);
		b26.voegKostToe(5, EdelsteenSoort.SMARAGD);
		lijstKaarten.add(b26);
		
		Ontwikkelingskaart b27 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.DIAMANT);
		b27.voegKostToe(5, EdelsteenSoort.ROBIJN);
		b27.voegKostToe(3, EdelsteenSoort.ONYX);
		lijstKaarten.add(b27);
		
		Ontwikkelingskaart b28 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.ONYX);
		b28.voegKostToe(6, EdelsteenSoort.ONYX);
		lijstKaarten.add(b28);
		
		Ontwikkelingskaart b29 = new Ontwikkelingskaart(2, 2, EdelsteenSoort.SAFFIER);
		b29.voegKostToe(5, EdelsteenSoort.DIAMANT);
		b29.voegKostToe(5, EdelsteenSoort.SAFFIER);
		lijstKaarten.add(b29);
		
		Ontwikkelingskaart b30 = new Ontwikkelingskaart(2, 3, EdelsteenSoort.ROBIJN);
		b30.voegKostToe(6, EdelsteenSoort.ROBIJN);
		lijstKaarten.add(b30);
		
		// niveau 3 -> c
		
		return lijstKaarten;
	}

}