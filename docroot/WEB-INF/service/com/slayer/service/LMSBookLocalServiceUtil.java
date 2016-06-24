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

package com.slayer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LMSBook. This utility wraps
 * {@link com.slayer.service.impl.LMSBookLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rafael
 * @see LMSBookLocalService
 * @see com.slayer.service.base.LMSBookLocalServiceBaseImpl
 * @see com.slayer.service.impl.LMSBookLocalServiceImpl
 * @generated
 */
public class LMSBookLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.slayer.service.impl.LMSBookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l m s book to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBook addLMSBook(
		com.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLMSBook(lmsBook);
	}

	/**
	* Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	*
	* @param bookId the primary key for the new l m s book
	* @return the new l m s book
	*/
	public static com.slayer.model.LMSBook createLMSBook(long bookId) {
		return getService().createLMSBook(bookId);
	}

	/**
	* Deletes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book that was removed
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBook deleteLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSBook(bookId);
	}

	/**
	* Deletes the l m s book from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBook deleteLMSBook(
		com.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSBook(lmsBook);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.slayer.model.LMSBook fetchLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLMSBook(bookId);
	}

	/**
	* Returns the l m s book with the primary key.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBook getLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBook(bookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.slayer.model.LMSBook> getLMSBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBooks(start, end);
	}

	/**
	* Returns the number of l m s books.
	*
	* @return the number of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public static int getLMSBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBooksCount();
	}

	/**
	* Updates the l m s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.LMSBook updateLMSBook(
		com.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSBook(lmsBook);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.slayer.model.LMSBook insertBook(
		java.lang.String bookTitle, java.lang.String author) {
		return getService().insertBook(bookTitle, author);
	}

	public static com.slayer.model.LMSBook modifyBook(long bookId,
		java.lang.String bookTitle, java.lang.String author) {
		return getService().modifyBook(bookId, bookTitle, author);
	}

	public static java.util.List<com.slayer.model.LMSBook> searchBooks(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchBooks(bookTitle);
	}

	public static java.util.List<com.slayer.model.LMSBook> searchBooks(
		java.lang.String bookTitle, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchBooks(bookTitle, companyId, groupId);
	}

	public static java.util.List<com.slayer.model.LMSBorrowing> getBorrowings(
		long bookId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBorrowings(bookId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LMSBookLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LMSBookLocalService.class.getName());

			if (invokableLocalService instanceof LMSBookLocalService) {
				_service = (LMSBookLocalService)invokableLocalService;
			}
			else {
				_service = new LMSBookLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LMSBookLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LMSBookLocalService service) {
	}

	private static LMSBookLocalService _service;
}