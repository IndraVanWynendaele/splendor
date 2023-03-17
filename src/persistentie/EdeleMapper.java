package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Edele;
import util.EdelsteenSoort;

public class EdeleMapper {
	
	public List<Edele> lijstEdelen(){
		List<Edele> lijstEdelen = new ArrayList<>();
		
		Edele e1 = new Edele(3);
		e1.voegKostToe(4, EdelsteenSoort.ONYX);
		e1.voegKostToe(4, EdelsteenSoort.DIAMANT);
		lijstEdelen.add(e1);
		Edele e2 = new Edele(3);
		e2.voegKostToe(3, EdelsteenSoort.ONYX);
		e2.voegKostToe(3, EdelsteenSoort.ROBIJN);
		e2.voegKostToe(3, EdelsteenSoort.DIAMANT);
		lijstEdelen.add(e2);
		Edele e3 = new Edele(3);
		e3.voegKostToe(3, EdelsteenSoort.ONYX);
		e3.voegKostToe(3, EdelsteenSoort.SAFFIER);
		e3.voegKostToe(3, EdelsteenSoort.DIAMANT);
		lijstEdelen.add(e3);
		Edele e4 = new Edele(3);
		e4.voegKostToe(3, EdelsteenSoort.SMARAGD);
		e4.voegKostToe(3, EdelsteenSoort.SAFFIER);
		e4.voegKostToe(3, EdelsteenSoort.DIAMANT);
		lijstEdelen.add(e4);
		Edele e5 = new Edele(3);
		e5.voegKostToe(3, EdelsteenSoort.ONYX);
		e5.voegKostToe(3, EdelsteenSoort.ROBIJN);
		e5.voegKostToe(3, EdelsteenSoort.SMARAGD);
		lijstEdelen.add(e5);
		Edele e6 = new Edele(3);
		e6.voegKostToe(3, EdelsteenSoort.SMARAGD);
		e6.voegKostToe(3, EdelsteenSoort.SAFFIER);
		e6.voegKostToe(3, EdelsteenSoort.ROBIJN);
		lijstEdelen.add(e6);
		Edele e7 = new Edele(3);
		e7.voegKostToe(4, EdelsteenSoort.SAFFIER);
		e7.voegKostToe(4, EdelsteenSoort.SMARAGD);
		lijstEdelen.add(e7);
		Edele e8 = new Edele(3);
		e8.voegKostToe(4, EdelsteenSoort.ONYX);
		e8.voegKostToe(4, EdelsteenSoort.ROBIJN);
		lijstEdelen.add(e8);
		Edele e9 = new Edele(3);
		e9.voegKostToe(4, EdelsteenSoort.SAFFIER);
		e9.voegKostToe(4, EdelsteenSoort.DIAMANT);
		lijstEdelen.add(e9);
		Edele e10 = new Edele(3);
		e10.voegKostToe(4, EdelsteenSoort.ROBIJN);
		e10.voegKostToe(4, EdelsteenSoort.SMARAGD);
		lijstEdelen.add(e10);
		
		return lijstEdelen;
	}
}