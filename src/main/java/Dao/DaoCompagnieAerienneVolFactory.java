package Dao;



public class DaoCompagnieAerienneVolFactory  {
	private static DaoCompagnieAerienneVol daoCompagnieAerienneVol = null;

	private DaoCompagnieAerienneVolFactory() {

	}

	public static DaoCompagnieAerienneVol getInstance() {
		if (daoCompagnieAerienneVol == null) {
			daoCompagnieAerienneVol = new DaoCompagnieAerienneVolJpa();
		}
		return daoCompagnieAerienneVol;
	}
	

}
