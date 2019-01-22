package App;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.CompagnieAerienne;
import Repository.CompagnieAerienneRepository;

public class TestCompagnieAerienne {
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
	private CompagnieAerienneRepository Comprepo;
	
	@Before
	public void intiRepoComp () {
		Comprepo=ctx.getBean(CompagnieAerienneRepository.class);
	}
	
	@Test
	public void Comp_insert() {
		CompagnieAerienne compagnie = new CompagnieAerienne ();
		Comprepo.save(compagnie);
		assertNotNull(compagnie.getId());
	}

}
