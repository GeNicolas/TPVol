package Dao;

public class DaoPassagerFactory {
private static DaoPassagerImpl singleton;
	
	public static DaoPassagerImpl getPassagerFactory() {
		if (singleton == null)
			singleton = new DaoPassagerImpl();
		
		return singleton;
			
	}

}
