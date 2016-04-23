package com.library;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.slayer.service.LMSBookLocalServiceUtil;
import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class LibraryPortlet extends MVCPortlet {
	public void updateBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");
		String author = ParamUtil.getString(actionRequest, "author");


		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		if (bookId > 0l) {
			LMSBookLocalServiceUtil.modifyBook(bookId, bookTitle, author);
		} else {
			LMSBookLocalServiceUtil.insertBook(bookTitle, author);
		}

		// redirect after insert
		// redireciona depois de inserir
		// String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		// actionResponse.sendRedirect(redirectURL);

		redirectSuccess(actionRequest, actionResponse);
	}


	public void deleteBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		if (bookId > 0) {// valid bookId
			try {
				LMSBookLocalServiceUtil.deleteLMSBook(bookId);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}

		// gracefully redirecting to the list view
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);
	}

	private void redirectSuccess(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {
		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		// WebKeys é uma interface que contém as definições para as teclas comumente usados em toda
		// a base de código do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute("javax.portlet.config");

		String portletName = portletConfig.getPortletName();

		PortletURL successPageURL = PortletURLFactoryUtil.create(actionRequest, portletName
				+ "_WAR_" + portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		successPageURL.setParameter("jspPage", (bookId > 0l)?
				LibraryConstants.PAGE_LIST : LibraryConstants.PAGE_SUCCESS);
		actionResponse.sendRedirect(successPageURL.toString());
	}

}
