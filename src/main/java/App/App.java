package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		
		Client client = new ClientEI();
		
		DaoClientJpaImpl clients = DaoCLientFactory.getInstance();
		clients.insert(client);
		System.out.println("blbé");
		
		
	}

}
