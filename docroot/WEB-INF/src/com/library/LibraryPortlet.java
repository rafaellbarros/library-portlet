package com.library;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

public class LibraryPortlet extends MVCPortlet {
	public void updateBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");
		String author = ParamUtil.getString(actionRequest, "author");
		System.out.println("Your inputs ==> " + bookTitle + ", " + author);
	}
}
