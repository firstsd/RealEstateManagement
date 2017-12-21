package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.domain.PropertyFeedback;
import mum.edu.project.repository.PropertyFeedbackRepository;
import mum.edu.project.service.PropertyFeedbackService;

@Service
public class PropertyFeedbackServiceImpl implements PropertyFeedbackService {
    
    @Autowired
    PropertyFeedbackRepository propertiyFeedbackRepository;
    
	@Override
	public PropertyFeedback save(PropertyFeedback propertyFeedback) {
		return propertiyFeedbackRepository.save(propertyFeedback);
	}

	@Override
	public PropertyFeedback getById(Long id) {
		return propertiyFeedbackRepository.findOne(id);
	}

	@Override
	public List<PropertyFeedback> getAll() {
		return (List<PropertyFeedback>) propertiyFeedbackRepository.findAll();
	}
}
