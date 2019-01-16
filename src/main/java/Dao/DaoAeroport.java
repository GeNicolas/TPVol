package Dao;

import java.util.List;

import Model.Aeroport;

public interface DaoAeroport extends DaoGeneric<Aeroport,Long>{

	List<Aeroport> findAllWithVol();
	
	List<Aeroport> findAllWithVille();
}
