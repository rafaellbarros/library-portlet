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

package com.slayer.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.slayer.NoSuchLMSBookException;

import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.model.impl.LMSBookModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l m s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rafael
 * @see LMSBookPersistence
 * @see LMSBookUtil
 * @generated
 */
public class LMSBookPersistenceImpl extends BasePersistenceImpl<LMSBook>
	implements LMSBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSBookUtil} to access the l m s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LMSBookModelImpl.UUID_COLUMN_BITMASK |
			LMSBookModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSBook lmsBook : list) {
				if (!Validator.equals(uuid, lmsBook.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSBookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSBook>(list);
				}
				else {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first l m s book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByUuid_First(uuid, orderByComparator);

		if (lmsBook != null) {
			return lmsBook;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBookException(msg.toString());
	}

	/**
	 * Returns the first l m s book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSBook> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByUuid_Last(uuid, orderByComparator);

		if (lmsBook != null) {
			return lmsBook;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBookException(msg.toString());
	}

	/**
	 * Returns the last l m s book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LMSBook> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s books before and after the current l m s book in the ordered set where uuid = &#63;.
	 *
	 * @param bookId the primary key of the current l m s book
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook[] findByUuid_PrevAndNext(long bookId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			LMSBook[] array = new LMSBookImpl[3];

			array[0] = getByUuid_PrevAndNext(session, lmsBook, uuid,
					orderByComparator, true);

			array[1] = lmsBook;

			array[2] = getByUuid_PrevAndNext(session, lmsBook, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSBook getByUuid_PrevAndNext(Session session, LMSBook lmsBook,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSBOOK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LMSBookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsBook);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSBook> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (LMSBook lmsBook : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lmsBook);
		}
	}

	/**
	 * Returns the number of l m s books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "lmsBook.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "lmsBook.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(lmsBook.uuid IS NULL OR lmsBook.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKTITLE =
		new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKTITLE =
		new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookTitle",
			new String[] { String.class.getName() },
			LMSBookModelImpl.BOOKTITLE_COLUMN_BITMASK |
			LMSBookModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKTITLE = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s books where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @return the matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByBookTitle(String bookTitle)
		throws SystemException {
		return findByBookTitle(bookTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the l m s books where bookTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookTitle the book title
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByBookTitle(String bookTitle, int start, int end)
		throws SystemException {
		return findByBookTitle(bookTitle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books where bookTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookTitle the book title
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findByBookTitle(String bookTitle, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKTITLE;
			finderArgs = new Object[] { bookTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKTITLE;
			finderArgs = new Object[] { bookTitle, start, end, orderByComparator };
		}

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSBook lmsBook : list) {
				if (!Validator.equals(bookTitle, lmsBook.getBookTitle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSBookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				if (!pagination) {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSBook>(list);
				}
				else {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first l m s book in the ordered set where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByBookTitle_First(String bookTitle,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByBookTitle_First(bookTitle, orderByComparator);

		if (lmsBook != null) {
			return lmsBook;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookTitle=");
		msg.append(bookTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBookException(msg.toString());
	}

	/**
	 * Returns the first l m s book in the ordered set where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByBookTitle_First(String bookTitle,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSBook> list = findByBookTitle(bookTitle, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s book in the ordered set where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByBookTitle_Last(String bookTitle,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByBookTitle_Last(bookTitle, orderByComparator);

		if (lmsBook != null) {
			return lmsBook;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookTitle=");
		msg.append(bookTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBookException(msg.toString());
	}

	/**
	 * Returns the last l m s book in the ordered set where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByBookTitle_Last(String bookTitle,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookTitle(bookTitle);

		if (count == 0) {
			return null;
		}

		List<LMSBook> list = findByBookTitle(bookTitle, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s books before and after the current l m s book in the ordered set where bookTitle = &#63;.
	 *
	 * @param bookId the primary key of the current l m s book
	 * @param bookTitle the book title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook[] findByBookTitle_PrevAndNext(long bookId, String bookTitle,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			LMSBook[] array = new LMSBookImpl[3];

			array[0] = getByBookTitle_PrevAndNext(session, lmsBook, bookTitle,
					orderByComparator, true);

			array[1] = lmsBook;

			array[2] = getByBookTitle_PrevAndNext(session, lmsBook, bookTitle,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSBook getByBookTitle_PrevAndNext(Session session,
		LMSBook lmsBook, String bookTitle, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSBOOK_WHERE);

		boolean bindBookTitle = false;

		if (bookTitle == null) {
			query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1);
		}
		else if (bookTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3);
		}
		else {
			bindBookTitle = true;

			query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LMSBookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBookTitle) {
			qPos.add(bookTitle);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsBook);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSBook> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s books where bookTitle = &#63; from the database.
	 *
	 * @param bookTitle the book title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBookTitle(String bookTitle) throws SystemException {
		for (LMSBook lmsBook : findByBookTitle(bookTitle, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lmsBook);
		}
	}

	/**
	 * Returns the number of l m s books where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBookTitle(String bookTitle) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKTITLE;

		Object[] finderArgs = new Object[] { bookTitle };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1 = "lmsBook.bookTitle IS NULL";
	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2 = "lmsBook.bookTitle = ?";
	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3 = "(lmsBook.bookTitle IS NULL OR lmsBook.bookTitle = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBookTitle_Author",
			new String[] { String.class.getName(), String.class.getName() },
			LMSBookModelImpl.BOOKTITLE_COLUMN_BITMASK |
			LMSBookModelImpl.AUTHOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBookTitle_Author",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the l m s book where bookTitle = &#63; and author = &#63; or throws a {@link com.slayer.NoSuchLMSBookException} if it could not be found.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the matching l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByBookTitle_Author(String bookTitle, String author)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByBookTitle_Author(bookTitle, author);

		if (lmsBook == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookTitle=");
			msg.append(bookTitle);

			msg.append(", author=");
			msg.append(author);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLMSBookException(msg.toString());
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByBookTitle_Author(String bookTitle, String author)
		throws SystemException {
		return fetchByBookTitle_Author(bookTitle, author, true);
	}

	/**
	 * Returns the l m s book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByBookTitle_Author(String bookTitle, String author,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { bookTitle, author };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
					finderArgs, this);
		}

		if (result instanceof LMSBook) {
			LMSBook lmsBook = (LMSBook)result;

			if (!Validator.equals(bookTitle, lmsBook.getBookTitle()) ||
					!Validator.equals(author, lmsBook.getAuthor())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_2);
			}

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				if (bindAuthor) {
					qPos.add(author);
				}

				List<LMSBook> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSBookPersistenceImpl.fetchByBookTitle_Author(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSBook lmsBook = list.get(0);

					result = lmsBook;

					cacheResult(lmsBook);

					if ((lmsBook.getBookTitle() == null) ||
							!lmsBook.getBookTitle().equals(bookTitle) ||
							(lmsBook.getAuthor() == null) ||
							!lmsBook.getAuthor().equals(author)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
							finderArgs, lmsBook);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LMSBook)result;
		}
	}

	/**
	 * Removes the l m s book where bookTitle = &#63; and author = &#63; from the database.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the l m s book that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook removeByBookTitle_Author(String bookTitle, String author)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = findByBookTitle_Author(bookTitle, author);

		return remove(lmsBook);
	}

	/**
	 * Returns the number of l m s books where bookTitle = &#63; and author = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBookTitle_Author(String bookTitle, String author)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR;

		Object[] finderArgs = new Object[] { bookTitle, author };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_2);
			}

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				if (bindAuthor) {
					qPos.add(author);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_1 = "lmsBook.bookTitle IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_2 = "lmsBook.bookTitle = ? AND ";
	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_BOOKTITLE_3 = "(lmsBook.bookTitle IS NULL OR lmsBook.bookTitle = '') AND ";
	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_1 = "lmsBook.author IS NULL";
	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_2 = "lmsBook.author = ?";
	private static final String _FINDER_COLUMN_BOOKTITLE_AUTHOR_AUTHOR_3 = "(lmsBook.author IS NULL OR lmsBook.author = '')";

	public LMSBookPersistenceImpl() {
		setModelClass(LMSBook.class);
	}

	/**
	 * Caches the l m s book in the entity cache if it is enabled.
	 *
	 * @param lmsBook the l m s book
	 */
	@Override
	public void cacheResult(LMSBook lmsBook) {
		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
			new Object[] { lmsBook.getBookTitle(), lmsBook.getAuthor() },
			lmsBook);

		lmsBook.resetOriginalValues();
	}

	/**
	 * Caches the l m s books in the entity cache if it is enabled.
	 *
	 * @param lmsBooks the l m s books
	 */
	@Override
	public void cacheResult(List<LMSBook> lmsBooks) {
		for (LMSBook lmsBook : lmsBooks) {
			if (EntityCacheUtil.getResult(
						LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, lmsBook.getPrimaryKey()) == null) {
				cacheResult(lmsBook);
			}
			else {
				lmsBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSBook lmsBook) {
		EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsBook);
	}

	@Override
	public void clearCache(List<LMSBook> lmsBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSBook lmsBook : lmsBooks) {
			EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, lmsBook.getPrimaryKey());

			clearUniqueFindersCache(lmsBook);
		}
	}

	protected void cacheUniqueFindersCache(LMSBook lmsBook) {
		if (lmsBook.isNew()) {
			Object[] args = new Object[] {
					lmsBook.getBookTitle(), lmsBook.getAuthor()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
				args, lmsBook);
		}
		else {
			LMSBookModelImpl lmsBookModelImpl = (LMSBookModelImpl)lmsBook;

			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsBook.getBookTitle(), lmsBook.getAuthor()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
					args, lmsBook);
			}
		}
	}

	protected void clearUniqueFindersCache(LMSBook lmsBook) {
		LMSBookModelImpl lmsBookModelImpl = (LMSBookModelImpl)lmsBook;

		Object[] args = new Object[] { lmsBook.getBookTitle(), lmsBook.getAuthor() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR, args);

		if ((lmsBookModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsBookModelImpl.getOriginalBookTitle(),
					lmsBookModelImpl.getOriginalAuthor()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE_AUTHOR,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE_AUTHOR,
				args);
		}
	}

	/**
	 * Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	 *
	 * @param bookId the primary key for the new l m s book
	 * @return the new l m s book
	 */
	@Override
	public LMSBook create(long bookId) {
		LMSBook lmsBook = new LMSBookImpl();

		lmsBook.setNew(true);
		lmsBook.setPrimaryKey(bookId);

		String uuid = PortalUUIDUtil.generate();

		lmsBook.setUuid(uuid);

		return lmsBook;
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook remove(long bookId)
		throws NoSuchLMSBookException, SystemException {
		return remove((Serializable)bookId);
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook remove(Serializable primaryKey)
		throws NoSuchLMSBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSBook lmsBook = (LMSBook)session.get(LMSBookImpl.class, primaryKey);

			if (lmsBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLMSBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsBook);
		}
		catch (NoSuchLMSBookException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LMSBook removeImpl(LMSBook lmsBook) throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsBook)) {
				lmsBook = (LMSBook)session.get(LMSBookImpl.class,
						lmsBook.getPrimaryKeyObj());
			}

			if (lmsBook != null) {
				session.delete(lmsBook);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsBook != null) {
			clearCache(lmsBook);
		}

		return lmsBook;
	}

	@Override
	public LMSBook updateImpl(com.slayer.model.LMSBook lmsBook)
		throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		boolean isNew = lmsBook.isNew();

		LMSBookModelImpl lmsBookModelImpl = (LMSBookModelImpl)lmsBook;

		if (Validator.isNull(lmsBook.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			lmsBook.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (lmsBook.isNew()) {
				session.save(lmsBook);

				lmsBook.setNew(false);
			}
			else {
				session.merge(lmsBook);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSBookModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsBookModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { lmsBookModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsBookModelImpl.getOriginalBookTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKTITLE,
					args);

				args = new Object[] { lmsBookModelImpl.getBookTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKTITLE,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		clearUniqueFindersCache(lmsBook);
		cacheUniqueFindersCache(lmsBook);

		return lmsBook;
	}

	protected LMSBook toUnwrappedModel(LMSBook lmsBook) {
		if (lmsBook instanceof LMSBookImpl) {
			return lmsBook;
		}

		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		lmsBookImpl.setNew(lmsBook.isNew());
		lmsBookImpl.setPrimaryKey(lmsBook.getPrimaryKey());

		lmsBookImpl.setUuid(lmsBook.getUuid());
		lmsBookImpl.setBookId(lmsBook.getBookId());
		lmsBookImpl.setBookTitle(lmsBook.getBookTitle());
		lmsBookImpl.setAuthor(lmsBook.getAuthor());
		lmsBookImpl.setCreateDate(lmsBook.getCreateDate());
		lmsBookImpl.setModifiedDate(lmsBook.getModifiedDate());

		return lmsBookImpl;
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLMSBookException, SystemException {
		LMSBook lmsBook = fetchByPrimaryKey(primaryKey);

		if (lmsBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLMSBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.slayer.NoSuchLMSBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByPrimaryKey(long bookId)
		throws NoSuchLMSBookException, SystemException {
		return findByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSBook lmsBook = (LMSBook)EntityCacheUtil.getResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, primaryKey);

		if (lmsBook == _nullLMSBook) {
			return null;
		}

		if (lmsBook == null) {
			Session session = null;

			try {
				session = openSession();

				lmsBook = (LMSBook)session.get(LMSBookImpl.class, primaryKey);

				if (lmsBook != null) {
					cacheResult(lmsBook);
				}
				else {
					EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, primaryKey, _nullLMSBook);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
					LMSBookImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByPrimaryKey(long bookId) throws SystemException {
		return fetchByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns all the l m s books.
	 *
	 * @return the l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBook> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSBOOK;

				if (pagination) {
					sql = sql.concat(LMSBookModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSBook>(list);
				}
				else {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the l m s books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSBook lmsBook : findAll()) {
			remove(lmsBook);
		}
	}

	/**
	 * Returns the number of l m s books.
	 *
	 * @return the number of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LMSBOOK);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the l m s book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.slayer.model.LMSBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSBook>> listenersList = new ArrayList<ModelListener<LMSBook>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSBook>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LMSBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSBOOK = "SELECT lmsBook FROM LMSBook lmsBook";
	private static final String _SQL_SELECT_LMSBOOK_WHERE = "SELECT lmsBook FROM LMSBook lmsBook WHERE ";
	private static final String _SQL_COUNT_LMSBOOK = "SELECT COUNT(lmsBook) FROM LMSBook lmsBook";
	private static final String _SQL_COUNT_LMSBOOK_WHERE = "SELECT COUNT(lmsBook) FROM LMSBook lmsBook WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSBook exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSBook exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSBookPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static LMSBook _nullLMSBook = new LMSBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSBook> toCacheModel() {
				return _nullLMSBookCacheModel;
			}
		};

	private static CacheModel<LMSBook> _nullLMSBookCacheModel = new CacheModel<LMSBook>() {
			@Override
			public LMSBook toEntityModel() {
				return _nullLMSBook;
			}
		};
}