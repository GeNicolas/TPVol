package App;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Client;
import Model.ClientEI;
import Model.Reservation;
import Repository.ClientRepository;
import Repository.ReservationRepository;

public class TestClient {
	private static ClassPathXmlApplicationContext ctx=null;
	
	@BeforeClass 
	
	public static void initClassPathApplicationContext() {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass
	public static void closeClassPathApplicationContext() {
		ctx.close();}
	@Autowired
	private ClientRepository clientrepo;
	@Autowired
	private ReservationRepository Reservationrepo;
	
	@org.junit.Before
	public void initRepoClient () {
		clientrepo= ctx.getBean(ClientRepository.class);
		Reservationrepo = ctx.getBean(ReservationRepository.class);
	}
	
	
	@Test
	public void client_insert() {
		Client client= new ClientEI( "Dutronc",  64587158, 56468542,  "dutronccharles@gmail.com" );
		clientrepo.save(client);
		assertNotNull(client.getId());
	}
	@Test
	public void client_delete() {
		Client clients= new ClientEI( "Dutronce",  64587158, 56468542,  "dutronccharles@gmail.com" );
		clientrepo.save(clients);
		clientrepo.delete(clients);
		
		assertEquals(clientrepo.findById(clients.getId()), Optional.empty());
	}
	@Test
	public void reserv_client() {
		Client client= new ClientEI( "Dutronc",  64587158, 56468542,  "dutronccharles@gmail.com" );
		clientrepo.save(client);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		
		Reservation reservation=null;
		try {
			reservation = new Reservation (sdf.parse("22/01/2019"), 8);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------------- ICI-----------------");
		System.out.println(reservation);
		reservation.setClient(client);
		Reservationrepo.save(reservation);
		
		Optional<Client> opt = clientrepo.findByIdWithReservation(client.getId());
		
		Client cobay = opt.get();
		
		//assertEquals(cobay.getReservation(), new Set<Reservation>);
		
		assertTrue(cobay.getReservation() instanceof Set<?>);
		
	}
}
