package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.model.AppointmentStatus;
import mum.edu.project.model.BookAppointment;
import mum.edu.project.repository.AppointmentRepository;
import mum.edu.project.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public List<BookAppointment> getAllAppointment() {
		return (List<BookAppointment>) appointmentRepository.findAll();
	}

	@Override
	public BookAppointment getAppointmentById(Long id) {
		return appointmentRepository.findOne(id);
	}

	@Override
	public BookAppointment saveAppointment(BookAppointment bookAppointment) {
		appointmentRepository.save(bookAppointment);
		return bookAppointment;
	}

	@Override
	public void removeAppointment(BookAppointment bookAppointment) {
		appointmentRepository.delete(bookAppointment);
	}

	@Override
	public BookAppointment updateAppointment(BookAppointment bookAppointment) {
		appointmentRepository.save(bookAppointment);
		return bookAppointment;
	}

	@Override
	public BookAppointment changeStatus(long id, AppointmentStatus status) {
		BookAppointment bookAppointment = appointmentRepository.findOne(id);
		bookAppointment.setAppointmentStatus(status);
		appointmentRepository.save(bookAppointment);
		return bookAppointment;
	}

	@Override
	public List<BookAppointment> getAppointmentByStatus(AppointmentStatus status) {
		return appointmentRepository.allApproved(status);
	}

}
