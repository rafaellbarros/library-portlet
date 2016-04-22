package com.library;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.service.LMSBookLocalServiceUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.transaction.SystemException;

public class LibraryPortlet extends MVCPortlet {
	public void updateBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");
		String author = ParamUtil.getString(actionRequest, "author");
		System.out.println("Hello ===>>>>>" + bookTitle + author);
		insertBook(bookTitle, author);

		// redirect after insert
		// redireciona depois de inserir
		// String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		// actionResponse.sendRedirect(redirectURL);

		redirectSuccess(actionRequest, actionResponse);
	}

	private void redirectSuccess(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {
		// WebKeys é uma interface que contém as definições para as teclas comumente usados em toda
		// a base de código do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute("javax.portlet.config");

		String portletName = portletConfig.getPortletName();

		PortletURL successPageURL = PortletURLFactoryUtil.create(actionRequest, portletName
				+ "_WAR_" + portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		successPageURL.setParameter("jspPage", LibraryConstants.PAGE_SUCCESS);
		actionResponse.sendRedirect(successPageURL.toString());
	}

	public LMSBook insertBook(String bookTitle, String author) {
		// 1. Instanciar um objeto vazio do tipo LMSBookImpl
		LMSBook lmsBook = new LMSBookImpl();

		// 2. Defina os campos para este objeto

		lmsBook.setBookTitle(bookTitle);
		lmsBook.setAuthor(author);
		lmsBook.setCreateDate(new Date());

		try {
			lmsBook = LMSBookLocalServiceUtil.addLMSBook(lmsBook);
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			e.printStackTrace();
		}
		return lmsBook;
	}

}
