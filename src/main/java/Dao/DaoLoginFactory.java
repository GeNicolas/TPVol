package Dao;

public class DaoLoginFactory {
private static DaoLoginImpl singleton;
	
	public static DaoLoginImpl getReservationFactory() {
		if (singleton == null)
			singleton = new DaoLoginImpl();
		
		return singleton;
			
	}

}
