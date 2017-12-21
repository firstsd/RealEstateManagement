package mum.edu.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PurposeType {
	@Column(name="sell_price")
	private double sellPrice;

	@NotNull
	@Column(name="rent_month")
	private double rentMonth;
	
	@NotNull
	@Column(name="per_month_price")
	private double perMonthPrice;
	@Column(name="deposit")
	private double deposit;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Long id;
    
    public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getRentMonth() {
		return rentMonth;
	}

	public void setRentMonth(double rentMonth) {
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

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double calculatePrice() {
        if(getSellPrice() <= 0) {
            return getRentMonth() * getPerMonthPrice();
        }else {
            return getSellPrice();
        }
        
    }
}

