package mum.edu.project.domain.helper;
import java.util.List;

import mum.edu.project.domain.Property;
import mum.edu.project.domain.PropertyFeedback;

public class PropertyModel {

	private List<Property> hotPropertyList;
	private Property property;
	private List<PropertyFeedback> propertyFeedbackList;

	public List<Property> getHotPropertyList() {
		return hotPropertyList;
	}

	public void setHotPropertyList(List<Property> hotPropertyList) {
		this.hotPropertyList = hotPropertyList;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<PropertyFeedback> getPropertyFeedbackList() {
		return propertyFeedbackList;
	}

	public void setPropertyFeedbackList(List<PropertyFeedback> propertyFeedbackList) {
		this.propertyFeedbackList = propertyFeedbackList;
	}

}
