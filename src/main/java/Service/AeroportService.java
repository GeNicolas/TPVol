package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Aeroport;
import Model.Vol;
import Repository.AeroportRepository;
import Repository.VolRepository;

public class AeroportService {
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Autowired
	private VolRepository volRepository;
	
	public void deleteAeroportArriveWithVolArrive(Vol volArrive) {
		Aeroport a = volArrive.getAeroportArrivee();
		volArrive.setAeroportArrivee(null);
		volRepository.save(volArrive);
		aeroportRepository.delete(a);	
	}
	
	public void deleteAeroportDepartWithVolDepart(Vol volDepart) {
		Aeroport a = volDepart.getAeroportDepart();
		volDepart.setAeroportDepart(null);
		volRepository.save(volDepart);
		aeroportRepository.delete(a);	
	}


}
