<%@ page import="servlets.selects.Select5Servlet" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 15.06.2020
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selects</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Selects</h1>
    <div class="w3-responsive">
        <input id="myInput" type="text" placeholder="Search.." style="width:80%;">
        <br><br>
        <table id="Table">
            <thead>
            <tr class="header">
                <th style="width:17%;">id</th>
                <th style="width:17%;">living_start</th>
                <th style="width:17%;">floor</th>
                <th style="width:17%;">people_number</th>
                <th style="width:16%;">service_cost_per_day</th>
                <th style="width:16%;">min_price</th>
            </tr>
            </thead>
            <tbody id="myTable">
            <%
                List<Select5Servlet.Table> list = (List<Select5Servlet.Table>) request.getAttribute("list");

                if (list != null && !list.isEmpty()) {
                    for (Select5Servlet.Table c : list) {
                        out.println("<tr>");
                        out.println("<th>" + c.getId() + "</th>");
                        out.println("<th>" + c.getLiving_start() + "</th>");
                        out.println("<th>" + c.getFloor() + "</th>");
                        out.println("<th>" + c.getPeople_number() + "</th>");
                        out.println("<th>" + c.getService_cost_per_day() + "</th>");
                        out.println("<th>" + c.getMin_price() + "</th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"  +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no negative reviews!</h5>\n" +
                        "</div>");
            %>
            </tbody>
        </table>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='..'">Back to main</button>
        </div>
    </div>
</div>
</body>
