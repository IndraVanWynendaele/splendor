package domein;

import java.util.List;

import persistentie.EdelsteenficheMapper;

public class EdelsteenficheRepository {
	private EdelsteenficheMapper mapper;
	
	
	public EdelsteenficheRepository() {
		this.mapper = new EdelsteenficheMapper();
	}
	
	public List<Edelsteenfiche> geefFichesSmaragd(){
		return mapper.lijstFichesSmaragd();
	}
	
	public List<Edelsteenfiche> geefFichesDiamant(){
		return mapper.lijstFichesDiamant();
	}
	
	public List<Edelsteenfiche> geefFichesSaffier(){
		return mapper.lijstFichesSaffier();
	}
	
	public List<Edelsteenfiche> geefFichesOnyx(){
		return mapper.lijstFichesOnyx();
	}
	
	public List<Edelsteenfiche> geefFichesRobijn(){
		return mapper.lijstFichesRobijn();
	}
}
