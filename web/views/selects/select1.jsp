<%@ page import="servlets.selects.Select1Servlet" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 13.06.2020
  Time: 2:04
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
    <div class="w3-responsive">
        <div class="w3-card-4">
            <div class="w3-container w3-center w3-green">
                <h2>Choose parameters for select</h2>
            </div>
            <form method="post" class="w3-select w3-light-grey w3-padding">
                <label>Date start:
                    <input type="date" name="start"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <label>Date end:
                    <input type="date" name="end"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <label>Count:
                    <input type="number" min="0" required name="count"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
            </form>
        </div>
        <input id="myInput" type="text" placeholder="Search.." style="width:80%;">
        <br><br>
        <%
            List<Select1Servlet.Table> list = (List<Select1Servlet.Table>)request.getAttribute("list");
            if (list != null && !list.isEmpty()) {
                out.println("<table id=\"Table\">\n" +
                        "            <thead>\n" +
                        "            <tr class=\"header\">\n" +
                        "                <th style=\"width:33%;\">contract_number</th>\n" +
                        "                <th style=\"width:34%;\">information</th>\n" +
                        "                <th style=\"width:33%;\">count</th>\n" +
                        "            </tr>\n" +
                        "            </thead>\n" +
                        "            <tbody id=\"myTable\">");
                for (Select1Servlet.Table c : list){
                    out.println("<tr>");
                    out.println("<th>" + c.getContract_number() + "</th>");
                    out.println("<th>" + c.getInformation() + "</th>");
                    out.println("<th>" + c.getCount() + "</th>");
                    out.println("</tr>");
                }
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"  +
            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
            "   <h5>Select is empty!</h5>\n" + "</div>");
            out.println("</tbody>\n" +
                    "        </table>");
        %>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='..'">Back to main</button>
        </div>
    </div>
</div>

</body>
</html>
