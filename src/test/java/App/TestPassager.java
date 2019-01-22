package App;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import Model.Passager;
import Repository.PassagerRepository;

public class TestPassager {
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
	private PassagerRepository Passagerrepo;
	
	@org.junit.Before
	public void initRepoPassager () {
		Passagerrepo= ctx.getBean(PassagerRepository.class);
	}
	
	
	@Test
	public void passager_insert() {
		Passager passager= new Passager( "Dutronc","paul" );
		Passagerrepo.save(passager);
		assertNotNull(passager.getId());
	}

}
