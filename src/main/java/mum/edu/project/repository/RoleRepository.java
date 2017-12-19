package mum.edu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.project.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    
    @Query("SELECT r FROM Role r WHERE r.roleName not in ('ROLE_ADMIN','ROLE_AGENT') ")
    public List<Role> getRoleNotAdmin();
}
