package mum.edu.project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.project.constants.Constants;
import mum.edu.project.domain.Property;
import mum.edu.project.domain.PropertyOrder;
import mum.edu.project.domain.User;
import mum.edu.project.domain.dto.PropertyOrderDto;
import mum.edu.project.service.PropertyOrderService;
import mum.edu.project.service.PropertyService;

@Controller
@SessionAttributes("currentUser")
@RequestMapping(value="/order")
public class PropertyOrderController {
	@Autowired
	PropertyOrderService propertyOrderService;
	
	@Autowired
	PropertyService propertyService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String add(@RequestParam("orderId") Long orderId, Model model) {
		PropertyOrder propertyOrder = propertyOrderService.getById(orderId);
		model.addAttribute("order",propertyOrder);
		return "order/order_item";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String add(@RequestParam("propertyId") Long propertyId, @ModelAttribute("order") PropertyOrderDto propertyOrderDto, Model model) {
		Property property = propertyService.getById(propertyId);
		model.addAttribute("property",property);
		return "order/order_register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String save(@RequestParam("propertyId") Long propertyId, @Valid @ModelAttribute("order") PropertyOrderDto propertyOrderDto, BindingResult result,
			RedirectAttributes redirect, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Property property = propertyService.getById(propertyId);
			model.addAttribute("property",property);
			return "order/order_register";
		}
		User loginUser = new User();
		if(session.getAttribute("currentUser")!=null) {
			loginUser = (User) session.getAttribute("currentUser");
		}

		PropertyOrder propertyOrder = new PropertyOrder();
		propertyOrder.setAccount(loginUser);
		propertyOrder.setProperty(propertyService.getById(Long.valueOf(propertyOrderDto.getPropertyId())));
		if(propertyOrderDto.getOfferBuyAmount()!=null)
			propertyOrder.setBuyPrice(propertyOrderDto.getOfferBuyAmount());
		propertyOrder.setComment(propertyOrderDto.getComment());
		if(propertyOrderDto.getOfferRentDespositAmount()!=null)
			propertyOrder.setDeposit(propertyOrderDto.getOfferRentDespositAmount());
		boolean f = false;
		if(propertyOrderDto.getOfferIsExtend()!=null) {
			f = (propertyOrderDto.getOfferIsExtend().equals("1"))?true:false;
		}
		propertyOrder.setExtendable(f);
		if(propertyOrderDto.getOfferRentPerMonthAmount()!=null) 
			propertyOrder.setPerMonthPrice(propertyOrderDto.getOfferRentPerMonthAmount());
//		propertyOrder.setProperty(propertyOrderDto.get);
		propertyOrder.setRegisterDate(new Date());
		if(propertyOrderDto.getOfferRentMonths()!=null) 
			propertyOrder.setRentMonth(propertyOrderDto.getOfferRentMonths());
//		propertyOrder.setSeller(propertyOrderDto.get);
		propertyOrder.setStatus(Constants.PROPERTY.STATUS.PENDING);
			
		propertyOrderService.save(propertyOrder);
		return "redirect:/property/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		List<PropertyOrder> orderList = (List<PropertyOrder>) propertyOrderService.getAll(); 
		model.addAttribute("orderList", orderList);
		User loginUser = new User();
		if(session.getAttribute("currentUser")!=null) {
			loginUser = (User) session.getAttribute("currentUser");
		}
		model.addAttribute("currentUser", loginUser);

		return "order/order_list";
	}

}
