package App;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Vol;
import Repository.VolRepository;

public class TestVol {
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
	private VolRepository Volrepo;
	
	@Before
	public void intiRepoVol () {
		Volrepo = ctx.getBean(VolRepository.class);
	}
	@Test
	public void vol_insert() {
		Vol vol=new Vol();
		Volrepo.save(vol);
		assertNotNull(vol.getId());
	}

}
