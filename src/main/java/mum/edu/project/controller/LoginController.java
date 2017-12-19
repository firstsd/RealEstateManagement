/*
 * Created on Nov 15, 2017
 */
package mum.edu.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.project.model.Role;
import mum.edu.project.model.User;
import mum.edu.project.service.RoleService;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
       
	@Autowired
	RoleService roleService;
	
    @RequestMapping(value ="/login" , method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "login";
    }

    @RequestMapping(value ="/loginError" , method = RequestMethod.GET)
    public String loginFail(Model model) {
        //request.setAttribute("msg", null);
        model.addAttribute("msg","email or password is incorrect!!!");
        return "login";
    }
    
    @RequestMapping(value ="/register" , method = RequestMethod.GET)
    public String getRegister(@ModelAttribute("user") User user, Model model, HttpSession session) {
    	User loginUser = new User();
    	List<Role> roles = roleService.getRoleNotAdmin();;
        if(session.getAttribute("currentUser")==null) {
            roles = roleService.getRoleNotAdmin();
        } else {
            loginUser = (User) session.getAttribute("currentUser");
            if(loginUser.getRole().getRoleName().equalsIgnoreCase("ROLE_ADMIN")) {                
                roles = roleService.getAllRole();
            }
        }
        model.addAttribute("roles",roles);
        return "register";
    }
}
