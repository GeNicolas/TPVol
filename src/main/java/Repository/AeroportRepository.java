package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Aeroport;





public interface AeroportRepository  extends JpaRepository<Aeroport, Long>{
	List<Aeroport> findByNom(String nom); // creer une nouvelle methode, sp�cifique � la class Adherent
	List<Aeroport> findByNomLike(String nom);
}
