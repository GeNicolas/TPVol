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
		Aeroport a = volArrive.getAeroport_arrive();
		volArrive.setAeroport_arrive(null);
		volRepository.save(volArrive);
		aeroportRepository.delete(a);	
	}
	
	public void deleteAeroportDepartWithVolDepart(Vol volDepart) {
		Aeroport a = volDepart.getAeroport_depart();
		volDepart.setAeroport_depart(null);
		volRepository.save(volDepart);
		aeroportRepository.delete(a);	
	}


}
