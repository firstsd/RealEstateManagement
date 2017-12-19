/*
 * Created on Nov 17, 2017
 */
package mum.edu.project.controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.project.model.Property;
import mum.edu.project.model.dto.SearchPropertyDto;
import mum.edu.project.model.helper.PropertyListModel;
import mum.edu.project.service.PropertyService;
import mum.edu.project.service.UserService;

@Controller
@SessionAttributes("currentUser")
public class SearchPropertiesController {
	@Autowired
	ServletContext servletContext;

	@Autowired
	PropertyService propertyService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/property/search", method = RequestMethod.POST)
	public String save(@ModelAttribute("searchDto") SearchPropertyDto searchDto ,
			RedirectAttributes redirect, Model model, HttpSession session) throws FileNotFoundException {
		
	    List<Property> properties;
	    if(StringUtils.isEmpty(searchDto.getTextSearch())) {
	        properties = propertyService.searchPropertyWithoutName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()));
	    }else {
	        properties = propertyService.searchPropertyWithName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()),searchDto.getTextSearch());
	    }
	        
	    
        PropertyListModel plistmodel = new  PropertyListModel();
        plistmodel.setPropertyList(properties);
        plistmodel.setTotalItemCount(properties.size());
        plistmodel.setCurrentPage(1);
        redirect.addFlashAttribute("propertyListModel", plistmodel);
		return "redirect:/property/Searchlist";
	}
	
	@RequestMapping(value = "/property/Searchlist", method = RequestMethod.GET)
    public String appointmentList(Model model) {
        return "properties/property_list";
    }
	
	private List<String> buildSearchFromCombo(String search) {
	    String[] s = search.split(",");
	    List<String> result = Arrays.asList(s);
	    return result;
	}

	 
	@RequestMapping(value = "/property/ajaxsearch", method = RequestMethod.POST)
	public @ResponseBody List<Property> searchByAjax(@Valid @RequestBody SearchPropertyDto searchDto) {
		List<Property> properties = propertyService.getAll();
	    if(StringUtils.isEmpty(searchDto.getTextSearch())) {
	        properties = propertyService.searchPropertyWithoutName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()));
	    }else {
	        properties = propertyService.searchPropertyWithName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()),searchDto.getTextSearch());
	    }
		return properties;
	}
	
	@RequestMapping(value = "/property/ajaxsearchlist", method = RequestMethod.POST)
	public @ResponseBody List<Property> searchByAjaxlist(@Valid @RequestBody SearchPropertyDto searchDto) {
		List<Property> properties = propertyService.getAll();
		System.out.println("Text"+searchDto.getTextSearch());
	    if(StringUtils.isEmpty(searchDto.getTextSearch())) {
	        properties = propertyService.searchPropertyWithoutName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()));
	    }else {
	        properties = propertyService.searchPropertyWithName(buildSearchFromCombo(searchDto.getPurpose()), buildSearchFromCombo(searchDto.getType()),searchDto.getTextSearch());
	    }
	    
		return properties;
	}
	
}