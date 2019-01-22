package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Ville;

public interface VilleRepository extends JpaRepository<Ville,Long> {
	List<Ville> findByNom(String nom);
	List<Ville> findByNomLike(String nom);

}
