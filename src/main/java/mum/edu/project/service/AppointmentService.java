package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.AppointmentStatus;
import mum.edu.project.model.BookAppointment;

public interface AppointmentService {
	public List<BookAppointment> getAllAppointment();
	public BookAppointment getAppointmentById(Long id);
	public BookAppointment saveAppointment(BookAppointment bookAppointment);
	public void removeAppointment(BookAppointment bookAppointment);
	public BookAppointment updateAppointment(BookAppointment bookAppointment);
	public BookAppointment changeStatus(long id, AppointmentStatus status);
	public List<BookAppointment> getAppointmentByStatus(AppointmentStatus status);
	
}
