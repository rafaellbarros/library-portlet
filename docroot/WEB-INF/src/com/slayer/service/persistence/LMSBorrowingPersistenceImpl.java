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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.slayer.NoSuchLMSBorrowingException;

import com.slayer.model.LMSBorrowing;
import com.slayer.model.impl.LMSBorrowingImpl;
import com.slayer.model.impl.LMSBorrowingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s borrowing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rafael
 * @see LMSBorrowingPersistence
 * @see LMSBorrowingUtil
 * @generated
 */
public class LMSBorrowingPersistenceImpl extends BasePersistenceImpl<LMSBorrowing>
	implements LMSBorrowingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSBorrowingUtil} to access the l m s borrowing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSBorrowingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, LMSBorrowingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, LMSBorrowingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKID = new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, LMSBorrowingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKID =
		new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, LMSBorrowingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookId",
			new String[] { Long.class.getName() },
			LMSBorrowingModelImpl.BOOKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKID = new FinderPath(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the l m s borrowings where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the matching l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findByBookId(long bookId)
		throws SystemException {
		return findByBookId(bookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s borrowings where bookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookId the book ID
	 * @param start the lower bound of the range of l m s borrowings
	 * @param end the upper bound of the range of l m s borrowings (not inclusive)
	 * @return the range of matching l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findByBookId(long bookId, int start, int end)
		throws SystemException {
		return findByBookId(bookId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s borrowings where bookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookId the book ID
	 * @param start the lower bound of the range of l m s borrowings
	 * @param end the upper bound of the range of l m s borrowings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findByBookId(long bookId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKID;
			finderArgs = new Object[] { bookId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKID;
			finderArgs = new Object[] { bookId, start, end, orderByComparator };
		}

		List<LMSBorrowing> list = (List<LMSBorrowing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSBorrowing lmsBorrowing : list) {
				if ((bookId != lmsBorrowing.getBookId())) {
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

			query.append(_SQL_SELECT_LMSBORROWING_WHERE);

			query.append(_FINDER_COLUMN_BOOKID_BOOKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSBorrowingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookId);

				if (!pagination) {
					list = (List<LMSBorrowing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSBorrowing>(list);
				}
				else {
					list = (List<LMSBorrowing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first l m s borrowing in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s borrowing
	 * @throws com.slayer.NoSuchLMSBorrowingException if a matching l m s borrowing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing findByBookId_First(long bookId,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBorrowingException, SystemException {
		LMSBorrowing lmsBorrowing = fetchByBookId_First(bookId,
				orderByComparator);

		if (lmsBorrowing != null) {
			return lmsBorrowing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookId=");
		msg.append(bookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBorrowingException(msg.toString());
	}

	/**
	 * Returns the first l m s borrowing in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s borrowing, or <code>null</code> if a matching l m s borrowing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing fetchByBookId_First(long bookId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSBorrowing> list = findByBookId(bookId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s borrowing in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s borrowing
	 * @throws com.slayer.NoSuchLMSBorrowingException if a matching l m s borrowing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing findByBookId_Last(long bookId,
		OrderByComparator orderByComparator)
		throws NoSuchLMSBorrowingException, SystemException {
		LMSBorrowing lmsBorrowing = fetchByBookId_Last(bookId, orderByComparator);

		if (lmsBorrowing != null) {
			return lmsBorrowing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookId=");
		msg.append(bookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLMSBorrowingException(msg.toString());
	}

	/**
	 * Returns the last l m s borrowing in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s borrowing, or <code>null</code> if a matching l m s borrowing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing fetchByBookId_Last(long bookId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookId(bookId);

		if (count == 0) {
			return null;
		}

		List<LMSBorrowing> list = findByBookId(bookId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s borrowings before and after the current l m s borrowing in the ordered set where bookId = &#63;.
	 *
	 * @param borrowingId the primary key of the current l m s borrowing
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s borrowing
	 * @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing[] findByBookId_PrevAndNext(long borrowingId,
		long bookId, OrderByComparator orderByComparator)
		throws NoSuchLMSBorrowingException, SystemException {
		LMSBorrowing lmsBorrowing = findByPrimaryKey(borrowingId);

		Session session = null;

		try {
			session = openSession();

			LMSBorrowing[] array = new LMSBorrowingImpl[3];

			array[0] = getByBookId_PrevAndNext(session, lmsBorrowing, bookId,
					orderByComparator, true);

			array[1] = lmsBorrowing;

			array[2] = getByBookId_PrevAndNext(session, lmsBorrowing, bookId,
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

	protected LMSBorrowing getByBookId_PrevAndNext(Session session,
		LMSBorrowing lmsBorrowing, long bookId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSBORROWING_WHERE);

		query.append(_FINDER_COLUMN_BOOKID_BOOKID_2);

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
			query.append(LMSBorrowingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bookId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsBorrowing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSBorrowing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s borrowings where bookId = &#63; from the database.
	 *
	 * @param bookId the book ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBookId(long bookId) throws SystemException {
		for (LMSBorrowing lmsBorrowing : findByBookId(bookId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsBorrowing);
		}
	}

	/**
	 * Returns the number of l m s borrowings where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the number of matching l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBookId(long bookId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKID;

		Object[] finderArgs = new Object[] { bookId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSBORROWING_WHERE);

			query.append(_FINDER_COLUMN_BOOKID_BOOKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookId);

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

	private static final String _FINDER_COLUMN_BOOKID_BOOKID_2 = "lmsBorrowing.bookId = ?";

	public LMSBorrowingPersistenceImpl() {
		setModelClass(LMSBorrowing.class);
	}

	/**
	 * Caches the l m s borrowing in the entity cache if it is enabled.
	 *
	 * @param lmsBorrowing the l m s borrowing
	 */
	@Override
	public void cacheResult(LMSBorrowing lmsBorrowing) {
		EntityCacheUtil.putResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingImpl.class, lmsBorrowing.getPrimaryKey(), lmsBorrowing);

		lmsBorrowing.resetOriginalValues();
	}

	/**
	 * Caches the l m s borrowings in the entity cache if it is enabled.
	 *
	 * @param lmsBorrowings the l m s borrowings
	 */
	@Override
	public void cacheResult(List<LMSBorrowing> lmsBorrowings) {
		for (LMSBorrowing lmsBorrowing : lmsBorrowings) {
			if (EntityCacheUtil.getResult(
						LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
						LMSBorrowingImpl.class, lmsBorrowing.getPrimaryKey()) == null) {
				cacheResult(lmsBorrowing);
			}
			else {
				lmsBorrowing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s borrowings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSBorrowingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSBorrowingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s borrowing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSBorrowing lmsBorrowing) {
		EntityCacheUtil.removeResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingImpl.class, lmsBorrowing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSBorrowing> lmsBorrowings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSBorrowing lmsBorrowing : lmsBorrowings) {
			EntityCacheUtil.removeResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
				LMSBorrowingImpl.class, lmsBorrowing.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s borrowing with the primary key. Does not add the l m s borrowing to the database.
	 *
	 * @param borrowingId the primary key for the new l m s borrowing
	 * @return the new l m s borrowing
	 */
	@Override
	public LMSBorrowing create(long borrowingId) {
		LMSBorrowing lmsBorrowing = new LMSBorrowingImpl();

		lmsBorrowing.setNew(true);
		lmsBorrowing.setPrimaryKey(borrowingId);

		return lmsBorrowing;
	}

	/**
	 * Removes the l m s borrowing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param borrowingId the primary key of the l m s borrowing
	 * @return the l m s borrowing that was removed
	 * @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing remove(long borrowingId)
		throws NoSuchLMSBorrowingException, SystemException {
		return remove((Serializable)borrowingId);
	}

	/**
	 * Removes the l m s borrowing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s borrowing
	 * @return the l m s borrowing that was removed
	 * @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing remove(Serializable primaryKey)
		throws NoSuchLMSBorrowingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSBorrowing lmsBorrowing = (LMSBorrowing)session.get(LMSBorrowingImpl.class,
					primaryKey);

			if (lmsBorrowing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLMSBorrowingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsBorrowing);
		}
		catch (NoSuchLMSBorrowingException nsee) {
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
	protected LMSBorrowing removeImpl(LMSBorrowing lmsBorrowing)
		throws SystemException {
		lmsBorrowing = toUnwrappedModel(lmsBorrowing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsBorrowing)) {
				lmsBorrowing = (LMSBorrowing)session.get(LMSBorrowingImpl.class,
						lmsBorrowing.getPrimaryKeyObj());
			}

			if (lmsBorrowing != null) {
				session.delete(lmsBorrowing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsBorrowing != null) {
			clearCache(lmsBorrowing);
		}

		return lmsBorrowing;
	}

	@Override
	public LMSBorrowing updateImpl(com.slayer.model.LMSBorrowing lmsBorrowing)
		throws SystemException {
		lmsBorrowing = toUnwrappedModel(lmsBorrowing);

		boolean isNew = lmsBorrowing.isNew();

		LMSBorrowingModelImpl lmsBorrowingModelImpl = (LMSBorrowingModelImpl)lmsBorrowing;

		Session session = null;

		try {
			session = openSession();

			if (lmsBorrowing.isNew()) {
				session.save(lmsBorrowing);

				lmsBorrowing.setNew(false);
			}
			else {
				session.merge(lmsBorrowing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSBorrowingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsBorrowingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsBorrowingModelImpl.getOriginalBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKID,
					args);

				args = new Object[] { lmsBorrowingModelImpl.getBookId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKID,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
			LMSBorrowingImpl.class, lmsBorrowing.getPrimaryKey(), lmsBorrowing);

		return lmsBorrowing;
	}

	protected LMSBorrowing toUnwrappedModel(LMSBorrowing lmsBorrowing) {
		if (lmsBorrowing instanceof LMSBorrowingImpl) {
			return lmsBorrowing;
		}

		LMSBorrowingImpl lmsBorrowingImpl = new LMSBorrowingImpl();

		lmsBorrowingImpl.setNew(lmsBorrowing.isNew());
		lmsBorrowingImpl.setPrimaryKey(lmsBorrowing.getPrimaryKey());

		lmsBorrowingImpl.setBorrowingId(lmsBorrowing.getBorrowingId());
		lmsBorrowingImpl.setBookId(lmsBorrowing.getBookId());
		lmsBorrowingImpl.setMemberId(lmsBorrowing.getMemberId());
		lmsBorrowingImpl.setDateBorrowed(lmsBorrowing.getDateBorrowed());
		lmsBorrowingImpl.setDateReturned(lmsBorrowing.getDateReturned());

		return lmsBorrowingImpl;
	}

	/**
	 * Returns the l m s borrowing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s borrowing
	 * @return the l m s borrowing
	 * @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLMSBorrowingException, SystemException {
		LMSBorrowing lmsBorrowing = fetchByPrimaryKey(primaryKey);

		if (lmsBorrowing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLMSBorrowingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsBorrowing;
	}

	/**
	 * Returns the l m s borrowing with the primary key or throws a {@link com.slayer.NoSuchLMSBorrowingException} if it could not be found.
	 *
	 * @param borrowingId the primary key of the l m s borrowing
	 * @return the l m s borrowing
	 * @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing findByPrimaryKey(long borrowingId)
		throws NoSuchLMSBorrowingException, SystemException {
		return findByPrimaryKey((Serializable)borrowingId);
	}

	/**
	 * Returns the l m s borrowing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s borrowing
	 * @return the l m s borrowing, or <code>null</code> if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSBorrowing lmsBorrowing = (LMSBorrowing)EntityCacheUtil.getResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
				LMSBorrowingImpl.class, primaryKey);

		if (lmsBorrowing == _nullLMSBorrowing) {
			return null;
		}

		if (lmsBorrowing == null) {
			Session session = null;

			try {
				session = openSession();

				lmsBorrowing = (LMSBorrowing)session.get(LMSBorrowingImpl.class,
						primaryKey);

				if (lmsBorrowing != null) {
					cacheResult(lmsBorrowing);
				}
				else {
					EntityCacheUtil.putResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
						LMSBorrowingImpl.class, primaryKey, _nullLMSBorrowing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSBorrowingModelImpl.ENTITY_CACHE_ENABLED,
					LMSBorrowingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsBorrowing;
	}

	/**
	 * Returns the l m s borrowing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param borrowingId the primary key of the l m s borrowing
	 * @return the l m s borrowing, or <code>null</code> if a l m s borrowing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBorrowing fetchByPrimaryKey(long borrowingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)borrowingId);
	}

	/**
	 * Returns all the l m s borrowings.
	 *
	 * @return the l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s borrowings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s borrowings
	 * @param end the upper bound of the range of l m s borrowings (not inclusive)
	 * @return the range of l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s borrowings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s borrowings
	 * @param end the upper bound of the range of l m s borrowings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s borrowings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSBorrowing> findAll(int start, int end,
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

		List<LMSBorrowing> list = (List<LMSBorrowing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSBORROWING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSBORROWING;

				if (pagination) {
					sql = sql.concat(LMSBorrowingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSBorrowing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSBorrowing>(list);
				}
				else {
					list = (List<LMSBorrowing>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s borrowings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSBorrowing lmsBorrowing : findAll()) {
			remove(lmsBorrowing);
		}
	}

	/**
	 * Returns the number of l m s borrowings.
	 *
	 * @return the number of l m s borrowings
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

				Query q = session.createQuery(_SQL_COUNT_LMSBORROWING);

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

	/**
	 * Initializes the l m s borrowing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.slayer.model.LMSBorrowing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSBorrowing>> listenersList = new ArrayList<ModelListener<LMSBorrowing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSBorrowing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSBorrowingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSBORROWING = "SELECT lmsBorrowing FROM LMSBorrowing lmsBorrowing";
	private static final String _SQL_SELECT_LMSBORROWING_WHERE = "SELECT lmsBorrowing FROM LMSBorrowing lmsBorrowing WHERE ";
	private static final String _SQL_COUNT_LMSBORROWING = "SELECT COUNT(lmsBorrowing) FROM LMSBorrowing lmsBorrowing";
	private static final String _SQL_COUNT_LMSBORROWING_WHERE = "SELECT COUNT(lmsBorrowing) FROM LMSBorrowing lmsBorrowing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsBorrowing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSBorrowing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSBorrowing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSBorrowingPersistenceImpl.class);
	private static LMSBorrowing _nullLMSBorrowing = new LMSBorrowingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSBorrowing> toCacheModel() {
				return _nullLMSBorrowingCacheModel;
			}
		};

	private static CacheModel<LMSBorrowing> _nullLMSBorrowingCacheModel = new CacheModel<LMSBorrowing>() {
			@Override
			public LMSBorrowing toEntityModel() {
				return _nullLMSBorrowing;
			}
		};
}