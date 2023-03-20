package domein;

import java.util.List;

import persistentie.OntwikkelingskaartMapper;

public class OntwikkelingskaartRepository {
	private OntwikkelingskaartMapper mapper;
	
	public OntwikkelingskaartRepository() {
		mapper = new OntwikkelingskaartMapper();
	}
	
	public List<Ontwikkelingskaart> geefKaarten(){
		List<Ontwikkelingskaart>lijstKaarten = mapper.lijstKaarten();
		return lijstKaarten;
	}
}