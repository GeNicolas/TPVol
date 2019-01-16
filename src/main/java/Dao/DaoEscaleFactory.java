package Dao;

public class DaoEscaleFactory {
	private static DaoEscale daoEscale = null;

	private DaoEscaleFactory() {

	}

	public static DaoEscale getInstance() {
		if (daoEscale == null) {
			daoEscale = new DaoEscaleJpa();
		}
		return daoEscale;
	}
}