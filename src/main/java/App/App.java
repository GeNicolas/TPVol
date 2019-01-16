package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dao.DaoReservation;
import Dao.DaoReservationFactory;
import Dao.DaoReservationImpl;
import Model.Reservation;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello world");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Reservation reserv = null;
		try {
			reserv = new Reservation(sdf.parse("01/01/2019"), 5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DaoReservationImpl reserfac = DaoReservationFactory.getReservationFactory();
		
		reserfac.insert(reserv);
		
		
		System.out.println(reserfac.findAll());

	}

}
