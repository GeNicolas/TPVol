package Dao;

import java.util.List;

import Model.Vol;

public interface DaoVol extends DaoGeneric<Vol,Long> {
	List<Vol> findAllWithReservation();
	
	List<Vol> findAllWithAeroport();
	
	List<Vol> findAllWithCompagnie();
}
