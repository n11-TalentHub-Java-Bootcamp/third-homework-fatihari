package com.fatihari.homework3.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
//@JsonIgnoreProperties({"_id", "product_id","user_account_id"})
@Document(collection = "product_comment") //table name(entity)
public class ProductComment
{
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

    @Id
	private String _id;

	/* "comment" is a reserved word in postgreSql and it is generally not a good idea to use reserved words for identifiers (tables or columns). 
	 * Therefore, "comment_text" is preferred as the column name.
	 */
    @Column(length = 500, name = "comment_text")
    private String comment_text;

    @Column(name = "comment_date")
    private String comment_date;

    private String product_id;

	@Column(name = "user_account_id")
    private String user_account_id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getUser_account_id() {
		return user_account_id;
	}

	public void setUser_account_id(String user_account_id) {
		this.user_account_id = user_account_id;
	}

	@Override
	public String toString() {
		return "ProductComment [_id=" + _id + ", comment_text=" + comment_text + ", comment_date=" + comment_date
				+ ", product_id=" + product_id + ", userAccount_id=" + user_account_id + "]";
	}
}
