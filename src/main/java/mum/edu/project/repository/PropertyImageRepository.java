package mum.edu.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.project.model.PropertyImage;

@Repository
public interface PropertyImageRepository extends CrudRepository<PropertyImage, Long> {

}
