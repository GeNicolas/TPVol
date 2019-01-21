package App;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Dao.DaoAeroport;
import Dao.DaoAeroportFactory;
import Dao.DaoCLientFactory;
import Dao.DaoClient;
import Dao.DaoCompagnieAerienne;
import Dao.DaoCompagnieAerienneFactory;
import Dao.DaoLogin;
import Dao.DaoLoginFactory;
import Dao.DaoVille;
import Dao.DaoVilleFactory;
import Model.Aeroport;
import Model.Client;
import Model.ClientEI;
import Model.ClientMoral;
import Model.CompagnieAerienne;
import Model.Login;
import Model.Reservation;
import Model.TitreMoral;
import Model.TitrePhysique;
import Model.Ville;

public class App {

	public static void main(String[] args) {
		
		
//		Client client = new ClientEI();
//		
//		DaoClientJpaImpl clients = DaoCLientFactory.getInstance();
//		clients.insert(client);
		/*System.out.println("...................................");
		
		DaoVille daoVille = DaoVilleFactory.getInstance();
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		Set villes = new HashSet();
		
		Ville paris = new Ville("Orly");
		Ville beauvais = new Ville ("Beauvais");
		villes.add(paris);
		villes.add(beauvais);
		
		Aeroport a = new Aeroport("orly", villes);
		Aeroport b = new Aeroport("CDG", villes);
		
		List<Aeroport> lista = new ArrayList<Aeroport>();
		lista.add(a);
		lista.add(b);
		
		daoAeroport.insert(a);
		daoAeroport.insert(b);
		
		paris.setAeroport(lista);
		
		daoVille.insert(paris);
		daoVille.insert(beauvais);*/
		
		
		
		System.out.println("----------------------ici------------------");
		//System.out.println(paris.getId());
		//daoVille.insert(paris);
		//daoVille.insert(beauvais);
		
		Client c = new ClientMoral();
		c.setEmail("lolhotmail");
		c.setNom("yoda");
		c.setNumerofax(23);
		c.setNumerotel(34);
		
		System.out.println(c.getNom());
		//c.setNumerofax(908);
		((ClientMoral)c).setTitre(new TitreMoral("yepIndus"));
		
		DaoClient daoclient = DaoCLientFactory.getInstance();
		
		Client c2 = new ClientEI();
		c2.setEmail("lmfao.com");
		c2.setNom("dark");
		c2.setNumerofax(22);
		c2.setNumerotel(44);
		
		((ClientEI)c2).setTitre(TitrePhysique.M);
		
		daoclient.insert(c);
		daoclient.insert(c2);
		/*
		Login login = new Login();
		login.setAdmin(false);
		login.setLogin("whaaaat");
		login.setMotDePasse("srly");
		DaoLogin daologin = DaoLoginFactory.getReservationFactory();
		daologin.insert(login);*/
		
		/*
		CompagnieAerienne ca = new CompagnieAerienne("airlol");
		DaoCompagnieAerienne daoca = DaoCompagnieAerienneFactory.getInstance();
		daoca.insert(ca);
		*/
		
		
		
	}

}
