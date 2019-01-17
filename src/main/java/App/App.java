package App;

import java.util.HashSet;
import java.util.Set;

import Dao.DaoCLientFactory;
import Dao.DaoClientJpaImpl;
import Dao.DaoReservation;
import Dao.DaoReservationFactory;
import Dao.DaoReservationImpl;
import Model.Client;
import Model.ClientEI;
import Model.Reservation;

public class App {

	public static void main(String[] args) {
		
		
//		Client client = new ClientEI();
//		
//		DaoClientJpaImpl clients = DaoCLientFactory.getInstance();
//		clients.insert(client);
		System.out.println("...................................");
		
		DaoVille daoVille = DaoVilleFactory.getInstance();
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		
		Set villes = new HashSet();
		Ville paris = new Ville("Paris");
		Ville beauvais = new Ville ("Beauvais");
		villes.add(paris);
		villes.add(beauvais);
		
		Aeroport a = new Aeroport("ORLY");
		
		
		
		daoVille.insert(paris);
		daoVille.insert(beauvais);
		daoAeroport.insert(a);
		
		
		
		
	}

}
