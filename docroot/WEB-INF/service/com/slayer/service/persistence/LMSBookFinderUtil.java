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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author rafael
 */
public class LMSBookFinderUtil {
	public static java.util.List<com.slayer.model.LMSBook> findBooks(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBooks(bookTitle);
	}

	public static LMSBookFinder getFinder() {
		if (_finder == null) {
			_finder = (LMSBookFinder)PortletBeanLocatorUtil.locate(com.slayer.service.ClpSerializer.getServletContextName(),
					LMSBookFinder.class.getName());

			ReferenceRegistry.registerReference(LMSBookFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LMSBookFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LMSBookFinderUtil.class, "_finder");
	}

	private static LMSBookFinder _finder;
}