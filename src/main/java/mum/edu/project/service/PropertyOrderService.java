package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.PropertyOrder;

public interface PropertyOrderService {
	public PropertyOrder getById(Long id);

	public List<PropertyOrder> getAll();

	public PropertyOrder save(PropertyOrder property);

}
