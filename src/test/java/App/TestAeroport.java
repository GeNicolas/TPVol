package App;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Aeroport;
import Repository.AeroportRepository;

public class TestAeroport {
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
	private AeroportRepository Aerorepo;
	
	@Before
	public void intiRepoAero () {
		Aerorepo=ctx.getBean(AeroportRepository.class);
		
	}
	
	
	@Test
	public void aeroport_insert() {
		Aeroport aeroport=new Aeroport();
		Aerorepo.save(aeroport);
		assertNotNull(aeroport.getId());
	}
	

}
