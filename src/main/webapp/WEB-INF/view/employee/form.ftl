<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery-1.11.0.js"></script>
</head>
<style>
    table {
        border: 1px solid;
        border-collapse: collapse;
        text-align: center;
    }
    table tr, table td{
        border: 1px solid;
    }
    .title {
        background-color: #00ff00;
    }
    .content {
        background-color: #ff0000;
    }
</style>
<body>
    <h2>
        <#if employee??>修改<#else>添加</#if>员工
    </h2>
    <form action="${request.contextPath}/employee/update" method="post">
        <table width="50%">
            <tbody>
                <#if (employee.id)?exists>
                <tr>
                    <td width="30%" class="title">id</td>
                    <td width="70%" class="content">
                        ${employee.id}
                        <input type="hidden" value="${employee.id}" name="id"/>
                    </td>
                </tr>
                </#if>
                <tr>
                    <td class="title">姓名</td>
                    <td class="content">
                        <input type="text" value="${(employee.name)!}" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td class="title">年龄</td>
                    <td class="content">
                        <input type="text" value="${(employee.age)!}" name="age"/>
                    </td>
                </tr>
                <tr>
                    <td class="title">所属部门</td>
                    <td class="content">
                        <select name="dept.id">
                            <option value="">...</option>
                            <#list depts as dept>
                                <option value="${dept.id}" <#if employee?? && dept.id == employee.dept.id>selected</#if>>${dept.name}</option>
                            </#list>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="提交"/>
                        <input type="button" value="返回" onclick="javascript: window.history.go(-1)"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

</body>

<script type="text/javascript">

</script>

</html>