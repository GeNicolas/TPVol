package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Escale;
import Model.EscaleKey;

public interface EscaleRepository extends JpaRepository<Escale,EscaleKey>{

}
