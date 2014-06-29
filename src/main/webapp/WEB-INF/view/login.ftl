<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

    <form action="${request.contextPath}/login/auth" method="post">
        <input type="text" name="username" required="true">
        <input type="submit" value="submit"/>
    </form>

</body>
</html>