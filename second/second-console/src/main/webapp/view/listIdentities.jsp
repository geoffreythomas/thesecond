<%@ include file="/framework/jsp/commonInclude.jspf" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Identities</title>
</head>
<body>
<table>
<tr>
<td>
<%@ include file="/framework/jsp/menu.jspf" %>
</td>
</tr>
<tr>
<td>
All Identities
<c:out   value="${identities}"   />
</td>
</tr>
</table>
</body>
</html>