package com.fatihari.homework3.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Document(collection = "category") //table name(entity)
public class Category 
{
	@Id
    @Column(name = "_id", nullable = false)
    private String _id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "refractive") // Kırılım
    private String refractive;

	@DBRef
    private Category upper_category;

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

	public String getRefractive() {
		return refractive;
	}

	public void setRefractive(String refractive) {
		this.refractive = refractive;
	}

	public Category getUpper_category() {
		return upper_category;
	}

	public void setUpper_category(Category upper_category) {
		this.upper_category = upper_category;
	}

	@Override
	public String toString() {
		return "Category [id=" + _id + ", name=" + name + ", refractive=" + refractive + ", upper_category="
				+ upper_category + "]";
	}
}
