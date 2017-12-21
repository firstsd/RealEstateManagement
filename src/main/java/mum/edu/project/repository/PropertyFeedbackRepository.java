package mum.edu.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.project.domain.PropertyFeedback;

@Repository
public interface PropertyFeedbackRepository extends CrudRepository<PropertyFeedback, Long> {

}
