package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.EdeleMapper;

public class EdeleRepository {
	
	private EdeleMapper mapper;
	
	public EdeleRepository() {
		mapper = new EdeleMapper();
	}
	
	public List<Edele> geefEdelen(){
		List<Edele> lijstEdelen = new ArrayList<>();
		
	}

}