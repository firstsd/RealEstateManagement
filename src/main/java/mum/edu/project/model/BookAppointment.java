package mum.edu.project.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class BookAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	private Property property;
	@OneToOne
	private User buyer;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "appointmentDate")
	private LocalDateTime  appointmentDate;
	@NotNull
	@JoinColumn(name = "appointmenComment")
	private String appointmentComment;
	@Column(name="appointmentStatus")
	private AppointmentStatus appointmentStatus;

	// #region [getter setter]
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public LocalDateTime  getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime  appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentComment() {
		return appointmentComment;
	}

	public void setAppointmentComment(String appointmentComment) {
		this.appointmentComment = appointmentComment;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	// #endregion
}
