package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Repository.ClientRepository;

public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

}
