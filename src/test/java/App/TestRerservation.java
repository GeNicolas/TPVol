package App;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Reservation;
import Repository.ReservationRepository;

public class TestRerservation {

	
	
	private static ClassPathXmlApplicationContext ctx=null;
	
	
	@BeforeClass 
	
	public static void initClassPathApplicationContext() {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass
	public static void closeClassPathApplicationContext() {
		ctx.close();
	}
	@Autowired
	private ReservationRepository Reservationrepo;
	
	@org.junit.Before
	public void initRepoReservation () {
		Reservationrepo=ctx.getBean(ReservationRepository.class);
	}
	
	@Test
	public void reservation_insert() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		
		Reservation reservation=null;
		try {
			reservation = new Reservation (sdf.parse("22/01/2019"), 8);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reservationrepo.save(reservation);
		assertNotNull(reservation.getId());
	}

}
