package Dao;


public class DaoCLientFactory {
	private static DaoClientJpaImpl singleton = null;

	public static DaoClientJpaImpl getInstance() {
		if (singleton == null) {
			singleton = new DaoClientJpaImpl();
		}
		return singleton;
	}
}
