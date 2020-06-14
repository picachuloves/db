<%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 29.05.2020
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selects</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-gray">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Welcome!</h1>
</div>
<div class="w3-container w3-center">       <!-- content -->
    <div class="w3-bar-block w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select1'">Перечень и общее число фирм, забронировавших места в объеме, не менее указанного, за весь период сотрудничества, либо за некоторый период.</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select2'">Перечень и общее число постояльцев, заселявшихся в номера с указанными характеристиками за некоторый период.</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select4'">Сведения о количестве свободных номеров с указанными характеристиками.</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select8'">Получить список недовольных клиентов и их жалобы.</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select11'">Получить сведения о фирмах, с которыми заключены договора о брони на указанный период.</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select13'">Получить сведения о новых клиентах за указанный период.</button>
    </div>
</div>
</body>
</html>
