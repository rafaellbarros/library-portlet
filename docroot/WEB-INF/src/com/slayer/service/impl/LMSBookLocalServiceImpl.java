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

package com.slayer.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.slayer.model.LMSBook;
import com.slayer.model.LMSBorrowing;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.service.LMSBookLocalServiceUtil;
import com.slayer.service.base.LMSBookLocalServiceBaseImpl;
import com.slayer.service.persistence.LMSBookFinderUtil;
import com.slayer.service.persistence.LMSBorrowingUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the l m s book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the {@link com.slayer.service.LMSBookLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rafael
 * @see com.slayer.service.base.LMSBookLocalServiceBaseImpl
 * @see com.slayer.service.LMSBookLocalServiceUtil
 */
public class LMSBookLocalServiceImpl extends LMSBookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.slayer.service.LMSBookLocalServiceUtil} to access the l m s book local service.
	 */

	public LMSBook insertBook(String bookTitle, String author) {
		// 1. Instanciar um objeto vazio do tipo LMSBookImpl
		LMSBook lmsBook = new LMSBookImpl();

		// 2. Defina os campos para este objeto

		lmsBook.setBookTitle(bookTitle);
		lmsBook.setAuthor(author);
		lmsBook.setCreateDate(new Date());

		try {
			lmsBook = LMSBookLocalServiceUtil.addLMSBook(lmsBook);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return lmsBook;
	}

	public LMSBook modifyBook(long bookId, String bookTitle, String author) {
		LMSBook lmsBook = null;
		try {
			lmsBook = LMSBookLocalServiceUtil.fetchLMSBook(bookId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if (Validator.isNotNull(lmsBook)) {
			lmsBook.setBookTitle(bookTitle);
			lmsBook.setAuthor(author);
			lmsBook.setModifiedDate(new Date());
			try {
				LMSBookLocalServiceUtil.updateLMSBook(lmsBook);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}

		return lmsBook;
	}

	public List<LMSBook> searchBooks(String bookTitle) throws SystemException {
		// return lmsBookPersistence.findByBookTitle(bookTitle);

		// dynamic Query

		/*
		 * DynamicQuery dynamicQuery =
		 * 
		 * DynamicQueryFactoryUtil.forClass(LMSBook.class); Property bookTitleProperty =
		 * PropertyFactoryUtil.forName("bookTitle"); dynamicQuery.add(bookTitleProperty.like("%" +
		 * bookTitle + "%")); return dynamicQuery(dynamicQuery);
		 */

		return LMSBookFinderUtil.findBooks("%" + bookTitle + "%");
	}

	@Override
	public List<LMSBook> searchBooks(String bookTitle, long companyId, long groupId)
			throws SystemException {
		return null;
	}

	public List<LMSBorrowing> getBorrowings(long bookId) throws SystemException {
		// return lmsBookPersistence.getLMSBorrowings(bookId);

		return LMSBorrowingUtil.findByBookId(bookId);
	}
}