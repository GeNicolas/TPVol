package Dao;


public class DaoCLientFactory {
	private static DaoClient singleton = null;

	public static DaoClient getInstance() {
		if (singleton == null) {
			singleton = new DaoClientJpaImpl();
		}
		return singleton;
	}
}
