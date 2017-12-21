package mum.edu.project.domain.helper;

import java.util.List;

import mum.edu.project.domain.Property;

public class PropertyListModel {

	private int totalItemCount;
	private int currentPage;
	private final int pagerCount = 12;
	private int order;
	private String searchBy = "";
	private int searchPurposeTypeId;
	private int searchPropertyTypeId;

	private List<Property> hotPropertyList;
	private List<Property> propertyList;

	public PropertyListModel() {
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public int getSearchPurposeTypeId() {
		return searchPurposeTypeId;
	}

	public void setSearchPurposeTypeId(int searchPurposeTypeId) {
		this.searchPurposeTypeId = searchPurposeTypeId;
	}

	public int getSearchPropertyTypeId() {
		return searchPropertyTypeId;
	}

	public void setSearchPropertyTypeId(int searchPropertyTypeId) {
		this.searchPropertyTypeId = searchPropertyTypeId;
	}

	public List<Property> getHotPropertyList() {
		return hotPropertyList;
	}

	public void setHotPropertyList(List<Property> hotPropertyList) {
		this.hotPropertyList = hotPropertyList;
	}

	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}

}
