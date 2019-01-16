package Dao;

public class DaoReservationFactory {
	
	private static DaoReservationImpl singleton;
	
	public static DaoReservationImpl getReservationFactory() {
		if (singleton == null)
			singleton = new DaoReservationImpl();
		
		return singleton;
			
	}

}
