<%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 08.06.2020
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HotelWEB</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-light-grey w3-opacity w3-center">
    <h1>Here you can add new service</h1>
</div>

<div class="w3-container w3-padding">
    <%
        if (request.getAttribute("answer") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Successful!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add service</h2>
        </div>

        <form method="post" class="w3-select w3-light-grey w3-padding">
            <label>Services:
                <input type="text" name="services" required class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Services allowance:
                <input type="number" step="0.01" required value='50.00' min="50" max="100" name="services_allowance" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Food:
                <input type="text" name="food" required class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Food allowance:
                <input type="number" step="0.01" required value='10.00' min="10" max="100" name="food_allowance" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Entertainments:
                <input type="text" name="entertainments" required class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Entertainments allowance:
                <input type="number" step="0.01" value='10.00' min="10" max="400" name="entertainments_allowance" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/services'">Back to list</button>
</div>
</body>
</html>
