package mum.edu.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.project.domain.User;
import mum.edu.project.service.UserService;

public class EmailValidaor implements ConstraintValidator<DuplicatedEmail, String> {

	@Autowired
	private UserService userService;

	@Override
	public void initialize(DuplicatedEmail arg0) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    User user = null;
		try {
		    user = userService.getByEmail(value);
		} catch (Exception e) {
			System.out.println("Couldn't find user...");
		}
		return user == null ? true : false;
	}

}
