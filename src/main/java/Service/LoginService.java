package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Client;
import Model.Login;
import Repository.ClientRepository;
import Repository.LoginRepository;

public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ClientRepository clientRepo;
	
	public void deleteLoginWithClient(Long key) {
		Optional<Login> opt = loginRepository.findById(key);
		Login login =null;
		Client c =null;
		if (opt.isPresent()) {
			login= opt.get();
			c =login.getClient();
			c.setLogin(null);
			clientRepo.save(c);
			loginRepository.delete(login);
		}
		
	}

}
