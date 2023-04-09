package com.in28minutes.unittesting.unittesting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "vendor")
	private String vendor;
	@Column(name = "Model")
	private String model;
	private int price;

	public Item() {

	}

	public Item(int id, String vendor, String model, int price) {
		this.id = id;
		this.vendor = vendor;
		this.model = model;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getVendor() {
		return vendor;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}



	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, vendor, model, price);
	}
}
