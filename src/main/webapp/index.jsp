<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%

    String msg = request.getParameter("msg");
    if(msg == null){
        msg = "";
    }


%>

<!DOCTYPE html>
<html>
<head>
    <title>Index </title>
</head>
<body>

<form action="login" method="post">

    <div>
        <input type="text" name="field_user" placeholder="Informe seu usuario">
    </div>

    <div>
        <input type="text" name="field_password" placeholder="Informe sua senha" >
    </div>

    <input type="submit">
    <p> <%= msg  %> </p>

</form>

</body>
</html>