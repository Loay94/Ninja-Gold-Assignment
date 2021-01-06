<%--
  Created by IntelliJ IDEA.
  User: jodhl
  Date: 1/5/2021
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/ninjagold.css">
    <title>Ninja Gold </title>
</head>
<body>
<header>
    <form action="/process" method="POST">
        <label for="gold">Your Gold </label>
        <input id="gold" type="hidden" name="gold_values" value="gold_values">
        <h1><%= session.getAttribute("number")%></h1>
    </form>
</header>
<main>
    <div class="box">
        <h1>Farm</h1>
        <h3>(earn 10-20 golds)</h3>
        <form action="/process" method="POST">
            <input type="hidden" name="value" value="farm_values">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="box">
        <h1>Cave</h1>
        <h3>(earn 5-10 golds)</h3>
        <form action="/process" method="POST">
            <input type="hidden" name="value" value="cave_values">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="box">
        <h1>House</h1>
        <h3>(earn 2-5 golds)</h3>
        <form action="/process" method="POST">
            <input type="hidden" name="value" value="house_values">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="box">
        <h1>Casino</h1>
        <h3>(earn/takes 0-50 golds)</h3>
        <form action="/process" method="POST">
            <input type="hidden" name="value" value="casino_values">
            <input type="submit" value="Find Gold">
        </form>
    </div>
</main>
<aside>
    <p class="index"> Activites:</p>
    <div class="results">
        <p><span style="color: green "><%= session.getAttribute("describtion")%></span><span style="color: red "><%= session.getAttribute("describtionred")%></span> </p>
    </div>
    <form action="/reset">
        <input type="submit" value="Reset" name="Reset">
    </form>
</aside>
</body>
</html>
