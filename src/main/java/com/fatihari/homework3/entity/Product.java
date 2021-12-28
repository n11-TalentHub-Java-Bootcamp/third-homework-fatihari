package com.fatihari.homework3.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product") //table name(entity)
public class Product {
    @Id
    @Column(name = "_id", nullable = false)
    private String _id;

    @Column(length = 50, name = "name")
    private String name;

    @Column(name = "price" , precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String registration_date;

    private String category_id;
   
	@Override
	public String toString() {
		return "Product [_id=" + _id + ", name=" + name + ", price=" + price + ", registration_date=" + registration_date
				+ ", category_id=" + category_id + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
}
