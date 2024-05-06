package com.capstoneproject.mobilestore.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Mobiles")
public class Mobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mob_seq")
	@SequenceGenerator(name = "mob_seq", sequenceName = "mobile_seq", allocationSize = 1)
	private int mobileId;
	
	@Column
	private String mobileName;
	
	@Column
	private float mobileCost;
	
	@Column
	private LocalDate manufacturedDate;
	
	@Column
	private String mobileNumber;
	
	@ManyToOne
	private Category category;
	
	@Column
	private String companyName;

	public Mobile(int mobileId, String mobileName, float mobileCost, LocalDate manufacturedDate, String mobileNumber,
			Category category, String companyName) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.manufacturedDate = manufacturedDate;
		this.mobileNumber = mobileNumber;
		this.category = category;
		this.companyName = companyName;
	}

	public Mobile(String mobileName, float mobileCost, LocalDate manufacturedDate, String mobileNumber,
			Category category, String companyName) {
		super();
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.manufacturedDate = manufacturedDate;
		this.mobileNumber = mobileNumber;
		this.category = category;
		this.companyName = companyName;
	}

	public Mobile(int mobileId) {
		super();
		this.mobileId = mobileId;
	}

	public Mobile() {
		super();
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public float getMobileCost() {
		return mobileCost;
	}

	public void setMobileCost(float mobileCost) {
		this.mobileCost = mobileCost;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileCost=" + mobileCost
				+ ", manufacturedDate=" + manufacturedDate + ", mobileNumber=" + mobileNumber + ", category=" + category
				+ ", companyName=" + companyName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mobileId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		return mobileId == other.mobileId;
	}
	
	
}