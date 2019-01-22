package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.CompagnieAerienneKey;
import Model.CompagnieAerienneVol;

public interface CompagnieAerienneVolRepository extends JpaRepository<CompagnieAerienneVol,CompagnieAerienneKey>{

}
