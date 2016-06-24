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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.slayer.service.ClpSerializer;
import com.slayer.service.LMSBorrowingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rafael
 */
public class LMSBorrowingClp extends BaseModelImpl<LMSBorrowing>
	implements LMSBorrowing {
	public LMSBorrowingClp() {
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
	public long getPrimaryKey() {
		return _borrowingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBorrowingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _borrowingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getBorrowingId() {
		return _borrowingId;
	}

	@Override
	public void setBorrowingId(long borrowingId) {
		_borrowingId = borrowingId;

		if (_lmsBorrowingRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBorrowingRemoteModel.getClass();

				Method method = clazz.getMethod("setBorrowingId", long.class);

				method.invoke(_lmsBorrowingRemoteModel, borrowingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_bookId = bookId;

		if (_lmsBorrowingRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBorrowingRemoteModel.getClass();

				Method method = clazz.getMethod("setBookId", long.class);

				method.invoke(_lmsBorrowingRemoteModel, bookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(long memberId) {
		_memberId = memberId;

		if (_lmsBorrowingRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBorrowingRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberId", long.class);

				method.invoke(_lmsBorrowingRemoteModel, memberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateBorrowed() {
		return _dateBorrowed;
	}

	@Override
	public void setDateBorrowed(Date dateBorrowed) {
		_dateBorrowed = dateBorrowed;

		if (_lmsBorrowingRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBorrowingRemoteModel.getClass();

				Method method = clazz.getMethod("setDateBorrowed", Date.class);

				method.invoke(_lmsBorrowingRemoteModel, dateBorrowed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateReturned() {
		return _dateReturned;
	}

	@Override
	public void setDateReturned(Date dateReturned) {
		_dateReturned = dateReturned;

		if (_lmsBorrowingRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBorrowingRemoteModel.getClass();

				Method method = clazz.getMethod("setDateReturned", Date.class);

				method.invoke(_lmsBorrowingRemoteModel, dateReturned);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSBorrowingRemoteModel() {
		return _lmsBorrowingRemoteModel;
	}

	public void setLMSBorrowingRemoteModel(BaseModel<?> lmsBorrowingRemoteModel) {
		_lmsBorrowingRemoteModel = lmsBorrowingRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _lmsBorrowingRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_lmsBorrowingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSBorrowingLocalServiceUtil.addLMSBorrowing(this);
		}
		else {
			LMSBorrowingLocalServiceUtil.updateLMSBorrowing(this);
		}
	}

	@Override
	public LMSBorrowing toEscapedModel() {
		return (LMSBorrowing)ProxyUtil.newProxyInstance(LMSBorrowing.class.getClassLoader(),
			new Class[] { LMSBorrowing.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSBorrowingClp clone = new LMSBorrowingClp();

		clone.setBorrowingId(getBorrowingId());
		clone.setBookId(getBookId());
		clone.setMemberId(getMemberId());
		clone.setDateBorrowed(getDateBorrowed());
		clone.setDateReturned(getDateReturned());

		return clone;
	}

	@Override
	public int compareTo(LMSBorrowing lmsBorrowing) {
		long primaryKey = lmsBorrowing.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBorrowingClp)) {
			return false;
		}

		LMSBorrowingClp lmsBorrowing = (LMSBorrowingClp)obj;

		long primaryKey = lmsBorrowing.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{borrowingId=");
		sb.append(getBorrowingId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", dateBorrowed=");
		sb.append(getDateBorrowed());
		sb.append(", dateReturned=");
		sb.append(getDateReturned());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.LMSBorrowing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>borrowingId</column-name><column-value><![CDATA[");
		sb.append(getBorrowingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberId</column-name><column-value><![CDATA[");
		sb.append(getMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateBorrowed</column-name><column-value><![CDATA[");
		sb.append(getDateBorrowed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateReturned</column-name><column-value><![CDATA[");
		sb.append(getDateReturned());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _borrowingId;
	private long _bookId;
	private long _memberId;
	private Date _dateBorrowed;
	private Date _dateReturned;
	private BaseModel<?> _lmsBorrowingRemoteModel;
	private Class<?> _clpSerializerClass = com.slayer.service.ClpSerializer.class;
}