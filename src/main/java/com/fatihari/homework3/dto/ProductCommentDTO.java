package com.fatihari.homework3.dto;

import java.util.Date;

public class ProductCommentDTO
{
	private String _id;

    private String comment_text;

    private String comment_date;

    private String product_id;
    
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
}
