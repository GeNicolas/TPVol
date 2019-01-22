package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Client;
import Model.Login;
import Model.Reservation;
import Repository.ClientRepository;
import Repository.LoginRepository;
import Repository.ReservationRepository;

public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void deleteClientWithReservationAndLogin(Long key) {
		Optional<Client> opt = clientRepository.findByIdWithReservationAndLogin(key);
		Client c = null;
		
		if (opt.isPresent()) {
			c = opt.get();
			for(Reservation r : c.getReservation()) {
				r.setClient(null);
				reservationRepository.save(r);
			}
			Login l = c.getLogin();
			loginRepository.delete(l);
			
		}
	}
	

}
