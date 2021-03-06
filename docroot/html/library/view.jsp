<%@include file="/html/init.jsp"%>

<portlet:renderURL var="updateBookURL">
	<portlet:param name="jspPage" value="<%=LibraryConstants.PAGE_UPDATE%>" />
</portlet:renderURL>
<br />
<a href="<%=updateBookURL%>">Add new Book &raquo;</a>
<hr />

<%
	PortletURL listBooksURL = renderResponse.createRenderURL();
	listBooksURL.setParameter("jspPage", LibraryConstants.PAGE_LIST);
%>


<hr />
<portlet:actionURL var="searchBooksURL" name="<%=LibraryConstants.ACTION_SEARCH_BOOKS%>" />
<aui:form action="<%=searchBooksURL.toString()%>">
	<aui:input name="searchTerm" label="Enter Title to search" />
	<aui:button type="submit" value="Search" />
</aui:form>

&nbsp;|&nbsp;
<a href="<%=listBooksURL.toString()%>">Show All Books &raquo;</a>

<!-- 
<a href="javascript:void();" id="jqueryText">jQuery in action</a>
<div id="sayHelloDiv" style="display: none">jQuery is working</div>


<script type="text/javascript">
	$(document).ready(function() {
		$('#jqueryText').on('click', function() {
			$('#sayHelloDiv').toggle();
		});
	});
</script>
<hr />
<div id="tabs">
	<ul>

		<li><a href="#tabs-1">Tab One</a></li>
		<li><a href="#tabs-2">Tab Two</a></li>
		<li><a href="#tabs-3">Tab Three</a></li>
	</ul>
	<div id="tabs-1">Tab 1 content</div>
	<div id="tabs-2">Tab 2 content</div>
	<div id="tabs-3">Tab 3 content</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#tabs").tabs();
	});
</script>

 -->