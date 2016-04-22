<%@include file="/html/init.jsp"%>

<%
	PortletURL updateBookURL = renderResponse.createActionURL();
	updateBookURL.setParameter(ActionRequest.ACTION_NAME,
	LibraryConstants.ACTION_UPDATE_BOOK);
%>

<!-- formulário  -->
<h1>Add / Edit Form</h1>
<aui:form name="fm" method="POST" action="<%=updateBookURL.toString()%>">
	<aui:input name="bookTitle" label="Book Title">
		<aui:validator name="required"
			errorMessage="Este campo é Obrigatório!" />
	</aui:input>
	<aui:input name="author">
		<aui:validator name="required"
			errorMessage="Este campo é Obrigatório!" />
	</aui:input>
	<aui:button type="submit" value="Save" />
</aui:form>
<br />
<a href="<portlet:renderURL/>">&laquo; Go Back</a>
<aui:script>
	Liferay.Util
			.focusFormField(document.<portlet:namespace/>fm.<portlet:namespace/>bookTitle);
</aui:script>
	