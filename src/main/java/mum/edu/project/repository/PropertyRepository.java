package mum.edu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.project.model.Property;
import mum.edu.project.model.PropertyOrder;
import mum.edu.project.model.PropertyStatus;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
	@Query(value="select p from Property p where p.status = :status")
	public List<PropertyOrder> pendingRequest(@Param("status") PropertyStatus status);
	
	@Query(value="select p from Property p where p.status = :status ")
	public List<Property> getPropertiesByStatus(@Param("status") PropertyStatus status);
	
	@Query(value = "select p from Property p where p.name like %:name% AND p.purposeName in :purposes and p.propertyType in :types")
	public List<Property> searchPropertyWithName(@Param("purposes") List<String> purpose ,
                                                 @Param("types")List<String> types ,
                                                 @Param("name") String name);

	@Query(value = "select p from Property p where p.purposeName in :purposes and p.propertyType in :types")
	//and p.propertyType='apartment
    public List<Property> searchPropertyWithoutName(@Param("purposes") List<String> purpose ,
                                                    @Param("types")List<String> types );

}
