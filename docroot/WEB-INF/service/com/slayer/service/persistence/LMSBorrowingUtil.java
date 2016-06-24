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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.slayer.model.LMSBorrowing;

import java.util.List;

/**
 * The persistence utility for the l m s borrowing service. This utility wraps {@link LMSBorrowingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rafael
 * @see LMSBorrowingPersistence
 * @see LMSBorrowingPersistenceImpl
 * @generated
 */
public class LMSBorrowingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LMSBorrowing lmsBorrowing) {
		getPersistence().clearCache(lmsBorrowing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LMSBorrowing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSBorrowing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSBorrowing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSBorrowing update(LMSBorrowing lmsBorrowing)
		throws SystemException {
		return getPersistence().update(lmsBorrowing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSBorrowing update(LMSBorrowing lmsBorrowing,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsBorrowing, serviceContext);
	}

	/**
	* Returns all the l m s borrowings where bookId = &#63;.
	*
	* @param bookId the book ID
	* @return the matching l m s borrowings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.LMSBorrowing> findByBookId(
		long bookId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookId(bookId);
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
	public static java.util.List<com.slayer.model.LMSBorrowing> findByBookId(
		long bookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookId(bookId, start, end);
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
	public static java.util.List<com.slayer.model.LMSBorrowing> findByBookId(
		long bookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookId(bookId, start, end, orderByComparator);
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
	public static com.slayer.model.LMSBorrowing findByBookId_First(
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBorrowingException {
		return getPersistence().findByBookId_First(bookId, orderByComparator);
	}

	/**
	* Returns the first l m s borrowing in the ordered set where bookId = &#63;.
	*
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s borrowing, or <code>null</code> if a matching l m s borrowing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBorrowing fetchByBookId_First(
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBookId_First(bookId, orderByComparator);
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
	public static com.slayer.model.LMSBorrowing findByBookId_Last(long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBorrowingException {
		return getPersistence().findByBookId_Last(bookId, orderByComparator);
	}

	/**
	* Returns the last l m s borrowing in the ordered set where bookId = &#63;.
	*
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s borrowing, or <code>null</code> if a matching l m s borrowing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBorrowing fetchByBookId_Last(
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBookId_Last(bookId, orderByComparator);
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
	public static com.slayer.model.LMSBorrowing[] findByBookId_PrevAndNext(
		long borrowingId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBorrowingException {
		return getPersistence()
				   .findByBookId_PrevAndNext(borrowingId, bookId,
			orderByComparator);
	}

	/**
	* Removes all the l m s borrowings where bookId = &#63; from the database.
	*
	* @param bookId the book ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookId(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBookId(bookId);
	}

	/**
	* Returns the number of l m s borrowings where bookId = &#63;.
	*
	* @param bookId the book ID
	* @return the number of matching l m s borrowings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookId(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBookId(bookId);
	}

	/**
	* Caches the l m s borrowing in the entity cache if it is enabled.
	*
	* @param lmsBorrowing the l m s borrowing
	*/
	public static void cacheResult(com.slayer.model.LMSBorrowing lmsBorrowing) {
		getPersistence().cacheResult(lmsBorrowing);
	}

	/**
	* Caches the l m s borrowings in the entity cache if it is enabled.
	*
	* @param lmsBorrowings the l m s borrowings
	*/
	public static void cacheResult(
		java.util.List<com.slayer.model.LMSBorrowing> lmsBorrowings) {
		getPersistence().cacheResult(lmsBorrowings);
	}

	/**
	* Creates a new l m s borrowing with the primary key. Does not add the l m s borrowing to the database.
	*
	* @param borrowingId the primary key for the new l m s borrowing
	* @return the new l m s borrowing
	*/
	public static com.slayer.model.LMSBorrowing create(long borrowingId) {
		return getPersistence().create(borrowingId);
	}

	/**
	* Removes the l m s borrowing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowingId the primary key of the l m s borrowing
	* @return the l m s borrowing that was removed
	* @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBorrowing remove(long borrowingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBorrowingException {
		return getPersistence().remove(borrowingId);
	}

	public static com.slayer.model.LMSBorrowing updateImpl(
		com.slayer.model.LMSBorrowing lmsBorrowing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsBorrowing);
	}

	/**
	* Returns the l m s borrowing with the primary key or throws a {@link com.slayer.NoSuchLMSBorrowingException} if it could not be found.
	*
	* @param borrowingId the primary key of the l m s borrowing
	* @return the l m s borrowing
	* @throws com.slayer.NoSuchLMSBorrowingException if a l m s borrowing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBorrowing findByPrimaryKey(
		long borrowingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBorrowingException {
		return getPersistence().findByPrimaryKey(borrowingId);
	}

	/**
	* Returns the l m s borrowing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param borrowingId the primary key of the l m s borrowing
	* @return the l m s borrowing, or <code>null</code> if a l m s borrowing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBorrowing fetchByPrimaryKey(
		long borrowingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(borrowingId);
	}

	/**
	* Returns all the l m s borrowings.
	*
	* @return the l m s borrowings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.LMSBorrowing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.slayer.model.LMSBorrowing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.slayer.model.LMSBorrowing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s borrowings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s borrowings.
	*
	* @return the number of l m s borrowings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSBorrowingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSBorrowingPersistence)PortletBeanLocatorUtil.locate(com.slayer.service.ClpSerializer.getServletContextName(),
					LMSBorrowingPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSBorrowingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSBorrowingPersistence persistence) {
	}

	private static LMSBorrowingPersistence _persistence;
}