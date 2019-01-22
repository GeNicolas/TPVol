package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{

}
