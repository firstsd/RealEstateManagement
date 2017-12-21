package mum.edu.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.project.domain.PurposeType;

@Repository
public interface PurposeTypeRepository extends CrudRepository<PurposeType, Long> {

}
