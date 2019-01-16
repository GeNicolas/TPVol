package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dao.DaoCLientFactory;
import Dao.DaoClientJpaImpl;
import Dao.DaoPassager;
import Dao.DaoPassagerFactory;
import Dao.DaoReservation;
import Dao.DaoReservationFactory;
import Dao.DaoReservationImpl;
import Model.Client;
import Model.ClientEI;
import Model.Passager;
import Model.Reservation;
import Util.Context;

public class App {

	public static void main(String[] args) {
		
		/*
		Client client = new ClientEI();
		
		DaoClientJpaImpl clients = DaoCLientFactory.getInstance();
		clients.insert(client);
		System.out.println("blbé");*/
		
		Passager p = new Passager("pierre", "paulJacque");
		
		DaoPassager pfactory = DaoPassagerFactory.getPassagerFactory();
		
		pfactory.insert(p);
		
		Context.getEntityManagerFactory();
		
	}

}
