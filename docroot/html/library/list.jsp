<%@include file="/html/init.jsp"%>

<h1>List of books in our Library</h1>

<%
	List<LMSBook> books = LMSBookLocalServiceUtil.getLMSBooks(-1, -1);
%>

<table border="1" width="80%">
	<thead>
		<tr>
			<th>Book Title</th>
			<th>Author</th>
			<th>Date Added</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (LMSBook book : books) {
		%>
		<tr>
			<td><%=book.getBookTitle()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getCreateDate()%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<br />
<a href="<portlet:renderURL/>">&laquo; Go Back</a>
