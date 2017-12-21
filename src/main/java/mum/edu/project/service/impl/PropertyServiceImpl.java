package mum.edu.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.domain.Property;
import mum.edu.project.domain.PropertyOrder;
import mum.edu.project.domain.PropertyStatus;
import mum.edu.project.repository.PropertyRepository;
import mum.edu.project.service.PropertyService;

@Service
// @Transactional
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepository propertyRepository;

	public Property getById(Long id) {
		return (Property) propertyRepository.findOne(id);
	}

	public List<Property> getAll() {
		return (List<Property>) propertyRepository.findAll();
	}

	public Property save(Property property) {
		return propertyRepository.save(property);
	}

	public List<Property> getByOwner(Integer ownerId) {
		return (List<Property>) propertyRepository.findAll();
		// return (List<Property>) propertyRepository.findByOwner(ownerId);
	}

	@Override
	public List<PropertyOrder> getPropertyOrders(PropertyStatus status) {
		return propertyRepository.pendingRequest(status);
	}

	@Override
	public Property changeStatus(int id, PropertyStatus status) {
		Property property = propertyRepository.findOne(Long.valueOf(id));
		property.setStatus(status);
		property.setApprovedDate(new Date());
		propertyRepository.save(property);
		return property;
	}

	public List<Property> getPropertiesByStatus(PropertyStatus status){
	    return propertyRepository.getPropertiesByStatus(status);
	}
	
	public List<Property> searchPropertyWithoutName(List<String> purpose, List<String> type) {
	    return propertyRepository.searchPropertyWithoutName(purpose,type);
	}

	 
	public List<Property> searchPropertyWithName(List<String> purpose, List<String> type, String name){
	    return propertyRepository.searchPropertyWithName(purpose,type,name);
	}
}
