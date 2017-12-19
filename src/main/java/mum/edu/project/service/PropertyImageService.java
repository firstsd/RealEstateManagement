package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.PropertyImage;

public interface PropertyImageService {
    PropertyImage getById(Long id);
    
    PropertyImage save(PropertyImage propertyImage);
    
    List<PropertyImage> getAll();
    
}
