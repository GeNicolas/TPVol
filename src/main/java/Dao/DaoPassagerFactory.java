package Dao;

public class DaoPassagerFactory {
private static DaoPassagerImpl singleton;
	
	public static DaoPassagerImpl getReservationFactory() {
		if (singleton == null)
			singleton = new DaoPassagerImpl();
		
		return singleton;
			
	}

}
