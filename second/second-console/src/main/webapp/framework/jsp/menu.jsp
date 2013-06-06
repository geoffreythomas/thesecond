<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/framework/jsp/commonDef.jspf" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ubuntu 01 Webapp Menu</title>
<jsp:include page="/framework/jsp/commonInclude.jsp"></jsp:include>
</head>
<body>
The menu.

<div id="main-menu"/>
</body>
</html>

<script language="javascript">
Ext.onReady(function(){

	var mySplitButton = Ext.create('Ext.button.Split', {
	    text: 'Home',
	    handler: function() {
	        var myForm = Ext.create('Ext.form.Panel', {
	            title: 'myForm',
	            standardSubmit: true,
	            url: '<c:out value="${pageContext.request.contextPath}"/>',
	        });
	        myForm.submit();
	    },
	    menu: new Ext.menu.Menu({
	        items: [
					{
						text: 'Magic', 
						handler: function() {
							var myForm = Ext.create('Ext.form.Panel', {
								title: 'myForm',
								standardSubmit: true,
								url: '<c:out value="${pageContext.request.contextPath}"/>/view/magic.jsp',
							});
						myForm.submit();
						}
		            },
					{
						text: 'EXT JS', 
						handler: function() {
							var myForm = Ext.create('Ext.form.Panel', {
								title: 'myForm',
								standardSubmit: true,
								url: '<c:out value="${pageContext.request.contextPath}"/>/view/magic.jsp',
							});
						myForm.submit();
						}
		            },
					{
						text: 'Spring MVC', 
						handler: function() {
							var myForm = Ext.create('Ext.form.Panel', {
								title: 'myForm',
								standardSubmit: true,
								url: '<c:out value="${pageContext.request.contextPath}"/>/identities.do?action=listAllUsers',
							});
						myForm.submit();
						}
		            },
					{
						text: 'List Users', 
						handler: function() {
							var myForm = Ext.create('Ext.form.Panel', {
								title: 'myForm',
								standardSubmit: true,
								url: '<c:out value="${pageContext.request.contextPath}"/>/identities.do?action=listAllUsers',
							});
						myForm.submit();
						}
		            },
					{
						text: 'Add User', 
						handler: function() {
							var myForm = Ext.create('Ext.form.Panel', {
								title: 'myForm',
								standardSubmit: true,
								url: '<c:out value="${pageContext.request.contextPath}"/>/identities.do?action=prepareAddUser',
							});
						myForm.submit();
						}
		            }
	        ]
	    })
	});
	
	Ext.create('Ext.toolbar.Toolbar', {
	    renderTo: 'main-menu',
	    width   : 500,
	    items: [
	        mySplitButton
	    ]
	});
});
</script>