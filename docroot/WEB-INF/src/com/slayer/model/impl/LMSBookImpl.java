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
import com.slayer.service.LMSBookLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the LMSBook service. Represents a row in the
 * &quot;library_LMSBook&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the {@link com.slayer.model.LMSBook}
 * interface.
 * </p>
 *
 * @author rafael
 */
public class LMSBookImpl extends LMSBookBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a l m s book model instance
	 * should use the {@link com.slayer.model.LMSBook} interface instead.
	 */
	public LMSBookImpl() {
	}

	public List<LMSBorrowing> getLMSBorrowings() throws SystemException {
		return LMSBookLocalServiceUtil.getBorrowings(getBookId());
	}
}