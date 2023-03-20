package domein;

import java.util.List;

import persistentie.KaartMapper;

public class OntwikkelingskaartRepository {
	
	private KaartMapper mapper;
	
	public OntwikkelingskaartRepository() {
		mapper = new KaartMapper();
	}
	
	public List<Ontwikkelingskaart> geefKaarten(){
		List<Ontwikkelingskaart>lijstKaarten = mapper.lijstKaarten();
		return lijstKaarten;
	}
	
}