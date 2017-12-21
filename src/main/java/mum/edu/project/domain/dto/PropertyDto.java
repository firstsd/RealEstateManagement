package mum.edu.project.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import mum.edu.project.domain.PropertyStatus;
import mum.edu.project.domain.PurposeType;
import mum.edu.project.domain.User;

public class PropertyDto implements Serializable {
	
    private static final long serialVersionUID = 2323535L;

    @NotNull
	protected String name;
	@NotNull
	private String address;
	
	private User owner;
	
	private int bedroom;
	
	private int bathroom;
	
	private PropertyStatus status;
	
	private User approvedBy;
	
	private Date registerDate;
	
	private Date approvedDate;
	
	private User agentAccount;
	
	private double utilitiesCost;
	
	private PurposeType purposeType;
	private String purposeName;

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}

	// added
	private String mainPicturePath;
	
	private int livingroom;
	
	private int parking;
	
	private int kitchen;
	
	private String purposeKey;

	// added detail menu
	private String subject;
	
	private String description;
	
	private String googleMapPath;
	
	private int floor;

	private double yard;
	
	private String propertyType;

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

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

	private List<MultipartFile> inputImages;
	
	public PropertyDto() {
		
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

	public List<MultipartFile> getInputImages() {
		return inputImages;
	}

	public void setInputImages(List<MultipartFile> inputImages) {
		this.inputImages = inputImages;
	}

}
