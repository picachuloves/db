<%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 09.06.2020
  Time: 19:56
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
    <h1>Here you can add new reservation</h1>
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
            <h2>Add reservation</h2>
        </div>

        <form method="post" class="w3-select w3-light-grey w3-padding">
            <label>Partner:
                <input type="number" min="1" required name="res_partner"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Stars number:
                <input type="number" min="1" max="5" required name="stars_number"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Floor number:
                <input type="number" min="1" max="150" required name="floor_number"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Date start:
                <input type="date"  required name="res_date_start"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Date end:
                <input type="date"  required name="res_date_end"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Discount:
                <input type="number" min="1" max="100" required name="discount"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/reservations'">Back to list</button>
</div>
</body>
</html>
