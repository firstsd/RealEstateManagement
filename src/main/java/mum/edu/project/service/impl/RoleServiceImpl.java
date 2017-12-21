package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.domain.Role;
import mum.edu.project.repository.RoleRepository;
import mum.edu.project.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired 
	RoleRepository rolerepository;

	@Override
	public List<Role> getAllRole() {
		
		return (List<Role>)rolerepository.findAll();
	}

	@Override
	public Role getRoleById(long id) {
		return rolerepository.findOne(id);
	}

	@Override
	public Role saveOrder(Role role) {
		return rolerepository.save(role);
	}
	
	@Override
	public List<Role> getRoleNotAdmin(){
	    return rolerepository.getRoleNotAdmin();
	}
	
}
