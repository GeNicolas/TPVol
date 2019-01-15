package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
	
	private static EntityManagerFactory singleton = null;
	
	public static EntityManagerFactory getContext() {
		if (singleton == null) {
			singleton = Persistence.createEntityManagerFactory("persistence-unit");
		}
		
		return singleton;
	}
	
	
	public static void close() {
		if(singleton!=null)
			singleton.close();
	}

}
