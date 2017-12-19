package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import mum.edu.project.model.PropertyOrder;
import mum.edu.project.repository.PropertyOrderRepository;
import mum.edu.project.service.PropertyOrderService;

@Service
public class PropertyOrderServiceImpl implements PropertyOrderService {
	@Autowired
	PropertyOrderRepository repository;
	@Override
	public List<PropertyOrder> getAll() {
		// TODO Auto-generated method stub
		return (List<PropertyOrder>)  repository.findAll();
	}

	@Override
	public PropertyOrder getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public PropertyOrder save(PropertyOrder property) {
		// TODO Auto-generated method stub
		return repository.save(property);
	}

}
