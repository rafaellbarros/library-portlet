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

package com.slayer.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.slayer.model.LMSBook;
import com.slayer.model.LMSBookModel;
import com.slayer.model.LMSBookSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LMSBook service. Represents a row in the &quot;library_LMSBook&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.slayer.model.LMSBookModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LMSBookImpl}.
 * </p>
 *
 * @author rafael
 * @see LMSBookImpl
 * @see com.slayer.model.LMSBook
 * @see com.slayer.model.LMSBookModel
 * @generated
 */
@JSON(strict = true)
public class LMSBookModelImpl extends BaseModelImpl<LMSBook>
	implements LMSBookModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l m s book model instance should use the {@link com.slayer.model.LMSBook} interface instead.
	 */
	public static final String TABLE_NAME = "library_LMSBook";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "bookId", Types.BIGINT },
			{ "bookTitle", Types.VARCHAR },
			{ "author", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table library_LMSBook (uuid_ VARCHAR(75) null,bookId LONG not null primary key,bookTitle VARCHAR(75) null,author VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table library_LMSBook";
	public static final String ORDER_BY_JPQL = " ORDER BY lmsBook.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY library_LMSBook.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.slayer.model.LMSBook"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.slayer.model.LMSBook"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.slayer.model.LMSBook"),
			true);
	public static long AUTHOR_COLUMN_BITMASK = 1L;
	public static long BOOKTITLE_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LMSBook toModel(LMSBookSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LMSBook model = new LMSBookImpl();

		model.setUuid(soapModel.getUuid());
		model.setBookId(soapModel.getBookId());
		model.setBookTitle(soapModel.getBookTitle());
		model.setAuthor(soapModel.getAuthor());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LMSBook> toModels(LMSBookSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LMSBook> models = new ArrayList<LMSBook>(soapModels.length);

		for (LMSBookSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.slayer.model.LMSBook"));

	public LMSBookModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("uuid", getUuid());
		attributes.put("bookId", getBookId());
		attributes.put("bookTitle", getBookTitle());
		attributes.put("author", getAuthor());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	@JSON
	@Override
	public String getBookTitle() {
		if (_bookTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookTitle;
		}
	}

	@Override
	public void setBookTitle(String bookTitle) {
		_columnBitmask |= BOOKTITLE_COLUMN_BITMASK;

		if (_originalBookTitle == null) {
			_originalBookTitle = _bookTitle;
		}

		_bookTitle = bookTitle;
	}

	public String getOriginalBookTitle() {
		return GetterUtil.getString(_originalBookTitle);
	}

	@JSON
	@Override
	public String getAuthor() {
		if (_author == null) {
			return StringPool.BLANK;
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_columnBitmask |= AUTHOR_COLUMN_BITMASK;

		if (_originalAuthor == null) {
			_originalAuthor = _author;
		}

		_author = author;
	}

	public String getOriginalAuthor() {
		return GetterUtil.getString(_originalAuthor);
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LMSBook.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LMSBook toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LMSBook)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		lmsBookImpl.setUuid(getUuid());
		lmsBookImpl.setBookId(getBookId());
		lmsBookImpl.setBookTitle(getBookTitle());
		lmsBookImpl.setAuthor(getAuthor());
		lmsBookImpl.setCreateDate(getCreateDate());
		lmsBookImpl.setModifiedDate(getModifiedDate());

		lmsBookImpl.resetOriginalValues();

		return lmsBookImpl;
	}

	@Override
	public int compareTo(LMSBook lmsBook) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), lmsBook.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBook)) {
			return false;
		}

		LMSBook lmsBook = (LMSBook)obj;

		long primaryKey = lmsBook.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LMSBookModelImpl lmsBookModelImpl = this;

		lmsBookModelImpl._originalUuid = lmsBookModelImpl._uuid;

		lmsBookModelImpl._originalBookTitle = lmsBookModelImpl._bookTitle;

		lmsBookModelImpl._originalAuthor = lmsBookModelImpl._author;

		lmsBookModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LMSBook> toCacheModel() {
		LMSBookCacheModel lmsBookCacheModel = new LMSBookCacheModel();

		lmsBookCacheModel.uuid = getUuid();

		String uuid = lmsBookCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			lmsBookCacheModel.uuid = null;
		}

		lmsBookCacheModel.bookId = getBookId();

		lmsBookCacheModel.bookTitle = getBookTitle();

		String bookTitle = lmsBookCacheModel.bookTitle;

		if ((bookTitle != null) && (bookTitle.length() == 0)) {
			lmsBookCacheModel.bookTitle = null;
		}

		lmsBookCacheModel.author = getAuthor();

		String author = lmsBookCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			lmsBookCacheModel.author = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			lmsBookCacheModel.createDate = createDate.getTime();
		}
		else {
			lmsBookCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			lmsBookCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			lmsBookCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return lmsBookCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", bookTitle=");
		sb.append(getBookTitle());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.LMSBook");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookTitle</column-name><column-value><![CDATA[");
		sb.append(getBookTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LMSBook.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LMSBook.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _bookId;
	private String _bookTitle;
	private String _originalBookTitle;
	private String _author;
	private String _originalAuthor;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private LMSBook _escapedModel;
}