package com.library;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.service.LMSBookLocalServiceUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.transaction.SystemException;

public class LibraryPortlet extends MVCPortlet {
	public void updateBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");
		String author = ParamUtil.getString(actionRequest, "author");

		insertBook(bookTitle, author);
	}

	private void insertBook(String bookTitle, String author) {
		// 1. Instanciar um objeto vazio do tipo LMSBookImpl
		LMSBook lmsBook = new LMSBookImpl();

		// 2. Gerar uma chave primária única a ser definido
		long bookId = 01;

		try {
			bookId = CounterLocalServiceUtil.increment();
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			e.printStackTrace();
		}

		// 3. Defina os campos para este objeto
		lmsBook.setBookId(bookId);
		lmsBook.setBookTitle(bookTitle);
		lmsBook.setAuthor(author);
		lmsBook.setCreateDate(new Date());

		// 4. Chamar a API Service Layer para persistir o objeto
		try {
			lmsBook = LMSBookLocalServiceUtil.addLMSBook(lmsBook);
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			e.printStackTrace();
		}
	}
}
