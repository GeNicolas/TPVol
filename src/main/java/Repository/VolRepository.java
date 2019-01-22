package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {
List<Vol> findAllWithReservation();
	
	List<Vol> findAllWithAeroport();
	
	List<Vol> findAllWithCompagnie();

}
