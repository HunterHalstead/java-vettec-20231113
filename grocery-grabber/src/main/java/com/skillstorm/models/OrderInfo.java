package com.skillstorm.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long orderId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime scheduledTime;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference // This does not get serialized. It's accessed on the other end of the relationship.
	Customer customer;
	
	@OneToMany(mappedBy = "order")
	@JsonManagedReference
	List<GroceryItem> groceryItems;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(LocalDateTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<GroceryItem> getGroceryItems() {
		return groceryItems;
	}

	public void setGroceryItems(List<GroceryItem> groceryItems) {
		this.groceryItems = groceryItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((groceryItems == null) ? 0 : groceryItems.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((scheduledTime == null) ? 0 : scheduledTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderInfo other = (OrderInfo) obj;
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (groceryItems == null) {
			if (other.groceryItems != null) {
				return false;
			}
		} else if (!groceryItems.equals(other.groceryItems)) {
			return false;
		}
		if (orderId != other.orderId) {
			return false;
		}
		if (scheduledTime == null) {
			if (other.scheduledTime != null) {
				return false;
			}
		} else if (!scheduledTime.equals(other.scheduledTime)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", scheduledTime=" + scheduledTime + ", customer=" + customer.getName()
				+ ", groceryItems=" + groceryItems + "]";
	}
	

}
