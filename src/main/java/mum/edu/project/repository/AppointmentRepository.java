package mum.edu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.project.domain.AppointmentStatus;
import mum.edu.project.domain.BookAppointment;

@Repository
public interface AppointmentRepository extends CrudRepository<BookAppointment, Long> {

	@Query(value="select a from BookAppointment a where a.appointmentStatus = :status")
	public List<BookAppointment> allApproved(@Param("status") AppointmentStatus status);

}
