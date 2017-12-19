package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.PropertyFeedback;

public interface PropertyFeedbackService {
	PropertyFeedback getById(Long id);

	PropertyFeedback save(PropertyFeedback propertyFeedback);

	List<PropertyFeedback> getAll();
}
