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
    <style>
        .btn-group button {
            background-color: #4CAF50; /* Green background */
            border: 1px solid green; /* Green border */
            color: white; /* White text */
            padding: 10px 24px; /* Some padding */
            cursor: pointer; /* Pointer/hand icon */
            width: 50%; /* Set a width if needed */
            display: block; /* Make the buttons appear below each other */
        }

        .btn-group button:not(:last-child) {
            border-bottom: none; /* Prevent double borders */
        }

        /* Add a background color on hover */
        .btn-group button:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body class="w3-light-gray">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Welcome!</h1>
</div>
<div class="w3-container w3-center">       <!-- content -->
    <div class="btn-group w3-center w3-padding-large w3-padding-24">
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large"  onclick="location.href='/select1'">1. Перечень и общее число фирм, забронировавших места в объеме, не менее указанного, за весь период сотрудничества, либо за некоторый период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select2'">2. Перечень и общее число постояльцев, заселявшихся в номера с указанными характеристиками за некоторый период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select4'">4. Сведения о количестве свободных номеров с указанными характеристиками.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select5'">5. Сведения о конкретном свободном номере: в течение какого времени он будет пустовать и о его характеристиках.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select6'">6. Получить список занятых сейчас номеров, которые освобождаются к указанному сроку.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select8'">8. Получить список недовольных клиентов и их жалобы.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select9'">9. Получить данные о рентабельности номеров с определенными характеристиками: соотношение об объеме продаж номеров к накладным расходам за указанный период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select10'">10. Получить сведения о постояльце из заданного номера: счет за дополнительные услуги, жалобы, виды дополнительных услуг.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select11'">11. Получить сведения о фирмах, с которыми заключены договора о брони на указанный период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select12'">12. Получить сведения о наиболее часто посещающих гостиницу постояльцах.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select13'">13. Получить сведения о новых клиентах за указанный период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select14'">14. Получить сведения о конкретном человеке, сколько раз он посещал гостиницу, в каких номерах и в какой период останавливался, какие счета оплачивал.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select15'">15. Получить сведения о конкретном номере: кем он был занят в определенный период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/select15'">15. Получить сведения о конкретном номере: кем он был занят в определенный период.</button>
        <button style="width: 100%" class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/function'">Посчитать счет для контракта.</button>

    </div>
</div>
</body>
</html>
