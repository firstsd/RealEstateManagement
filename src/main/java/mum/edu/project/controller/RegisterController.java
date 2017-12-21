package mum.edu.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.project.domain.Role;
import mum.edu.project.domain.User;
import mum.edu.project.service.RoleService;
import mum.edu.project.service.UserService;
@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@Autowired
    RoleService roleService;
	
	@RequestMapping(value ="/register" , method = RequestMethod.POST)
	 public String saveUser(@Valid @ModelAttribute("user")User user, BindingResult br, RedirectAttributes ra, Model model) {
	     //request.setAttribute("msg", null);
		if(br.hasErrors()) {
	    	List<Role> roles = roleService.getRoleNotAdmin();
	    	model.addAttribute("roles",roles);
		    return "register";		    
		}
//		User user = UserFactory.getInstance().createUserFromDto(user);
		user.setRole(roleService.getRoleById(user.getRole().getId()));
		userService.save(user);
	    ra.addFlashAttribute("user",user);
	    ra.addFlashAttribute("msg","you've successfully registered, please login with credentials.");
	     return "redirect:/login";
	 }
	 
	
}
