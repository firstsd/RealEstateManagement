package mum.edu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.project.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    @Query("Select u from User u where u.email=:email")
    public User getByEmail(@Param("email") String email);

    @Query(value= "Select u from User u where u.role.roleName='ROLE_AGENT'")
    public List<User> getByAgent();

}
