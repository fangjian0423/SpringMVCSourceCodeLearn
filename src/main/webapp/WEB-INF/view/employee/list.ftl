<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery-1.11.0.js"></script>
</head>
<style>
    table {
        margin-top: 10px;
        border: 1px solid;
        border-collapse: collapse;
    }
    table th, table td {
        border: 1px solid;
        text-align: center;
    }
    .oddBg {
        background-color: #008200;
    }
    .evenBg {
        background-color: #677288;
    }
</style>
<body>
    <div>
        <input type="button" value="xml test" class="ajaxXmlBtn"/>
        <input type="button" value="json test" class="ajaxJsonBtn"/>
    </div>
    <div>
        <input type="button" value="xml test simple" class="ajaxXmlSimpleBtn"/>
        <input type="button" value="json test simple" class="ajaxJsonSimpleBtn"/>
    </div>
    <div>
        <input type="button" value="添加员工" class="addEmployeeBtn"/>
        <input type="button" value="添加部门" class="addDeptBtn"/>
    </div>
    <table width="50%">
        <thead>
            <tr>
                <th width="10%">id</th>
                <th width="25%">姓名</th>
                <th width="10%">年龄</th>
                <th width="35%">所属部门</th>
                <th width="20%">操作</th>
            </tr>
        </thead>
        <tbody>
            <#list list as employee>
            <tr class=<#if employee_index % 2 == 0>'oddBg'<#else>'evenBg'</#if>>
                <td class="id">${employee.id}</td>
                <td>${(employee.name)!}</td>
                <td>${(employee.age)!}</td>
                <td>${(employee.dept.name)!}</td>
                <td>
                    <input type="button" value="删除" class="delBtn"/>
                    <a href="detail/${employee.id}">详情</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>

</body>

<script type="text/javascript">

    $(document).ready(function() {
        $('.delBtn').click(function() {
            var _this = $(this);
            var id = _this.parents("td").prevAll(".id").html();
            var url = "${request.contextPath}/employee/delete/"+id;
            $.post(url, {employeeId: id}, function(res) {
                if(res === 'success') {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert("删除失败");
                }
            });
        });
        $('.addEmployeeBtn').click(function() {
            if(window.location.href.charAt(window.location.href.length - 1) === '/') {
                window.location.href = window.location.href + "add";
            } else {
                window.location.href = window.location.href + "/add";
            }
        });
        $('.addDeptBtn').click(function() {
            var ret = window.prompt("部门名称");
            if(ret) {
                var url = "${request.contextPath}/dept/update";
                $.post(url, {name: ret}, function(res) {
                    if(res === 'success') {
                        alert("添加成功");
                    } else {
                        alert("添加失败");
                    }
                });
            }
        });
        $('.ajaxXmlBtn').click(function() {
            $.ajax({
                url: "${request.contextPath}/employee/xmlOrJson",
                success: function(res) {
                    console.log(res);
                },
                headers: {
                    "Accept": "application/xml"
                }
            });
        });
        $('.ajaxJsonBtn').click(function() {
            $.ajax({
                url: "${request.contextPath}/employee/xmlOrJson",
                success: function(res) {
                    console.log(res);
                },
                headers: {
                    "Accept": "application/json"
                }
            });
        });
        $('.ajaxXmlSimpleBtn').click(function() {
            $.ajax({
                url: "${request.contextPath}/employee/xmlOrJsonSimple",
                success: function(res) {
                    console.log(res);
                },
                headers: {
                    "Accept": "application/xml"
                }
            });
        });
        $('.ajaxJsonSimpleBtn').click(function() {
            $.ajax({
                url: "${request.contextPath}/employee/xmlOrJsonSimple",
                success: function(res) {
                    console.log(res);
                },
                headers: {
                    "Accept": "application/json"
                }
            });
        });
    });
</script>

</html>