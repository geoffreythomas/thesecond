<%@ page session="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- Start mainLayout -->

<!-- Start header -->
<tiles:insertAttribute name="header" defaultValue="This is the default header." defaultValueType="template"/>
<!-- End header -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Start title -->
    <title>
      <tiles:insertAttribute name="title" defaultValue="This is the default title."/>
    </title>
<!-- End title -->
  </head>
  <body>
    <table>
      <tr>
        <td>
<!-- Start menu -->
          <tiles:insertAttribute name="menu" defaultValue="This is the default menu." defaultValueType="template"/>
<!-- End menu -->
        </td>
      </tr>
      <tr>
        <td>
<!-- Start body -->
          <tiles:insertAttribute name="body" defaultValue="This is the default body."/>
<!-- End body -->
        </td>
      </tr>
    </table>
  </body>
</html>
<!-- End mainLayout -->