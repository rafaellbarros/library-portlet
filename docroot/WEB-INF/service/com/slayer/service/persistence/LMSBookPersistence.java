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

import com.liferay.portal.service.persistence.BasePersistence;

import com.slayer.model.LMSBook;

/**
 * The persistence interface for the l m s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rafael
 * @see LMSBookPersistenceImpl
 * @see LMSBookUtil
 * @generated
 */
public interface LMSBookPersistence extends BasePersistence<LMSBook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSBookUtil} to access the l m s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l m s books where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @return the matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.LMSBook> findByBookTitle(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.LMSBook> findByBookTitle(
		java.lang.String bookTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.LMSBook> findByBookTitle(
		java.lang.String bookTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s book in the ordered set where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s book
	* @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook findByBookTitle_First(
		java.lang.String bookTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Returns the first l m s book in the ordered set where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook fetchByBookTitle_First(
		java.lang.String bookTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s book in the ordered set where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s book
	* @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook findByBookTitle_Last(
		java.lang.String bookTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Returns the last l m s book in the ordered set where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook fetchByBookTitle_Last(
		java.lang.String bookTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.slayer.model.LMSBook[] findByBookTitle_PrevAndNext(long bookId,
		java.lang.String bookTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Removes all the l m s books where bookTitle = &#63; from the database.
	*
	* @param bookTitle the book title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBookTitle(java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @return the number of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countByBookTitle(java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where bookTitle = &#63; and author = &#63; or throws a {@link com.slayer.NoSuchLMSBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching l m s book
	* @throws com.slayer.NoSuchLMSBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook findByBookTitle_Author(
		java.lang.String bookTitle, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Returns the l m s book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook fetchByBookTitle_Author(
		java.lang.String bookTitle, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook fetchByBookTitle_Author(
		java.lang.String bookTitle, java.lang.String author,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s book where bookTitle = &#63; and author = &#63; from the database.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the l m s book that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook removeByBookTitle_Author(
		java.lang.String bookTitle, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Returns the number of l m s books where bookTitle = &#63; and author = &#63;.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the number of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countByBookTitle_Author(java.lang.String bookTitle,
		java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s book in the entity cache if it is enabled.
	*
	* @param lmsBook the l m s book
	*/
	public void cacheResult(com.slayer.model.LMSBook lmsBook);

	/**
	* Caches the l m s books in the entity cache if it is enabled.
	*
	* @param lmsBooks the l m s books
	*/
	public void cacheResult(java.util.List<com.slayer.model.LMSBook> lmsBooks);

	/**
	* Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	*
	* @param bookId the primary key for the new l m s book
	* @return the new l m s book
	*/
	public com.slayer.model.LMSBook create(long bookId);

	/**
	* Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book that was removed
	* @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook remove(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	public com.slayer.model.LMSBook updateImpl(com.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book with the primary key or throws a {@link com.slayer.NoSuchLMSBookException} if it could not be found.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book
	* @throws com.slayer.NoSuchLMSBookException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook findByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchLMSBookException;

	/**
	* Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.LMSBook fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s books.
	*
	* @return the l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.LMSBook> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.LMSBook> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.LMSBook> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s books from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books.
	*
	* @return the number of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}