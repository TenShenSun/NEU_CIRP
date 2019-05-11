<!-- 不加这句话，${user.id}无法解析-->
<%@ page isELIgnored="false"%>
<html>
<body>
<%= request.getAttribute("user") %>
<h2>Hello World!,${user.id}</h2>
</body>
</html>
