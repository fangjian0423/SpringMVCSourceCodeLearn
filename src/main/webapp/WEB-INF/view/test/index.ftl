<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery-1.11.0.js"></script>
</head>
<body>

    <input type="button" value="testRb"/>

</body>

<script type="text/javascript">

    $(document).ready(function() {

        var params = {name:1, age: 3};

        $("input[value=testRb]").click(function() {
            $.ajax({
                method: 'post',
                url: '${request.contextPath}/test/testRb',
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(resp) {
                    console.log(resp);
                }
            });
        });

    });

</script>

</html>