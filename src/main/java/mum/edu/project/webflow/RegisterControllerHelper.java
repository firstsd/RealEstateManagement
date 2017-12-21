package mum.edu.project.webflow;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.edu.project.domain.Role;
import mum.edu.project.domain.User;
import mum.edu.project.service.RoleService;
import mum.edu.project.service.UserService;

@Component
public class RegisterControllerHelper {
	@Autowired
	UserService userService;
	
	@Autowired
    RoleService roleService;
	
	public User createUser() {
		return new User();
	}

	public User saveUser(User user) {
		user.setRole(roleService.getRoleById(user.getRole().getId()));
		return userService.save(user);
	}

	public List<Role> getRoleNotAdmin() {
		List<Role> roles = roleService.getRoleNotAdmin();
		return roles;		
	}

	public User getCurrentUser(HttpSession session) {
		User loginUser = new User();
		if(session.getAttribute("currentUser")!=null) {
			loginUser = (User) session.getAttribute("currentUser");
		}
		return loginUser;		
	}

}
