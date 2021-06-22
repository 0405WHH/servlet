
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!-- java 程序段-->
  <%
    String name = (String) request.getSession().getAttribute("name");
    out.println("name:" + name);

    String rname = (String) request.getAttribute("rname");
    out.println("rname:" + rname);
  %>
  </body>
</html>
