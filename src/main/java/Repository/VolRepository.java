package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Model.Aeroport;
import Model.CompagnieAerienne;
import Model.Reservation;
import Model.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {
	Optional<Vol> findByIdWithReservation(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportDepart(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportArrivee(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithCompagnie(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findAllWithCompagnie(CompagnieAerienne compagnieAerienne); //Requete nomm�e
	Optional<Vol> findAllWithAeroportDepart(Aeroport aeroportDepart); //Requete nomm�e
	Optional<Vol> findAllWithAeroportArrivee(Aeroport aeroportArrive); //Requete nomm�e
	Optional<Vol> findAllWithReservation(Reservation reservation); //Requete nomm�e
	//void deleteEscale(Vol vol); // suppr Vol entraine suppr des escales --> cf VolService
}
