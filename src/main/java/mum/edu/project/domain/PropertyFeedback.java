package mum.edu.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PropertyFeedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@NotNull
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User account;
	@Column(name="comment")
	private String comment;
//	@NotNull
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
//	@JoinColumn(name="property_id")
//	private Property property;

	@Column(name="register_date")
	private Date registerDate;
	
	@Column(name="status")
	private int status;

	// #region [getter setter]
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAccount() {
		return account;
	}

	public void setAccount(User account) {
		this.account = account;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

//	public Property getProperty() {
//		return property;
//	}
//
//	public void setProperty(Property property) {
//		this.property = property;
//	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	// #endregion
}
