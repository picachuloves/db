<%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 16.06.2020
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Function</title>
    <link rel="stylesheet" href="styles/w3.css">
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .form-container input[type=text] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
        }

        .form-container input[type=text]:focus {
            background-color: #ddd;
            outline: none;
        }
    </style>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <div class="w3-responsive">
        <div class="w3-card-4">
            <div class="w3-container w3-center w3-green">
                <h2>Choose parameter for function</h2>
            </div>
            <form method="post" class="w3-select w3-light-grey w3-padding">
                <label>id_contract:
                    <input type="number" min="1"  required name="id_contract"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
            </form>
        </div>
        <br><br>
        <label class="w3-green">Result: <%=request.getAttribute("result")%></label>
    </div>
</div>
</body>
</html>
