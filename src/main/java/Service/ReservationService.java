package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Repository.ReservationRepository;

public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

}
