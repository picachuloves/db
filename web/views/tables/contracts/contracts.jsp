<%@ page import="model.Contracts" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 29.05.2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contracts</title>
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
    <h1>Contracts</h1>
    <div class="w3-responsive">
        <input id="myInput" type="text" placeholder="Search.." style="width:80%;">
        <br><br>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/addContract'">Add contract</button>
        <table id="Table">
            <thead>
            <tr class="header">
                <th style="width:14%;">contract_number</th>
                <th style="width:14%;">id_client</th>
                <th style="width:13%;">id_room</th>
                <th style="width:13%;">living_start</th>
                <th style="width:13%;">living_end</th>
                <th style="width:13%;">id_reservation</th>
                <th style="width:20%;">Action</th>
            </tr>
            </thead>
            <tbody id="myTable">
            <%
                List<Contracts> list = (List<Contracts>) request.getAttribute("list");

                if (list != null && !list.isEmpty()) {
                    for (Contracts c : list) {
                        out.println("<tr>");
                        out.println("<th>" + c.getContract_number() + "</th>");
                        out.println("<th>" + c.getId_client() + "</th>");
                        out.println("<th>" + c.getId_room() + "</th>");
                        out.println("<th>" + c.getLiving_start() + "</th>");
                        out.println("<th>" + c.getLiving_end() + "</th>");
                        out.println("<th>" + c.getId_reservation() + "</th>");
                        out.println("<th>" + "<div class=\"w3-container\"><form action=\"editContract\" style='float:left;'><input type=\"hidden\" name=\"id\" value=\"" + c.getContract_number() + "\"  /><button type=\"submit\" class=\"w3-button w3-khaki\" name=\"edit\"  >Edit</button></form>" + " &nbsp&nbsp&nbsp&nbsp" + "<form method=\"post\" style='float:right;'><button type=\"submit\" class=\"w3-button w3-khaki\" name=\"delete\"  value=\"" + c.getContract_number() + "\" >Delete</button> </form></div>" + "</th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"  +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no contracts yet!</h5>\n" +
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
</html>
