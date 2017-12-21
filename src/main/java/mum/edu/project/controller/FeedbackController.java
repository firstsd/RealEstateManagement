package mum.edu.project.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.project.domain.Property;
import mum.edu.project.domain.PropertyFeedback;
import mum.edu.project.domain.User;
import mum.edu.project.service.PropertyFeedbackService;
import mum.edu.project.service.PropertyService;
@Controller
public class FeedbackController {
	
	@Autowired
    PropertyFeedbackService feedbackService;
	
	@Autowired
	PropertyService propertyService;
	
	
	@RequestMapping(value ="/property/feedback/addFeedback/{pid}" , method = RequestMethod.POST, produces="application/json")
	 public @ResponseBody PropertyFeedback saveFeedback(@Valid @RequestBody String feedback, @PathVariable("pid") String pid ,
	         HttpSession session) {
	    User loginUser =  null;
	    PropertyFeedback pFeedback = new PropertyFeedback();
	    if(session.getAttribute("currentUser")!=null) {
            loginUser = (User) session.getAttribute("currentUser");
        }
	    if(loginUser != null) {
    	    Property pro = propertyService.getById(Long.valueOf(pid));
    	    pFeedback.setComment(feedback);
    	    pFeedback.setRegisterDate(new Date());
    	    pFeedback.setAccount(loginUser);;
    //	    feedbackService.save(pFeedback);
    	    pro.getFeedbacks().add(pFeedback);
    	    propertyService.save(pro);
	    }
	    return pFeedback;
	 }
	 
	
}
