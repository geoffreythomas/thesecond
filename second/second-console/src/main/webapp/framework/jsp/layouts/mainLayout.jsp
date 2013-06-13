<%@ page session="false" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertAttribute name="header" defaultValue="/framework/jsp/commonInclude.jsp" defaultValueType="template"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" defaultValue="This is the default title."/></title>
</head>
<body>
<table>
<tr>
<td>
<tiles:insertAttribute name="menu" defaultValue="/framework/jsp/menu.jspf" defaultValueType="template"/>
</td>
</tr>
<tr>
<td>
<tiles:insertAttribute name="body" defaultValue="This is the default body in the tag."/>
</td>
</tr>
</table>
</body>
</html>