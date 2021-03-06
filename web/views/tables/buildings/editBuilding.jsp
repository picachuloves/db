<%@ page import="model.Buildings" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 08.06.2020
  Time: 23:18
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
    <h1>Here you can edit the building</h1>
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
            <h2>Edit service</h2>
        </div>
        <%Buildings building = (Buildings) request.getAttribute("building");%>
        <form method="post" class="w3-select w3-light-grey w3-padding">
            <label>Stars number:
                <input type="number" name="stars_number" min="1" max="5" required value='<%=building.getStars_number()%>' class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Floors number:
                <input type="number" min="1" max="149" required name="floors_number" value="<%=building.getFloors_number()%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Rooms number:
                <input type="number" min="50" max="29999" required name="rooms_number" value="<%=building.getRooms_number()%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Rooms per floor number:
                <input type="number" min="1" max="199"  required name="rooms_per_floor_number" value="<%=building.getRooms_per_floor_number()%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Building min price:
                <input type="number" step="0.01" min="101" max="10000" required name="building_min_price" value="<%=building.getBuilding_min_price()%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Id added service:
                <input type="number" min="1"  required name="id_add_services" value="<%=building.getId_add_services()%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/buildings'">Back to list</button>
</div>
</body>
</html>
