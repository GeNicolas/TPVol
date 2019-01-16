package Dao;

public class DaoAssociationClientReservationFactory {

	
	private static DaoAssociationClientRerservation singleton=null;
	
	public static DaoAssociationClientRerservation getInstance () {
		if (singleton == null) {
			singleton = new DaoAssociationClientReservationJpaImpl();
			
	}
return singleton;
	}
	
}
