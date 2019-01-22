package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Model.Aeroport;
import Model.CompagnieAerienne;
import Model.Reservation;
import Model.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {
	Optional<Vol> findByIdWithReservation(@Param("id") Long id); //Requete nommée
	Optional<Vol> findByIdWithAeroportDepart(@Param("id") Long id); //Requete nommée
	Optional<Vol> findByIdWithAeroportArrivee(@Param("id") Long id); //Requete nommée
	Optional<Vol> findByIdWithCompagnie(@Param("id") Long id); //Requete nommée
	Optional<Vol> findAllWithCompagnie(CompagnieAerienne compagnieAerienne); //Requete nommée
	Optional<Vol> findAllWithAeroportDepart(Aeroport aeroportDepart); //Requete nommée
	Optional<Vol> findAllWithAeroportArrivee(Aeroport aeroportArrive); //Requete nommée
	Optional<Vol> findAllWithReservation(Reservation reservation); //Requete nommée
	//void deleteEscale(Vol vol); // suppr Vol entraine suppr des escales --> cf VolService
}
