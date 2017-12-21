package mum.edu.project.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PropertyOrder {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;


	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="account")
	private User account;
	
	public User getAccount() {
		return account;
	}
	public void setAccount(User account) {
		this.account = account;
	}
	@Column(name="registerDate")
	@DateTimeFormat(pattern="yyyy/mm/dd")
	@NotNull
	private Date registerDate;

	@NotNull
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="property_id")
	private Property property;

	@Column(name="status")
//	@NotNull
	private int status;

//	@NotNull
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="seller_id")
	private User seller;

	@Column(name="comment")
	private String comment;

//rent
	@Column(name="rentMonth")
//	@NotNull
	private int rentMonth;

	@Column(name="perMonthPrice")
//	@NotNull
	private double perMonthPrice;

	@Column(name="deposit")
//	@NotNull
	private double deposit;

	//boolean
	@Column(name="extendtable")
	private boolean extendable;
	
//buy
	@Column(name="buyPrice")
//	@NotNull
	private double buyPrice;
	
	private String orderType;

	public int getRentMonth() {
		return rentMonth;
	}
	public void setRentMonth(int rentMonth) {
		this.rentMonth = rentMonth;
	}
	public double getPerMonthPrice() {
		return perMonthPrice;
	}
	public void setPerMonthPrice(double perMonthPrice) {
		this.perMonthPrice = perMonthPrice;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public boolean isExtendable() {
		return extendable;
	}
	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	//	public abstract double calculatePrice();
	public PropertyOrder(){}
//	PropertyOrder(Long id, User account, Date registerDate, Property property, int status, User seller, String comment) {
//		super();
//		this.id = id;
////		this.account = account;
//		this.registerDate = registerDate;
//		this.property_id = property;
//		this.status = status;
//		this.seller_id = seller;
//		this.comment = comment;
//	}

	// #region [getter setter]
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public User getAccount() {
//		return account;
//	}
//
//	public void setAccount(User account) {
//		this.account = account;
//	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	// #endregion
}
