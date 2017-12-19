/*
 * Created on Nov 17, 2017
 */
package mum.edu.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.project.exception.SaveErrorException;
import mum.edu.project.factory.PropertyFactory;
import mum.edu.project.model.AppointmentStatus;
import mum.edu.project.model.BookAppointment;
import mum.edu.project.model.Property;
import mum.edu.project.model.PropertyImage;
import mum.edu.project.model.PropertyOrder;
import mum.edu.project.model.PropertyStatus;
import mum.edu.project.model.User;
import mum.edu.project.model.dto.PropertyDto;
import mum.edu.project.model.helper.PropertyListModel;
import mum.edu.project.model.helper.PropertyModel;
import mum.edu.project.service.AppointmentService;
import mum.edu.project.service.PropertyService;
import mum.edu.project.service.UserService;

@Controller
@SessionAttributes("currentUser")
public class PropertiesController {
	@Autowired
	ServletContext servletContext;

	@Autowired
	PropertyService propertyService;

	@Autowired
	UserService userService;

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = "/property/uploadProperty", method = RequestMethod.GET)
	public String uploadProperty(@ModelAttribute("newProperty") PropertyDto property, Model model) {
		List<User> agents = userService.getAgents();
		model.addAttribute("agents", agents);
		return "properties/property_upload";
	}

	@RequestMapping(value = "/property/uploadProperty", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("newProperty") PropertyDto propertyDto, BindingResult result,
			RedirectAttributes redirect, Model model, HttpSession session) throws FileNotFoundException {
		List<User> agents = userService.getAll();
		model.addAttribute("agents", agents);
		if (result.hasErrors()) {
			return "properties/property_upload";
		}
		User loginUser = new User();
		if (session.getAttribute("currentUser") != null) {
			loginUser = (User) session.getAttribute("currentUser");
		}

		Property sp = PropertyFactory.getInstance().createUserFromDto(propertyDto);

		User agentAccount = userService.getById(propertyDto.getAgentAccount().getId());
		propertyDto.setAgentAccount(agentAccount);
		sp.setAgentAccount(agentAccount);
		sp.setOwner(loginUser);

		List<PropertyImage> imagesDb = new ArrayList<PropertyImage>();
		List<MultipartFile> images = propertyDto.getInputImages();
		String imageName, mainPicturePathName = null;
		for (MultipartFile image : images) {
			// isEmpty means file exists BUT NO Content
			if (image != null && !image.isEmpty()) {
				try {
					manageDirectory("c:\\images");
					imageName = (new Date()).getTime() + "_" + image.getOriginalFilename();
					image.transferTo(new File("c:\\images\\" + imageName));
					imagesDb.add(new PropertyImage(imageName));
				} catch (Exception e) {
					throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename());
				}
			}
		}
		sp.setImages(imagesDb);
		if (imagesDb.size() > 0)
			sp.setMainPicturePath(imagesDb.get(0).getUrl());
		try {
			sp = propertyService.save(sp);
		} catch (SaveErrorException s) {
			s.setMessage("Save error");
		}
		redirect.addFlashAttribute("property", sp);
		return "redirect:/";
	}

	private void manageDirectory(String directoryName) {
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}
	// @RequestMapping(value="/property/uploadProperty", method = RequestMethod.GET)
	// public String view(Model model) {
	// return "properties/property_upload";

	@RequestMapping(value = "/property/requests", method = RequestMethod.GET)
	public String uploadProperty(Model model) {
		List<PropertyOrder> properties = propertyService.getPropertyOrders(PropertyStatus.PENDING);
		model.addAttribute("properties", properties);
		return "properties/pending_requests";
	}

	@RequestMapping(value = "/property/approve/{id}", method = RequestMethod.POST)
	public @ResponseBody String appointmentApprove(@RequestBody String str,@PathVariable("id") int id) {
		propertyService.changeStatus(id, PropertyStatus.APPROVED);
		return "success";

	}

	// @RequestMapping(value = "/property/approve", method = RequestMethod.GET)
	// public String appointmentApprove(@Valid @RequestParam("id") int id, Model
	// model) {
	// propertyService.changeStatus(id, PropertyStatus.APPROVED);
	// return "redirect:/property/requests";
	// }

	@RequestMapping(value = { "property/propertyList", "property" }, method = RequestMethod.GET)
	public String propertiesList(@RequestParam("id") String pId, Model model) {

		PropertyModel propertyModel = new PropertyModel();

		// hot Properties
		List<Property> hotProperties = new ArrayList<Property>();
		propertyModel.setHotPropertyList(hotProperties);

		// main Property
		try {
			Property mainProperty = propertyService.getById(Long.valueOf(pId));
			if (mainProperty != null) {
				propertyModel.setProperty(mainProperty);
				propertyModel.setPropertyFeedbackList(mainProperty.getFeedbacks());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		model.addAttribute("hotProperties", hotProperties);
		model.addAttribute("propertyModel", propertyModel);
		model.addAttribute("bookAppointment", new BookAppointment());
		return "properties/property_item";
	}

	@RequestMapping(value = "/property/list", method = RequestMethod.GET)
	public String appointmentList(Model model) {
		List<Property> properties = propertyService.getAll();
		PropertyListModel plistmodel = new PropertyListModel();
		plistmodel.setPropertyList(properties);
		plistmodel.setTotalItemCount(properties.size());
		plistmodel.setCurrentPage(1);
		model.addAttribute("propertyListModel", plistmodel);
		return "properties/property_list";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		dateFormat.setLenient(true);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/property/addAppointment", method = RequestMethod.POST)
	public String appointmentAdd(@Valid @ModelAttribute("bookappointment") BookAppointment bookAppointment,
			BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors())
			System.out.println(bindingResult.getErrorCount());
		User loginUser = new User();
		bookAppointment.setProperty(propertyService.getById(bookAppointment.getId()));
		bookAppointment.setAppointmentStatus(AppointmentStatus.PENDING);

		if (session.getAttribute("currentUser") != null) {
			loginUser = (User) session.getAttribute("currentUser");
		}
		bookAppointment.setBuyer(loginUser);
		appointmentService.saveAppointment(bookAppointment);
		return "redirect:/property/list";
	}

}