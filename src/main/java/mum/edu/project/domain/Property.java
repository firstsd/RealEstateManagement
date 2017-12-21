package mum.edu.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Property implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@NotNull
	@Column(name="name")
	protected String name;
	@NotNull
	@Column(name="address")
	private String address;
	
//	@NotNull
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="owner")
	private User owner;
	
	@Column(name="bedroom")
	private int bedroom;
	
	@Column(name="bathroom")
	private int bathroom;
	
	@Column(name="status")
	private PropertyStatus status;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="approved")
	private User approvedBy;
	
	@Column(name="register_date")
	private Date registerDate;
	
	@Column(name="approved_date")
	private Date approvedDate;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "agent")
	private User agentAccount;
	
	@Column(name="utilities_cost")
	private double utilitiesCost;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "purposetype")
	private PurposeType purposeType;

	// added
	@Column(name="main_picture_path")
	private String mainPicturePath;
	
	@Column(name="livingroom")
	private int livingroom;
	
	@Column(name="parking")
	private int parking;
	
	@Column(name="kitchen")
	private int kitchen;
	
	@Column(name="purpose_key")
	private String purposeKey;

	// added detail menu
	@Column(name="subject")
	private String subject;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="property_id")
	private List<PropertyImage> images;
	
	@Column(name="description")
	private String description;
	
	@Column(name="google_map_path")
	private String googleMapPath;
	
	@Column(name="property_type")
	private String propertyType;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="property_id")
	private List<PropertyFeedback> feedbacks = new ArrayList<PropertyFeedback>();
	
	
    public List<PropertyFeedback> getFeedbacks() {
        return feedbacks;
    }

    
    public void setFeedbacks(List<PropertyFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    private String purposeName;

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Column(name="floor")
	private int floor;

	@Column(name="yard")
	private double yard;

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getYard() {
		return yard;
	}

	public void setYard(double yard) {
		this.yard = yard;
	}

	public Property() {
		
	}

	public String getMainPicturePath() {
		return mainPicturePath;
	}

	public void setMainPicturePath(String mainPicturePath) {
		this.mainPicturePath = mainPicturePath;
	}

	public int getLivingroom() {
		return livingroom;
	}

	public void setLivingroom(int livingroom) {
		this.livingroom = livingroom;
	}

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public String getPurposeKey() {
		return purposeKey;
	}

	public void setPurposeKey(String purposeKey) {
		this.purposeKey = purposeKey;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

//	public List<String> getPicturePathList() {
//		return picturePathList;
//	}
//
//	public void setPicturePathList(List<String> picturePathList) {
//		this.picturePathList = picturePathList;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoogleMapPath() {
		return googleMapPath;
	}

	public void setGoogleMapPath(String googleMapPath) {
		this.googleMapPath = googleMapPath;
	}

	// #region [getter setter]
	public PurposeType getPurposeType() {
		return purposeType;
	}

	public void setPurposeType(PurposeType purposeType) {
		this.purposeType = purposeType;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public PropertyStatus getStatus() {
		return status;
	}

	public void setStatus(PropertyStatus status) {
		this.status = status;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public User getAgentAccount() {
		return agentAccount;
	}

	public void setAgentAccount(User agentAccount) {
		this.agentAccount = agentAccount;
	}

	public double getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(double utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String pAddress) {
		this.address = pAddress;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User pOwner) {
		this.owner = pOwner;
	}
	
	public List<PropertyImage> getImages() {
		return images;
	}

	public void setImages(List<PropertyImage> images) {
		this.images = images;
	}

}
