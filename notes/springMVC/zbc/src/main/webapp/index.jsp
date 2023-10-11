<%--
  Created by IntelliJ IDEA.
  User: zbc1
  Date: 2021/7/26
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>

    <script type="text/javascript">
        $(function () {
            // $("button").click(function() {
            $("#btn").click(function() {
                $.ajax({
                    url: "Void/some.do",
                    data: {data1: "zbc", data2: 12},
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        alert(resp.name)
                    }
                })
            })
        })
    </script>

    <script type="text/javascript">
        $(function () {
            $("#btn2").click(function() {
                $.ajax({
                    url: "Void/some2.do",
                    data: {data1: "zbc", data2: 12},
                    type: "post",
                    dataType: "text",
                    success: function (resp) {
                        alert("返回的字符串是"+resp)
                    }
                })
            })
        })
    </script>


</head>
<body>

<h5>------------</h5>
<h1>ModelAndView</h1>
<h5>------------</h5>

<p><a href="test/some.do">发起请求</a></p>
<p><a href="test/some1.do">发起请求1</a></p>

<form action="test/someB.do?name=zbc" method="POST">
    age<input type="text" name="age"><br/>
    <input type="submit" value="post请求">
</form>

<form action="test/receiveProperty.do" method="POST">
    姓名<input type="text" name="nameA"><br/>
    年龄<input type="text" name="ageA"><br/>
    <input type="submit" value="post请求,逐个传参">
</form>


<form action="test/receiveObject.do" method="POST">
    姓名<input type="text" name="nameA"><br/>
    年龄<input type="text" name="ageA"><br/>
    <input type="submit" value="post请求，对象传参">
</form>

<h5>------------</h5>
<h1>String</h1>
<h5>------------</h5>

<form action="String/some.do" method="POST">
    姓名<input type="text" name="msg"><br/>
    <input type="submit" value="post请求">
</form>
<!--msg不能被响应页面展示-->
<h5>------------</h5>
<h1>Void</h1>
<h5>------------</h5>

<button id="btn">发起ajax请求，返回对象</button>

<button id="btn2">发起ajax请求，返回字符串</button>

<h5>------------</h5>
<h1>静态资源</h1>
<h5>------------</h5>

<img src="images/a.png" alt="我是一个静态资源" >


</body>
</html>
