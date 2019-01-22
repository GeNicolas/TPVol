package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Passager;
import Model.Reservation;
import Repository.PassagerRepository;
import Repository.ReservationRepository;

public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepository;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	public void deletePassagerWithReservation(Long key) {
		Optional<Passager> opt = passagerRepository.findByIdWithReservation(key);
		
		Passager passager = null;
		
		if (opt.isPresent()) {
			passager = opt.get();
			for (Reservation r : passager.getReservations()) {
				r.setPassager(null);
				reservationRepo.save(r);
			}
			passagerRepository.delete(passager);
		}
	}

}
