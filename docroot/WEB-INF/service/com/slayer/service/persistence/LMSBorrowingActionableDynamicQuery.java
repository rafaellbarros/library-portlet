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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.slayer.model.LMSBorrowing;

import com.slayer.service.LMSBorrowingLocalServiceUtil;

/**
 * @author rafael
 * @generated
 */
public abstract class LMSBorrowingActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LMSBorrowingActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LMSBorrowingLocalServiceUtil.getService());
		setClass(LMSBorrowing.class);

		setClassLoader(com.slayer.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("borrowingId");
	}
}