package mum.edu.project.service;

import java.util.List;

import mum.edu.project.domain.Role;

public interface RoleService {
	public List<Role> getAllRole();
	public Role getRoleById(long id);
	public Role saveOrder(Role role);
	public List<Role> getRoleNotAdmin();
}
