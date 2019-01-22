package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
