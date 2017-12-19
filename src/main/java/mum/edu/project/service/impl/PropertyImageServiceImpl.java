package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.model.PropertyImage;
import mum.edu.project.repository.PropertyImageRepository;
import mum.edu.project.service.PropertyImageService;

@Service
public class PropertyImageServiceImpl implements PropertyImageService {

	@Autowired
	PropertyImageRepository repository;
	
	@Override
	public PropertyImage getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public PropertyImage save(PropertyImage propertyImage) {
		// TODO Auto-generated method stub
		return repository.save(propertyImage);
	}

	@Override
	public List<PropertyImage> getAll() {
		// TODO Auto-generated method stub
		return (List<PropertyImage>) repository.findAll();
	}

}
