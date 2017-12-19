/*
 * Created on Nov 16, 2017
 */
package mum.edu.project.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mum.edu.project.model.AppointmentStatus;
import mum.edu.project.model.BookAppointment;
import mum.edu.project.model.Property;
import mum.edu.project.model.User;
import mum.edu.project.repository.AppointmentRepository;
import mum.edu.project.service.impl.AppointmentServiceImpl;

public class AppointmentServiceTest {

	@Mock
	AppointmentRepository appointmentRepositoryMock;

	@InjectMocks
	AppointmentServiceImpl appointmentService;

	List<BookAppointment> appointmentList = new ArrayList<BookAppointment>();

	@Before
	public void appoitmentSaveTest() {
		MockitoAnnotations.initMocks(this);
		// test data 1
		BookAppointment bookAppointment1 = new BookAppointment();
		bookAppointment1.setId(Long.valueOf(1));
		bookAppointment1.setAppointmentComment("Comment 1");
		bookAppointment1.setAppointmentDate(LocalDateTime.now());
		bookAppointment1.setAppointmentStatus(AppointmentStatus.PENDING);
		Property p1 = new Property();
		p1.setName("Appartment");
		bookAppointment1.setProperty(p1);
		User user1 = new User();
		user1.setFirstName("Aldarkhangai");
		user1.setLastName("Chimed-Ochir");
		bookAppointment1.setBuyer(user1);
		// test data 2
		BookAppointment bookAppointment2 = new BookAppointment();
		bookAppointment2.setId(Long.valueOf(2));
		bookAppointment2.setAppointmentComment("Comment 2");
		bookAppointment2.setAppointmentDate(LocalDateTime.now());
		bookAppointment2.setAppointmentStatus(AppointmentStatus.APPROVED);
		Property p2 = new Property();
		p2.setName("House");
		bookAppointment2.setProperty(p2);
		User user2 = new User();
		user2.setFirstName("Enkhtsatral");
		user2.setLastName("Byambaa");
		bookAppointment2.setBuyer(user2);
		appointmentList.add(bookAppointment1);
		appointmentList.add(bookAppointment2);

	}

	@Test
	public void getAll() throws Exception {
		when(appointmentRepositoryMock.findAll()).thenReturn(appointmentList);
		List<BookAppointment> alist = appointmentService.getAllAppointment();
		if (!alist.isEmpty()) {
			for (BookAppointment ba : alist) {
				System.out.println("Id: " + ba.getId());
				System.out.println("Property: " + ba.getProperty().getName());
				System.out.println("User first name: " + ba.getBuyer().getFirstName());
				System.out.println("User last name: " + ba.getBuyer().getLastName());
				System.out.println("Status: " + ba.getAppointmentStatus());
				System.out.println("Comment: " + ba.getAppointmentComment());
				System.out.println("------------------------");
			}
		}
	}
}
