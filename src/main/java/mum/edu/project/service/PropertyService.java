package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.Property;
import mum.edu.project.model.PropertyOrder;
import mum.edu.project.model.PropertyStatus;

public interface PropertyService {

	public Property getById(Long id);

	public List<Property> getAll();

	public Property save(Property property);
	
	public List<Property> getByOwner(Integer ownerId);
	
	public List<PropertyOrder> getPropertyOrders(PropertyStatus status);
	
	public Property changeStatus(int id, PropertyStatus status);
	
	public List<Property> getPropertiesByStatus(PropertyStatus status);
	
	public List<Property> searchPropertyWithoutName(List<String> purpose, List<String> type);
 
	public List<Property> searchPropertyWithName(List<String> purpose, List<String> type, String name);
}
