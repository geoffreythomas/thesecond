<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/framework/jsp/commonDef.jspf" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Identities</title>
<jsp:include page="/framework/jsp/commonInclude.jsp"></jsp:include>
</head>
<body>
All Identities
<c:out   value="${identities}"   />

</body>
</html>