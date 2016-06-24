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
 * This class is a wrapper for {@link LMSBorrowing}.
 * </p>
 *
 * @author rafael
 * @see LMSBorrowing
 * @generated
 */
public class LMSBorrowingWrapper implements LMSBorrowing,
	ModelWrapper<LMSBorrowing> {
	public LMSBorrowingWrapper(LMSBorrowing lmsBorrowing) {
		_lmsBorrowing = lmsBorrowing;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSBorrowing.class;
	}

	@Override
	public String getModelClassName() {
		return LMSBorrowing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("borrowingId", getBorrowingId());
		attributes.put("bookId", getBookId());
		attributes.put("memberId", getMemberId());
		attributes.put("dateBorrowed", getDateBorrowed());
		attributes.put("dateReturned", getDateReturned());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long borrowingId = (Long)attributes.get("borrowingId");

		if (borrowingId != null) {
			setBorrowingId(borrowingId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Date dateBorrowed = (Date)attributes.get("dateBorrowed");

		if (dateBorrowed != null) {
			setDateBorrowed(dateBorrowed);
		}

		Date dateReturned = (Date)attributes.get("dateReturned");

		if (dateReturned != null) {
			setDateReturned(dateReturned);
		}
	}

	/**
	* Returns the primary key of this l m s borrowing.
	*
	* @return the primary key of this l m s borrowing
	*/
	@Override
	public long getPrimaryKey() {
		return _lmsBorrowing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s borrowing.
	*
	* @param primaryKey the primary key of this l m s borrowing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lmsBorrowing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the borrowing ID of this l m s borrowing.
	*
	* @return the borrowing ID of this l m s borrowing
	*/
	@Override
	public long getBorrowingId() {
		return _lmsBorrowing.getBorrowingId();
	}

	/**
	* Sets the borrowing ID of this l m s borrowing.
	*
	* @param borrowingId the borrowing ID of this l m s borrowing
	*/
	@Override
	public void setBorrowingId(long borrowingId) {
		_lmsBorrowing.setBorrowingId(borrowingId);
	}

	/**
	* Returns the book ID of this l m s borrowing.
	*
	* @return the book ID of this l m s borrowing
	*/
	@Override
	public long getBookId() {
		return _lmsBorrowing.getBookId();
	}

	/**
	* Sets the book ID of this l m s borrowing.
	*
	* @param bookId the book ID of this l m s borrowing
	*/
	@Override
	public void setBookId(long bookId) {
		_lmsBorrowing.setBookId(bookId);
	}

	/**
	* Returns the member ID of this l m s borrowing.
	*
	* @return the member ID of this l m s borrowing
	*/
	@Override
	public long getMemberId() {
		return _lmsBorrowing.getMemberId();
	}

	/**
	* Sets the member ID of this l m s borrowing.
	*
	* @param memberId the member ID of this l m s borrowing
	*/
	@Override
	public void setMemberId(long memberId) {
		_lmsBorrowing.setMemberId(memberId);
	}

	/**
	* Returns the date borrowed of this l m s borrowing.
	*
	* @return the date borrowed of this l m s borrowing
	*/
	@Override
	public java.util.Date getDateBorrowed() {
		return _lmsBorrowing.getDateBorrowed();
	}

	/**
	* Sets the date borrowed of this l m s borrowing.
	*
	* @param dateBorrowed the date borrowed of this l m s borrowing
	*/
	@Override
	public void setDateBorrowed(java.util.Date dateBorrowed) {
		_lmsBorrowing.setDateBorrowed(dateBorrowed);
	}

	/**
	* Returns the date returned of this l m s borrowing.
	*
	* @return the date returned of this l m s borrowing
	*/
	@Override
	public java.util.Date getDateReturned() {
		return _lmsBorrowing.getDateReturned();
	}

	/**
	* Sets the date returned of this l m s borrowing.
	*
	* @param dateReturned the date returned of this l m s borrowing
	*/
	@Override
	public void setDateReturned(java.util.Date dateReturned) {
		_lmsBorrowing.setDateReturned(dateReturned);
	}

	@Override
	public boolean isNew() {
		return _lmsBorrowing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsBorrowing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsBorrowing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsBorrowing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsBorrowing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsBorrowing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsBorrowing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsBorrowing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsBorrowing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsBorrowing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBorrowing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSBorrowingWrapper((LMSBorrowing)_lmsBorrowing.clone());
	}

	@Override
	public int compareTo(com.slayer.model.LMSBorrowing lmsBorrowing) {
		return _lmsBorrowing.compareTo(lmsBorrowing);
	}

	@Override
	public int hashCode() {
		return _lmsBorrowing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.slayer.model.LMSBorrowing> toCacheModel() {
		return _lmsBorrowing.toCacheModel();
	}

	@Override
	public com.slayer.model.LMSBorrowing toEscapedModel() {
		return new LMSBorrowingWrapper(_lmsBorrowing.toEscapedModel());
	}

	@Override
	public com.slayer.model.LMSBorrowing toUnescapedModel() {
		return new LMSBorrowingWrapper(_lmsBorrowing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsBorrowing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsBorrowing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBorrowing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBorrowingWrapper)) {
			return false;
		}

		LMSBorrowingWrapper lmsBorrowingWrapper = (LMSBorrowingWrapper)obj;

		if (Validator.equals(_lmsBorrowing, lmsBorrowingWrapper._lmsBorrowing)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSBorrowing getWrappedLMSBorrowing() {
		return _lmsBorrowing;
	}

	@Override
	public LMSBorrowing getWrappedModel() {
		return _lmsBorrowing;
	}

	@Override
	public void resetOriginalValues() {
		_lmsBorrowing.resetOriginalValues();
	}

	private LMSBorrowing _lmsBorrowing;
}