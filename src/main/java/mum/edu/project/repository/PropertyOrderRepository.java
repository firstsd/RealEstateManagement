package mum.edu.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.project.model.PropertyOrder;

@Repository
public interface PropertyOrderRepository extends CrudRepository<PropertyOrder, Long> {

}
