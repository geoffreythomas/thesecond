<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/framework/jsp/commonDef.jspf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ubuntu 01 Webapp Welcome</title>
<jsp:include page="/framework/jsp/commonInclude.jsp"></jsp:include>
</head>
<body>
Welcome to Ubuntu 01 Webapp.
<br>
<jsp:include page="framework/jsp/menu.jsp"></jsp:include>
<br>
Let us start the <a href="view/magic.jsp">magic</a>.
Let us start <a href="view/magic.jsp">EXT JS</a>.
Let us start <a href="identities.do?action=listAllUsers">Spring MVC</a>.
<br>
<a href="identities.do?action=listAllUsers">List Users</a>.
<a href="identities.do?action=prepareAddUser">Add User</a>
1
</body>
</html>