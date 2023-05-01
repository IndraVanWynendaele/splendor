package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.EdeleDTO;
import dtos.OntwikkelingskaartDTO;
import dtos.SpelerDTO;

public class DomeinController {

	private SpelerRepository sRepo;
	private EdeleRepository eRepo;
	private OntwikkelingskaartRepository oRepo;
	private Spel s ;
	public Speler startSpeler;
	public Speler huidigeSpeler;
	public List<Speler> spelersInSpel;
	private boolean wordtVertaald;
	
	public DomeinController() {
		s = new Spel();
		startSpel();
		sRepo = new SpelerRepository();
	}
	
	public void startSpel() {
		s.shuffleOntwikkelingsKaarten();
		s.shuffleEdelen();
		s.geefKaartenAantalSpelers();
		s.maakZichtbareOntwikkelingskaarten();
	}

	public boolean geefWordtVertaald() {
		return wordtVertaald;
	}
	
	public void setWordtVertaald(boolean wordtVertaald) {
		this.wordtVertaald = wordtVertaald;
	}
	
	public boolean meldAan(Speler sp) {
		if(sRepo.geefSpeler(sp.getGebruikersnaam(), sp.getGeboortejaar())!= null) {
			s.meldAan(sp);
			return true;
		}
		return false;	
	}
	
	public void voegToe(Speler sp) {
		sRepo.voegToe(sp);
	}
	
	public boolean spelerAlAangemeld(Speler sp) {
		spelersInSpel= s.getSpelers();
		for(Speler speler : spelersInSpel)
			if(speler.getGebruikersnaam().equals(sp.getGebruikersnaam()))
				if(speler.getGeboortejaar() == sp.getGeboortejaar())
					return false;
		return true;
	}
	
	public boolean isEindeSpel() {
		return s.isEindeSpel();
	}
	
	public void koopKaartNiveau1(int index) {
		s.koopKaartNiveau1(index);
	}
	
	public void koopKaartNiveau2(int index) {
		s.koopKaartNiveau2(index);
	}

	public void koopKaartNiveau3(int index) {
		s.koopKaartNiveau3(index);
	}
	
	public boolean controleerAantalSpelers() {
		boolean aantalSpelersInOrde = false;
		spelersInSpel= s.getSpelers();

			if(spelersInSpel.size() < 2) {
				throw new IllegalArgumentException("Er moeten minstens 2 spelers aangemeld zijn\n");
			}
			aantalSpelersInOrde = true;

		return aantalSpelersInOrde;
	}
	
	public void isStartSpeler() {
		s.isStartSpeler();
	}
	
	public void resetSpelers() {
		s.resetSpelers();
	}
	
	public List<Speler> updateIsAanDeBeurt(List<Speler> tmpSpelerLijst) {
		return s.updateIsAanDeBeurt(tmpSpelerLijst);
	}
	
	public int controleerMogelijkheidTotEdelen() {
		if(s.controleerMogelijkheidTotEdelen(huidigeSpeler)) {
			List<Edele> beschikbareEdelen = s.edelenOpBezoek(huidigeSpeler);
			if(beschikbareEdelen.size() == 1)
				huidigeSpeler.voegEdeleToe(beschikbareEdelen.get(0));
			return beschikbareEdelen.size();
		}
		return 0;
	}
	
	public List<Edele> geefBeschikbareEdelen() {
		return s.edelenOpBezoek(huidigeSpeler);
	}
	
	public List<Speler> getSpelersInSpel() {
		return spelersInSpel;
	}
	
	public Speler getStartSpeler() {
		return s.getStartSpeler();
	}
	
	public Speler getHuisdigeSpeler() {
		return s.getHuidigeSpeler();
	}
	
	public List<Speler> getWinnaars(){
		return s.getWinnaars();
	}
	
	public List<Edele> geefEdelenZichtbaar(){
		List<Edele> edelenZichtbaar = new ArrayList<>();
		Edele[] edelen = s.getEdeleSpelers();
		for(Edele e: edelen) {
			edelenZichtbaar.add(e);
		}
		return edelenZichtbaar;
	}
	
	public List<Ontwikkelingskaart> geefOWK1Zichtbaar(){
		return s.getNiveau1Zichtbaar();
	}
	public List<Ontwikkelingskaart> geefOWK2Zichtbaar(){
		return s.getNiveau2Zichtbaar();
	}
	public List<Ontwikkelingskaart> geefOWK3Zichtbaar(){
		return s.getNiveau3Zichtbaar();
	}
	
	public List<SpelerDTO> geefSpelerDTO(){
		spelersInSpel = s.getSpelers();
		List<SpelerDTO> spelerDTOs = new ArrayList<>();
		for(Speler speler : spelersInSpel) {
			spelerDTOs.add(new SpelerDTO(speler.getGebruikersnaam(),speler.getGeboortejaar(), speler.getTotaalAantalPrestigePunten(), speler.geefIsAanDeBeurt(), speler.geefisStartSpeler(), speler.getOntwikkelingskaartenInBezit(), speler.getEdelsteenfichesInBezit(), speler.getEdelenInBezit()));
		}
		return spelerDTOs;
	}
	
	public List<EdeleDTO> geefEdeleDTO(){
		Edele[] edeleInSpel = s.getEdeleSpelers();
		List<EdeleDTO> edeleDTO = new ArrayList<>();
		for(Edele edele:edeleInSpel) {
			edeleDTO.add(new EdeleDTO(edele.getPrestigepunten(),edele.getKosten(), edele.getImage()));
		}
		return edeleDTO;
	}
	
	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO1(){
		List<Ontwikkelingskaart> ontwikkelingskaart1 =s.getNiveau1();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO1 = new ArrayList<>();
		for(Ontwikkelingskaart o1:ontwikkelingskaart1) {
			ontwikkelingskaartDTO1.add(new OntwikkelingskaartDTO(o1.getPrestigepunten(),o1.getKosten(),o1.getNiveau(),o1.getBonus()));
		}
		return ontwikkelingskaartDTO1;
	}

	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO2(){
		List<Ontwikkelingskaart> ontwikkelingskaart2 =s.getNiveau2();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO2 = new ArrayList<>();
		for(Ontwikkelingskaart o2:ontwikkelingskaart2) {
			ontwikkelingskaartDTO2.add(new OntwikkelingskaartDTO(o2.getPrestigepunten(),o2.getKosten(),o2.getNiveau(),o2.getBonus()));
		}
		return ontwikkelingskaartDTO2;
	}
	
	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO3(){
		List<Ontwikkelingskaart> ontwikkelingskaart3 =s.getNiveau1();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO3 = new ArrayList<>();
		for(Ontwikkelingskaart o3:ontwikkelingskaart3) {
			ontwikkelingskaartDTO3.add(new OntwikkelingskaartDTO(o3.getPrestigepunten(),o3.getKosten(),o3.getNiveau(),o3.getBonus()));
		}
		return ontwikkelingskaartDTO3;
	}
	
	public List<OntwikkelingskaartDTO> getNiveau1Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart1 = s.getNiveau1Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO1 = new ArrayList<>();
		for(Ontwikkelingskaart o1:ontwikkelingskaart1) {
			ontwikkelingskaartDTO1.add(new OntwikkelingskaartDTO(o1.getPrestigepunten(),o1.getKosten(),o1.getNiveau(),o1.getBonus()));
		}
		return ontwikkelingskaartDTO1; 
	}
	
	public List<OntwikkelingskaartDTO> getNiveau2Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart2 =s.getNiveau2Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO2 = new ArrayList<>();
		for(Ontwikkelingskaart o2:ontwikkelingskaart2) {
			ontwikkelingskaartDTO2.add(new OntwikkelingskaartDTO(o2.getPrestigepunten(),o2.getKosten(),o2.getNiveau(),o2.getBonus()));
		}
		return ontwikkelingskaartDTO2; 
	}
	
	public List<OntwikkelingskaartDTO> getNiveau3Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart3 =s.getNiveau3Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO3 = new ArrayList<>();
		for(Ontwikkelingskaart o3:ontwikkelingskaart3) {
			ontwikkelingskaartDTO3.add(new OntwikkelingskaartDTO(o3.getPrestigepunten(),o3.getKosten(),o3.getNiveau(),o3.getBonus()));
		}
		return ontwikkelingskaartDTO3; 
	}
	
	public List<Ontwikkelingskaart> getNiveau1() {
		return s.getNiveau1();
	}
	
	public List<Ontwikkelingskaart> getNiveau2() {
		return s.getNiveau2();
	}
	
	public List<Ontwikkelingskaart> getNiveau3() {
		return s.getNiveau3();
	}
	
	public Edele[] getEdeleSpelers() {
		return s.getEdeleSpelers();
	}
	
	public EdelsteenAantal getDiamantAantal() {
		return s.getDiamantAantal();
	}
	
	public EdelsteenAantal getOnyxAantal() {
		return s.getOnyxAantal();
	}
	
	public EdelsteenAantal getRobijnAantal() {
		return s.getRobijnAantal();
	}
	
	public EdelsteenAantal getSaffierAantal() {
		return s.getSaffierAantal();
	}
	
	public EdelsteenAantal getSmaragdAantal() {
		return s.getSmaragdAantal();
	}
	
	public void neemEdelsteenaantal(EdelsteenAantal fiche) {
		s.neemEdelsteenAantal(fiche);
	}
}