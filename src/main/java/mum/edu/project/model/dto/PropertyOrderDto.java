package mum.edu.project.model.dto;


import javax.validation.constraints.NotNull;

public class PropertyOrderDto {

	private Integer offerBuyAmount;
	private Integer propertyId;
	private Integer offerRentMonths;
	
	private Integer offerRentPerMonthAmount;
	private Integer offerRentDespositAmount;
	private String offerIsExtend;

	private String comment;
	
	public Integer getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Integer property) {
		this.propertyId = property;
	}
	public Integer getOfferBuyAmount() {
		return offerBuyAmount;
	}
	public void setOfferBuyAmount(Integer amount) {
		this.offerBuyAmount = amount;
	}
	public Integer getOfferRentMonths() {
		return offerRentMonths;
	}
	public void setOfferRentMonths(Integer offerRentMonths) {
		this.offerRentMonths = offerRentMonths;
	}
	public Integer getOfferRentPerMonthAmount() {
		return offerRentPerMonthAmount;
	}
	public void setOfferRentPerMonthAmount(Integer offerRentPerMonthAmount) {
		this.offerRentPerMonthAmount = offerRentPerMonthAmount;
	}
	public Integer getOfferRentDespositAmount() {
		return offerRentDespositAmount;
	}
	public void setOfferRentDespositAmount(Integer offerRentDespositAmount) {
		this.offerRentDespositAmount = offerRentDespositAmount;
	}
	public String getOfferIsExtend() {
		return offerIsExtend;
	}
	public void setOfferIsExtend(String offerIsExtend) {
		this.offerIsExtend = offerIsExtend;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
