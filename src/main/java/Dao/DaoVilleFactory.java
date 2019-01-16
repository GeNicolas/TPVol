package Dao;

public class DaoVilleFactory {
	private static DaoVille daoVille = null;

	private DaoVilleFactory() {

	}

	public static DaoVille getInstance() {
		if (daoVille == null) {
			daoVille = new DaoVilleJpa();
		}
		return daoVille;
	}

}
