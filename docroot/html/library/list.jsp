<%@include file="/html/init.jsp"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>

<% 

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", LibraryConstants.PAGE_LIST);

PortletURL deleteBookURL = renderResponse.createActionURL();
deleteBookURL.setParameter(ActionRequest.ACTION_NAME, LibraryConstants.ACTION_DELETE_BOOK);
deleteBookURL.setParameter("redirectURL", iteratorURL.toString());

PortletURL bookDetailsURL = renderResponse.createRenderURL();
bookDetailsURL.setParameter("jspPage", LibraryConstants.PAGE_DETAILS);
bookDetailsURL.setParameter("backURL", themeDisplay.getURLCurrent());

List<LMSBook> books = LMSBookLocalServiceUtil.getLMSBooks(-1, -1);
List<LMSBook> allbooks = new ArrayList<LMSBook>(books);

String orderByCol = (String) request.getAttribute("orderByCol");
String orderByType = (String) request.getAttribute("orderByType");


BeanComparator comp = new BeanComparator(orderByCol);
Collections.sort(allbooks, comp);
if (orderByType.equalsIgnoreCase("desc")) {
Collections.reverse(allbooks);
}

%>

<h1>List of books in our Library</h1>
<liferay-ui:search-container delta="5" deltaConfigurable="true" iteratorURL="<%= iteratorURL %>" orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>">
<liferay-ui:search-container-results results="<%= ListUtil.subList(allbooks,searchContainer.getStart(), searchContainer.getEnd())%>" total="<%= LMSBookLocalServiceUtil.getLMSBooksCount() %>"/>
	<liferay-ui:search-container-row className="com.slayer.model.LMSBook" modelVar="book" keyProperty="bookId">
		
		<portlet:renderURL var="rowURL"> 
			<!--<portlet:param name="backURL" value="" />--> 
			<% bookDetailsURL.setParameter("bookId",Long.toString(book.getBookId())); %>
			<portlet:param name="bookId" value="<%= String.valueOf(book.getBookId()) %>" /> <portlet:param name="click" value="link"/> 
		</portlet:renderURL>
		
			
		<liferay-ui:search-container-column-text name="Book Title" property="bookTitle" orderable="true" orderableProperty="bookTitle" href="<%= bookDetailsURL.toString() %>"/>
		<liferay-ui:search-container-column-text name="Author" property="author" orderable="true" orderableProperty="author" />
		<liferay-ui:search-container-column-text name="Date Added">
			<fmt:formatDate value="<%= book.getCreateDate() %>" pattern="dd/MM/yyyy" />
		</liferay-ui:search-container-column-text>
		<% deleteBookURL.setParameter("bookId", Long.toString(book.getBookId())); %>
		<liferay-ui:search-container-column-text name="Delete"
								href="<%= deleteBookURL.toString() %>" value="delete"/>
								<liferay-ui:search-container-column-jsp name="Actions"
path="<%= LibraryConstants.PAGE_ACTIONS %>" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

