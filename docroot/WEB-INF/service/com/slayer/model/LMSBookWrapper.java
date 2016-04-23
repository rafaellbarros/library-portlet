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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LMSBook}.
 * </p>
 *
 * @author rafael
 * @see LMSBook
 * @generated
 */
public class LMSBookWrapper implements LMSBook, ModelWrapper<LMSBook> {
	public LMSBookWrapper(LMSBook lmsBook) {
		_lmsBook = lmsBook;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSBook.class;
	}

	@Override
	public String getModelClassName() {
		return LMSBook.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("bookTitle", getBookTitle());
		attributes.put("author", getAuthor());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String bookTitle = (String)attributes.get("bookTitle");

		if (bookTitle != null) {
			setBookTitle(bookTitle);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this l m s book.
	*
	* @return the primary key of this l m s book
	*/
	@Override
	public long getPrimaryKey() {
		return _lmsBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s book.
	*
	* @param primaryKey the primary key of this l m s book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lmsBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this l m s book.
	*
	* @return the book ID of this l m s book
	*/
	@Override
	public long getBookId() {
		return _lmsBook.getBookId();
	}

	/**
	* Sets the book ID of this l m s book.
	*
	* @param bookId the book ID of this l m s book
	*/
	@Override
	public void setBookId(long bookId) {
		_lmsBook.setBookId(bookId);
	}

	/**
	* Returns the book title of this l m s book.
	*
	* @return the book title of this l m s book
	*/
	@Override
	public java.lang.String getBookTitle() {
		return _lmsBook.getBookTitle();
	}

	/**
	* Sets the book title of this l m s book.
	*
	* @param bookTitle the book title of this l m s book
	*/
	@Override
	public void setBookTitle(java.lang.String bookTitle) {
		_lmsBook.setBookTitle(bookTitle);
	}

	/**
	* Returns the author of this l m s book.
	*
	* @return the author of this l m s book
	*/
	@Override
	public java.lang.String getAuthor() {
		return _lmsBook.getAuthor();
	}

	/**
	* Sets the author of this l m s book.
	*
	* @param author the author of this l m s book
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_lmsBook.setAuthor(author);
	}

	/**
	* Returns the create date of this l m s book.
	*
	* @return the create date of this l m s book
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _lmsBook.getCreateDate();
	}

	/**
	* Sets the create date of this l m s book.
	*
	* @param createDate the create date of this l m s book
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_lmsBook.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this l m s book.
	*
	* @return the modified date of this l m s book
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _lmsBook.getModifiedDate();
	}

	/**
	* Sets the modified date of this l m s book.
	*
	* @param modifiedDate the modified date of this l m s book
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_lmsBook.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _lmsBook.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsBook.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsBook.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsBook.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsBook.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsBook.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsBook.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsBook.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsBook.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsBook.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSBookWrapper((LMSBook)_lmsBook.clone());
	}

	@Override
	public int compareTo(com.slayer.model.LMSBook lmsBook) {
		return _lmsBook.compareTo(lmsBook);
	}

	@Override
	public int hashCode() {
		return _lmsBook.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.slayer.model.LMSBook> toCacheModel() {
		return _lmsBook.toCacheModel();
	}

	@Override
	public com.slayer.model.LMSBook toEscapedModel() {
		return new LMSBookWrapper(_lmsBook.toEscapedModel());
	}

	@Override
	public com.slayer.model.LMSBook toUnescapedModel() {
		return new LMSBookWrapper(_lmsBook.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsBook.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsBook.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBook.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBookWrapper)) {
			return false;
		}

		LMSBookWrapper lmsBookWrapper = (LMSBookWrapper)obj;

		if (Validator.equals(_lmsBook, lmsBookWrapper._lmsBook)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSBook getWrappedLMSBook() {
		return _lmsBook;
	}

	@Override
	public LMSBook getWrappedModel() {
		return _lmsBook;
	}

	@Override
	public void resetOriginalValues() {
		_lmsBook.resetOriginalValues();
	}

	private LMSBook _lmsBook;
}