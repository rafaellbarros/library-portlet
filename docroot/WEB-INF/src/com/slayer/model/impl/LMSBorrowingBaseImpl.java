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

import com.liferay.portal.kernel.exception.SystemException;

import com.slayer.model.LMSBorrowing;

import com.slayer.service.LMSBorrowingLocalServiceUtil;

/**
 * The extended model base implementation for the LMSBorrowing service. Represents a row in the &quot;library_LMSBorrowing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LMSBorrowingImpl}.
 * </p>
 *
 * @author rafael
 * @see LMSBorrowingImpl
 * @see com.slayer.model.LMSBorrowing
 * @generated
 */
public abstract class LMSBorrowingBaseImpl extends LMSBorrowingModelImpl
	implements LMSBorrowing {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l m s borrowing model instance should use the {@link LMSBorrowing} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSBorrowingLocalServiceUtil.addLMSBorrowing(this);
		}
		else {
			LMSBorrowingLocalServiceUtil.updateLMSBorrowing(this);
		}
	}
}