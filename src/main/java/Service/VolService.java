package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Escale;
import Model.Vol;
import Repository.EscaleRepository;
import Repository.VolRepository;

public class VolService {

	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private EscaleRepository escaleRepository;
	
	public void deleteEscale(Vol vol) {
	
		for (Escale e: vol.getEscale()) {
			e.setKey(null);
			e.setHeureDepart(null);
			e.setHeureArrivee(null);
			escaleRepository.delete(e);
		}
	 volRepository.delete(vol);	
	}

}
