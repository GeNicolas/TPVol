package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Repository.LoginRepository;

public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

}
