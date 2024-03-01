package com.skillstorm.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GroceryItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long groceryId;
	
	String description;
	
	int quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	OrderInfo order;

	public long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(long groceryId) {
		this.groceryId = groceryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (groceryId ^ (groceryId >>> 32));
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + quantity;
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
		GroceryItem other = (GroceryItem) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (groceryId != other.groceryId) {
			return false;
		}
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!order.equals(other.order)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "GroceryItem [groceryId=" + groceryId + ", description=" + description + ", quantity=" + quantity
				+ ", order=" + order.getOrderId() + "]";
	}

}
