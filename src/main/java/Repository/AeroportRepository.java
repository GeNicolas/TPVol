package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Aeroport;
import Model.Vol;


public interface AeroportRepository  extends JpaRepository<Aeroport, Long>{
	Optional<Aeroport> findByNom(String nom); 
	Optional<Aeroport> findByNomLike(String nom);
	void deleteAeroportArriveWithVolArrive(Vol volArrive);
	void deleteAeroportDepartWithVolDepart(Vol volDepart);
}
