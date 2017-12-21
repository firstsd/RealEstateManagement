package mum.edu.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.edu.project.domain.AppointmentStatus;
import mum.edu.project.domain.BookAppointment;
import mum.edu.project.service.AppointmentService;

@Controller
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = "/bookappointment/list", method = RequestMethod.GET)
	public String appointmentList(Model model) {
//		List<BookAppointment> appointments = appointmentService.getAppointmentByStatus(AppointmentStatus.PENDING);
	    List<BookAppointment> appointments = appointmentService.getAllAppointment();
		model.addAttribute("appointments", appointments);
		return "bookappointment/book_appointment_list";
	}

	@RequestMapping(value = "/bookappointment/approve", method = RequestMethod.GET)
	public String appointmentApprove(@Valid @RequestParam("id") int id, @RequestParam("status") int status, Model model) {
	    if(status == 1) {	        
	        appointmentService.changeStatus(Long.valueOf(id), AppointmentStatus.APPROVED);
	    }else {
	        appointmentService.changeStatus(Long.valueOf(id), AppointmentStatus.CANCELLED);	        
	    }
		return "redirect:/bookappointment/list";
	}

}
