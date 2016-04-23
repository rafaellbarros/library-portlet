/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.slayer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rafael
 * @generated
 */
public class LMSBookSoap implements Serializable {
	public static LMSBookSoap toSoapModel(LMSBook model) {
		LMSBookSoap soapModel = new LMSBookSoap();

		soapModel.setBookId(model.getBookId());
		soapModel.setBookTitle(model.getBookTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LMSBookSoap[] toSoapModels(LMSBook[] models) {
		LMSBookSoap[] soapModels = new LMSBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSBookSoap[][] toSoapModels(LMSBook[][] models) {
		LMSBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSBookSoap[] toSoapModels(List<LMSBook> models) {
		List<LMSBookSoap> soapModels = new ArrayList<LMSBookSoap>(models.size());

		for (LMSBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSBookSoap[soapModels.size()]);
	}

	public LMSBookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public String getBookTitle() {
		return _bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		_bookTitle = bookTitle;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _bookId;
	private String _bookTitle;
	private String _author;
	private Date _createDate;
	private Date _modifiedDate;
}