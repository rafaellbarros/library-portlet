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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LMSBorrowingLocalService}.
 *
 * @author rafael
 * @see LMSBorrowingLocalService
 * @generated
 */
public class LMSBorrowingLocalServiceWrapper implements LMSBorrowingLocalService,
	ServiceWrapper<LMSBorrowingLocalService> {
	public LMSBorrowingLocalServiceWrapper(
		LMSBorrowingLocalService lmsBorrowingLocalService) {
		_lmsBorrowingLocalService = lmsBorrowingLocalService;
	}

	/**
	* Adds the l m s borrowing to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBorrowing the l m s borrowing
	* @return the l m s borrowing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.slayer.model.LMSBorrowing addLMSBorrowing(
		com.slayer.model.LMSBorrowing lmsBorrowing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.addLMSBorrowing(lmsBorrowing);
	}

	/**
	* Creates a new l m s borrowing with the primary key. Does not add the l m s borrowing to the database.
	*
	* @param borrowingId the primary key for the new l m s borrowing
	* @return the new l m s borrowing
	*/
	@Override
	public com.slayer.model.LMSBorrowing createLMSBorrowing(long borrowingId) {
		return _lmsBorrowingLocalService.createLMSBorrowing(borrowingId);
	}

	/**
	* Deletes the l m s borrowing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowingId the primary key of the l m s borrowing
	* @return the l m s borrowing that was removed
	* @throws PortalException if a l m s borrowing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.slayer.model.LMSBorrowing deleteLMSBorrowing(long borrowingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.deleteLMSBorrowing(borrowingId);
	}

	/**
	* Deletes the l m s borrowing from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBorrowing the l m s borrowing
	* @return the l m s borrowing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.slayer.model.LMSBorrowing deleteLMSBorrowing(
		com.slayer.model.LMSBorrowing lmsBorrowing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.deleteLMSBorrowing(lmsBorrowing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lmsBorrowingLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.slayer.model.impl.LMSBorrowingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.slayer.model.LMSBorrowing fetchLMSBorrowing(long borrowingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.fetchLMSBorrowing(borrowingId);
	}

	/**
	* Returns the l m s borrowing with the primary key.
	*
	* @param borrowingId the primary key of the l m s borrowing
	* @return the l m s borrowing
	* @throws PortalException if a l m s borrowing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.slayer.model.LMSBorrowing getLMSBorrowing(long borrowingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.getLMSBorrowing(borrowingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.slayer.model.LMSBorrowing> getLMSBorrowings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.getLMSBorrowings(start, end);
	}

	/**
	* Returns the number of l m s borrowings.
	*
	* @return the number of l m s borrowings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLMSBorrowingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.getLMSBorrowingsCount();
	}

	/**
	* Updates the l m s borrowing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBorrowing the l m s borrowing
	* @return the l m s borrowing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.slayer.model.LMSBorrowing updateLMSBorrowing(
		com.slayer.model.LMSBorrowing lmsBorrowing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBorrowingLocalService.updateLMSBorrowing(lmsBorrowing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsBorrowingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsBorrowingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsBorrowingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSBorrowingLocalService getWrappedLMSBorrowingLocalService() {
		return _lmsBorrowingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSBorrowingLocalService(
		LMSBorrowingLocalService lmsBorrowingLocalService) {
		_lmsBorrowingLocalService = lmsBorrowingLocalService;
	}

	@Override
	public LMSBorrowingLocalService getWrappedService() {
		return _lmsBorrowingLocalService;
	}

	@Override
	public void setWrappedService(
		LMSBorrowingLocalService lmsBorrowingLocalService) {
		_lmsBorrowingLocalService = lmsBorrowingLocalService;
	}

	private LMSBorrowingLocalService _lmsBorrowingLocalService;
}