package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Aeroport;
import Model.CompagnieAerienne;
import Model.Reservation;
import Model.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {
	Optional<Vol> findByIdWithReservation(Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportDepart(Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportArrivee(Long id); //Requete nomm�e
	Optional<Vol> findByIdWithCompagnie(Long id); //Requete nomm�e
	Optional<Vol> findAllWithCompagnie(CompagnieAerienne compagnieAerienne); //Requete nomm�e
	Optional<Vol> findAllWithAeroportDepart(Aeroport aeroportDepart); //Requete nomm�e
	Optional<Vol> findAllWithAeroportArrivee(Long id); //Requete nomm�e
	Optional<Vol> findAllWithReservation(Reservation reservation); //Requete nomm�e
	void deleteEscale(Vol vol); // suppr Vol entraine suppr des escales --> cf VolService
}
